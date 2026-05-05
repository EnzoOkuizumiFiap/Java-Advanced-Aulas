package fiap.com.br.termo.repository;

import fiap.com.br.termo.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface WordRepository extends JpaRepository<Word, Long> {
    Word findByWordDate(LocalDate wordDate);
}
