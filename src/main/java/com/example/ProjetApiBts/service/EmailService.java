package com.example.ProjetApiBts.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Slf4j
public class EmailService {

    @Value("${brevo.api.key}")
    private String brevoApiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String BREVO_API_URL = "https://api.brevo.com/v3/smtp/email";

    public void envoyerEmail(String to, String sujet, String contenu) {
        try {
            log.info("Tentative d'envoi d'email à : {}", to);

            log.debug("Longueur de la clé API récupérée : {}", (brevoApiKey != null ? brevoApiKey.length() : "NULL"));


            // Construction du header
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("api-key", brevoApiKey);

            // Construction du body JSON
            Map<String, Object> body = new HashMap<>();
            body.put("sender", Map.of("name", "Laboratoire", "email", "njassineadrien@gmail.com"));
            body.put("to", List.of(Map.of("email", to)));
            body.put("subject", sujet);
            body.put("textContent", contenu);

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(BREVO_API_URL, request, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                log.info("Email envoyé avec succès à : {}", to);
            } else {
                log.error("Erreur Brevo - Status: {} - Body: {}", response.getStatusCode(), response.getBody());
            }

        } catch (Exception e) {
            log.error("Erreur lors de l'envoi de l'email à {} : {}", to, e.getMessage());
            e.printStackTrace();
        }
    }
}