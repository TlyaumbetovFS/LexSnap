package dev.lexsnap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;

public record TranslateRequest(
        String q,
        String source,
        String target,
        @Nullable @JsonProperty("api_key") String apiKey
) {
}
