package fiap.com.br.termo.repository;

import fiap.com.br.termo.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
