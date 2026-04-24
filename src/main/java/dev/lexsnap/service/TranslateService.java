package dev.lexsnap.service;

import dev.lexsnap.dto.TranslateRequest;
import dev.lexsnap.dto.TranslateResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class TranslateService {
    private final RestClient client = RestClient.create();

    public String translate(String word, String from, String to) {
        var request = new TranslateRequest(word, from, to, null);

        var response = client.post()
                .uri("http://localhost:5000/translate")
                .body(request)
                .retrieve()
                .body(TranslateResponse.class);

        if (response == null) {
            return "Unable to translate word";
        }
        return response.translatedText();
    }
}
