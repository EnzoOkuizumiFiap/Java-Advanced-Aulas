package fiap.com.br.termo.data;

import fiap.com.br.termo.entity.Word;
import fiap.com.br.termo.service.WordService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
@RequiredArgsConstructor
public class MockData {

    private final WordService wordService;

    @PostConstruct
    public void init(){
        wordService.addWord(Word.builder()
                .word("CASAS")
                .wordDate(LocalDate.now())
                .build());
    }

}
