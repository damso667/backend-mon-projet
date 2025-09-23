package com.example.ProjetApiBts.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    public void envoyerEmail(String to,String sujet,String contenu){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(to);
        simpleMailMessage.setSubject(sujet);
        simpleMailMessage.setText(contenu);
        javaMailSender.send(simpleMailMessage);
    }
}
