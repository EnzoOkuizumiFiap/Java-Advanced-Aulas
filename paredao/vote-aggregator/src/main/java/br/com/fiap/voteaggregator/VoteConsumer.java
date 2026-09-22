package br.com.fiap.voteaggregator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@RequiredArgsConstructor
public class VoteConsumer {
    public static final String QUEUE_NAME = "voting-queue";
    private final VoteRegistryRepository voteRegistryRepository;

    // Concurrent -> podemos ter vários processos acessando a mesma chave / várias threads acessem o mapa de forma segura.
    // Hash -> utiliza uma estrutura baseada em hash para facilitar a busca pela chave.
    // Map -> Estrutura de Chave e Valor
    private final ConcurrentHashMap<String, Integer> votes = new ConcurrentHashMap<>();

    @RabbitListener(queues = QUEUE_NAME)
    public void consumeVote(String participanteId) {
        votes.merge(participanteId, 1, Integer::sum); // Está somando UM voto para o participante! Se não existir, cria e soma UM!
        log.info("Voto recebido para o participante: {}, total: {}",  participanteId, votes.get(participanteId));
    }


    // Recebe vários votos durante o intervalo e, a cada execução, persiste no banco os votos acumulados no mapa (votes).
    @Scheduled(fixedDelay = 3_000) // Agendar a execução desse metodo a cada 3s
    public void flush() {
        log.info("Flush dos votos");
        votes.forEach(this::persiste); // Para cada voto, persistir no Banco de Dados
        votes.clear(); // E limpa os votos temporários do mapa.
    }

    private void persiste(String participanteId, Integer totalVotes) {
        // Carregar o registro do participante no banco de dados
        var voteRegistry = voteRegistryRepository.findById(participanteId).orElseGet(
                // Se não existir, criar um novo registro com totalVotes = 0
                () -> new VoteRegistry(participanteId, 0)
        );

        // Soma os votos acumulados no mapa ao total de votos já registrado no banco. (Se existir, vem direto pra cá)
        voteRegistry.setTotalVotes(voteRegistry.getTotalVotes() + totalVotes);

        // Salvar o registro atualizado no banco de dados
        voteRegistryRepository.save(voteRegistry);
    }
}
