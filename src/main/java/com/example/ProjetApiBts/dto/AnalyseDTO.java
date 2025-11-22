
        package com.example.ProjetApiBts.dto;

import com.example.ProjetApiBts.models.*;
import lombok.*;

import java.util.Date;
import java.util.List;


        public record AnalyseDTO(
                Long id,
                String patientId,
                String medecinId,
                Long technicienId,
                String typeExamenId,
                String description,
                String resultats,
                Boolean valide,
                Date dateAnalyse,
                Date dateValidation
        ) {
            public static AnalyseDTO of(Analyse a) {
                return new AnalyseDTO(
                        a.getId(),
                        a.getPatient() != null ? a.getPatient().getNom() : null,
                        a.getMedecin() != null ? a.getMedecin().getNom() : null,
                        a.getTechnicien() != null ? a.getTechnicien().getId() : null,
                        a.getTypeExamen() != null ? a.getTypeExamen().getNom() : null,
                        a.getDescription(),
                        a.getResultats(),
                        a.getValide(),
                        a.getDateAnalyse(),
                        a.getDateValidation()
                );
            }
        }

// PrelevementDTO.java package

