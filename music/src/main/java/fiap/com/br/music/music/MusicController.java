package fiap.com.br.music.music;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("musics")
@RequiredArgsConstructor
public class MusicController {
    private final MusicRepository musicRepository;

    @GetMapping("search")
    public List<MusicSummary> seachByTitle(@RequestParam String title) {
        return musicRepository.findByTitleContainingIgnoreCase(title);
    }
}
