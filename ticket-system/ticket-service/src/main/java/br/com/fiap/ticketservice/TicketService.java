package br.com.fiap.ticketservice;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final RestTemplate restTemplate;

    public record PaymentResponse(String status) {}

    @Transactional
    public void purchase(UUID id) {
        // buscar do BD - Ver se tem
        Ticket ticket = ticketRepository.findByIdForUpdate(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found with id: " + id)
        );

        // lançar exception
        if (ticket.getAvailable() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ticket not available for id: " + id);
        }

        // Esperando 500 milisegundos
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        PaymentResponse response = restTemplate.postForObject(
                "http://PAYMENT-SERVICE/payments",
                null,
                PaymentResponse.class
        );

        if (response == null ) {
            log.info("\uD83D\uDD34 Payment service did not respond.\"");
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Payment service did not respond");
        }

        // Se tiver: Diminuir
        ticket.setAvailable(ticket.getAvailable() - 1);

        // salvar - com o Transactional não precisamos salvar, pois ele salva automaticamente!
        //ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}
