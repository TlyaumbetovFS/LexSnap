package dev.lexsnap.service;

import dev.lexsnap.dto.TranslateRequest;
import dev.lexsnap.dto.TranslateResponse;
import dev.lexsnap.model.Word;
import dev.lexsnap.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TranslateService {
    private final RestClient client = RestClient.create();

    private final WordRepository wordRepository;

    public String translate(String word) {
        var isCyrillic = word.matches(".*[а-яёА-ЯЁ].*");
        var source = isCyrillic ? "ru" : "en";
        var target = isCyrillic ? "en" : "ru";

        var request = new TranslateRequest(word, source, target, null);

        var response = client.post()
                .uri("http://localhost:5000/translate")
                .body(request)
                .retrieve()
                .body(TranslateResponse.class);

        if (response == null) {
            return "Unable to translate word";
        }

        var wordToSave = Word.builder()
                .translation(response.translatedText())
                .original(word)
                .build();

        wordRepository.save(wordToSave);
        return response.translatedText();
    }

    public List<Word> getWords() {
        return wordRepository.findAll();
    }
}
