package br.com.fiap.animes.Personagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
    List<Personagem> findByAnimeId(Long animeId);

    @RestController
    @RequestMapping("personagens")
    class PersonagemController {
        @Autowired
        private Personagem.PersonagemService service;

        @GetMapping
        public List<Personagem> ListAll(){
            return service.getAllPersonagens();
        }

        @GetMapping("anime/{id}")
        public List<Personagem> listAllByAnimeId(@PathVariable Long id) {
            return service.getAllPersonagensByAnimeId(id);
        }

        @GetMapping("{id}")
        public ResponseEntity<Personagem> getPersonagemById(@PathVariable Long id) {
            return ResponseEntity.ok(service.getPersonagemById(id));
        }


        @PostMapping
        public ResponseEntity<Personagem> createPersonagem(@RequestBody Personagem personagem) {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.addPersonagem(personagem));
        }

        @PutMapping("{id}")
        public ResponseEntity<Personagem> updatePersonagem(@PathVariable Long id, @RequestBody Personagem personagem) {
            return ResponseEntity.ok(service.updatePersonagem(id, personagem));
        }

        @DeleteMapping("{id}")
        public ResponseEntity<Void> deletePersonagem(@PathVariable Long id) {
            service.deletePersonagem(id);
            return ResponseEntity.noContent().build();
        }
    }
}
