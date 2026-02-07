package com.example.ProjetApiBts.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j  // ← Ajoutez cette annotation
public class EmailService {
    private final JavaMailSender javaMailSender;

    @Async
    public void envoyerEmail(String to, String sujet, String contenu) {
        try {
            log.info("Tentative d'envoi d'email à : {}", to);

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("njassineadrien@gmail.com");
            simpleMailMessage.setTo(to);
            simpleMailMessage.setSubject(sujet);
            simpleMailMessage.setText(contenu);

            javaMailSender.send(simpleMailMessage);

            log.info("Email envoyé avec succès à : {}", to);

        } catch (Exception e) {
            log.error("Erreur lors de l'envoi de l'email à {} : {}", to, e.getMessage());
            e.printStackTrace();  // ← Ceci affichera la vraie erreur dans les logs
        }
    }
}