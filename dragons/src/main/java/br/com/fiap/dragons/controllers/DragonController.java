package br.com.fiap.dragons.controllers;

import br.com.fiap.dragons.models.Dragon;
import br.com.fiap.dragons.services.DragonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("dragons")
public class DragonController {
    @Autowired
    private DragonService service;

    //Listando todos os Dragons
    @GetMapping
    public List<Dragon> listAll() {
        return service.getALlDragons();
    }

    //Listar por Id
    @GetMapping("{id}")
    public ResponseEntity<Dragon> getDragonById(@PathVariable int id) {
        log.info("Filme: {}", id);

        return ResponseEntity
                .ok(service.getDragonById(id).orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                ));
    }

    //POST Dragão
    @PostMapping
    public ResponseEntity<Dragon> createDragon(@RequestBody Dragon dragon) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addDragon(dragon));
    }

    //DELETE Dragão
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDragon(@PathVariable int id) {
        log.info("Deletando Dragão com id {}", id);
        service.deleteDragon(id);

        return ResponseEntity.noContent().build();
    }

    //PUT Dragão
    @PutMapping("{id}")
    public ResponseEntity<Dragon> updateDragon(@PathVariable int id, @RequestBody Dragon dragon) {
        log.info("Atualizando Dragão com id {} com os dados {}", id, dragon);

        return ResponseEntity.ok(service.updateDragon(id, dragon));
    }
}
