package com.example.ProjetApiBts.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
   // @Async
    public void envoyerEmail(String to,String sujet,String contenu){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("njassineadrien@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(sujet);
        simpleMailMessage.setText(contenu);
        javaMailSender.send(simpleMailMessage);
    }
}
