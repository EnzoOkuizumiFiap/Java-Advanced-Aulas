package fiap.com.br.music.album;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("albums")
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumRepository albumRepository;

    @GetMapping("by-year-range")
    public List<Album> findByYearRange(@RequestParam Integer from,  @RequestParam Integer to) {
        return albumRepository.findByReleaseYearBetween(from, to);
    }
}
