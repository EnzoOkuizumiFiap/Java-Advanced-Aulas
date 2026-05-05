package fiap.com.br.termo.repository;

import fiap.com.br.termo.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
