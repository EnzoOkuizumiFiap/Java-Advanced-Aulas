package fiap.com.br.services.repository;

import fiap.com.br.services.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
