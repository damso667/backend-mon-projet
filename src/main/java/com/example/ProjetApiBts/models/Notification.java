package com.example.ProjetApiBts.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private boolean lue = false;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    private LocalDateTime dateCreation = LocalDateTime.now();
}
