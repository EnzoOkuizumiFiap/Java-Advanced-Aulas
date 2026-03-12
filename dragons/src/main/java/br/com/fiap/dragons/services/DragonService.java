package br.com.fiap.dragons.services;

import br.com.fiap.dragons.models.Dragon;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class DragonService {
    private List<Dragon> repository =  new ArrayList<>();

    //Adicionar Dragão
    public Dragon addDragon(Dragon dragon) {
        dragon.setId(Math.abs(new Random().nextInt()));
        repository.add(dragon);
        return dragon;
    }

    //Pegar Todos os Dragões
    public List<Dragon> getALlDragons() {
        return repository;
    }

    //Pegar Dragão via Id
    public Optional<Dragon> getDragonById(int id) {
        return findDragonById(id);
    }

    //Deletar Dragão
    public void deleteDragon(int id) {
        repository.remove(findDragonById(id).get());
    }

    //Atualizar Dragão
    public Dragon updateDragon(int id, Dragon dragon) {
        repository.remove(findDragonById(id).get());
        dragon.setId(id);
        repository.add(dragon);

        return dragon;
    }

    //Função Pegar via Id
    private Optional<Dragon> findDragonById(int id) {
        var optionalDragon = repository.stream()
                .filter(dragon -> Objects.equals(dragon.getId(), id))
                .findFirst();

        //Se não encontrar, EXCEPTION
        if(optionalDragon.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dragão com id " + id +" não encontrado");
        }

        return optionalDragon;
    }
}
