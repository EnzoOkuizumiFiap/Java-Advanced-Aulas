package fiap.com.br.music.music;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Integer> {
    List<MusicSummary> findByTitleContainingIgnoreCase(String title);

    //JPQL - você referência as classes e atributos / É como se fosse um SQL, mas diferenciado
    @Query(value = "SELECT m.id, m.title FROM Music m WHERE m.title LIKE :title")
    List<Music> findByAlgoMuitoEspecifico(String title);
}
