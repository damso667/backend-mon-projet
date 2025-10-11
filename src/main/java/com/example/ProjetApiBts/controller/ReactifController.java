package com.example.ProjetApiBts.controller;

import com.example.ProjetApiBts.dto.ReactifDTO;
import com.example.ProjetApiBts.dto.ReactifRequest;
import com.example.ProjetApiBts.models.Reactif;
import com.example.ProjetApiBts.service.AnalyseService;
import com.example.ProjetApiBts.service.ReactifService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.ProjetApiBts.models.Reactif;
import com.example.ProjetApiBts.repository.ReactifRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/secretaires")
@RequiredArgsConstructor
@PreAuthorize("hasRole('SECRETAIRE')")
public class ReactifController {
    private final ReactifRepository repo;
    private  final AnalyseService analyseService;

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<Reactif> all() {
        return repo.findAll();
    }
    private final ReactifService service;

    @PostMapping("/creer")
    public ResponseEntity<ReactifDTO> ajouterReactif(
            @AuthenticationPrincipal(expression = "id") Long responsableId,
            @RequestBody ReactifRequest dto
    ) {
        Reactif reactif = service.ajouterReactifEtAssocier(
                responsableId,
                dto.getTypeExamenNom(),
                dto.getTypeExamenDescription(),
                dto.getNom(),
                dto.getCode(),
                dto.getUnite(),
                dto.getStock(),
                dto.getQuantiteParAnalyse()
        );
        return ResponseEntity.ok(ReactifDTO.of(reactif));
    }

    @PutMapping("/reactifs/{id}/augmenter")
    public ResponseEntity<ReactifDTO> augmenterStock(
            @PathVariable Long id,
            @RequestParam int quantite,
            @AuthenticationPrincipal(expression = "id") Long responsableId
    ) {
        Reactif reactif = service.augmenterStock(id, quantite, responsableId);
        return ResponseEntity.ok(ReactifDTO.of(reactif));
    }

    @PutMapping("/{id}/diminuer")
    public ResponseEntity<ReactifDTO>diminuer(@PathVariable Long id, @RequestParam int quantite,
                                              @AuthenticationPrincipal(expression="id") Long responsableId) throws IllegalAccessException {
        Reactif reactif = service.diminuerStock(id,quantite,responsableId);
        return ResponseEntity.ok(ReactifDTO.of(reactif));
    }
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void>supprimer(@PathVariable Long id){
        service.suppprimer(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/supprimer/examen/{id}")
    public void supprime(@PathVariable Long id){
        analyseService.supprimerExamen(id);
    }

}