package fiap.com.br.services.controller;

import fiap.com.br.services.model.Professional;
import fiap.com.br.services.service.ProfessionalService;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/professionals")
public class ProfessionalController {
    private final ProfessionalService professionalService;

    public ProfessionalController(ProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

    @GetMapping
    public List<EntityModel<Professional>> findAll() {
        return professionalService.findAll()
                .stream()
                .map(Professional::toEntityModel)
                .toList();
    }

    @GetMapping("{id}")
    public EntityModel<Professional> findById(@PathVariable Long id) {
        return professionalService.findById(id).toEntityModel();
    }

    @GetMapping("/location/{locationId}")
    public List<EntityModel<Professional>> findByLocationId(@PathVariable Long locationId) {
        return professionalService.findByLocationId(locationId)
                .stream()
                .map(Professional::toEntityModel)
                .toList();
    }

}
