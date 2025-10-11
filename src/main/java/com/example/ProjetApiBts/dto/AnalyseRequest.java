package com.example.ProjetApiBts.dto;

import lombok.Data;

@Data
public class AnalyseRequest {
    private Long patientId;
    private Long typeExamenId;
    private String description;
}
