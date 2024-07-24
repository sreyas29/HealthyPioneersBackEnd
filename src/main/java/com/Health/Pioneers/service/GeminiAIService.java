package com.Health.Pioneers.service;
import com.Health.Pioneers.config.GeminiAIConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class GeminiAIService {

    @Value("${gemini.api.url1}")
    private String apiUrl;

    @Value("${gemini.api.key1}")
    private String apiKey;

    @Autowired
    private GeminiAIConfig config;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getAIResponse(String input) {
        String url = config.getApiUrl() + "?api_key=" + config.getApiKey() + "&input=" + input;
        return restTemplate.getForObject(url, String.class);
    }

    public String search(Map<String, String> params) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("X-GEMINI-APIKEY", apiKey);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl);
        params.forEach(builder::queryParam);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to search Gemini API: " + response.getStatusCode());
        }
    }
}
