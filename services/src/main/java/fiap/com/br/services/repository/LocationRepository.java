package fiap.com.br.services.repository;

import fiap.com.br.services.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
