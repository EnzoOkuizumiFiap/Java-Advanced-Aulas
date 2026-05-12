package fiap.com.br.services.repository;

import fiap.com.br.services.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    List<Professional> findByLocationId(Long locationId);
}
