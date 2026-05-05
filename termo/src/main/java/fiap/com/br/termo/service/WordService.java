package fiap.com.br.termo.service;

import fiap.com.br.termo.entity.Word;
import fiap.com.br.termo.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class WordService {

    private final WordRepository wordRepository;

    public Word addWord(Word word){
        return wordRepository.save(word);
    }

    @Cacheable("word")
    public Word getWordOfToday() {
        return wordRepository.findByWordDate(LocalDate.now());
    }

    @PutMapping("{id}")
    @CacheEvict(value = "word", allEntries = true)
    public Word updateWord(@RequestBody Word word) {
        return wordRepository.save(word);
    }
}

//redis - Consegue armazenar o Cache de maneira otimizada
