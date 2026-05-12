package fiap.com.br.services.service;

import fiap.com.br.services.model.Professional;
import fiap.com.br.services.repository.ProfessionalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProfessionalService {
    private final ProfessionalRepository professionalRepository;

    public ProfessionalService(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }

    public List<Professional> findAll() {
        return professionalRepository.findAll();
    }

    public Professional findById(Long id) {
        return professionalRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professional not found!")
        );
    }

    public List<Professional> findByLocationId(Long locationId) {
        return professionalRepository.findByLocationId(locationId);
    }
}
