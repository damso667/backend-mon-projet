package com.example.ProjetApiBts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class AnaliseValideeDTO {
    private Long id;
    private String description;
    private String resultats;
    private Date dateAnalyse;
    private Date dateValidation;
    private String patientNom;
    private String typeExamenNom;
}
