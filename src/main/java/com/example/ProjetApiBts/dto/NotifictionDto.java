package com.example.ProjetApiBts.dto;

import java.time.LocalDateTime;

import com.example.ProjetApiBts.models.Notification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotifictionDto {
    private Long id;
    private String message;
    private boolean lue;
    private LocalDateTime dateCreation;
    private Long medecinId;

    public static NotifictionDto of(Notification n) {
        return NotifictionDto.builder()
                .id(n.getId())
                .message(n.getMessage())
                .lue(n.isLue())
                .dateCreation(n.getDateCreation())
                .medecinId(n.getMedecin() != null ? n.getMedecin().getId() : null)
                .build();
    }
}
