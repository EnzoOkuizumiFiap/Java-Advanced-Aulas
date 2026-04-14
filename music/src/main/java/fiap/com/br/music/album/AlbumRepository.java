package fiap.com.br.music.album;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByReleaseYearBetween(Integer releaseYearAfter, Integer releaseYearBefore);
}
