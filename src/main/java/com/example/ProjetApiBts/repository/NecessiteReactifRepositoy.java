package com.example.ProjetApiBts.repository;

import com.example.ProjetApiBts.models.NecessiteReactif;
import com.example.ProjetApiBts.models.Reactif;
import com.example.ProjetApiBts.models.TypeExament;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.lang.model.element.TypeElement;
import java.util.List;
import java.util.Optional;

public interface NecessiteReactifRepositoy extends JpaRepository<NecessiteReactif,Long> {
    Optional<NecessiteReactif>findByTypeExamenAndReactif(TypeExament typeExament , Reactif reactif);

    @Transactional
    @Modifying
    @Query("delete from NecessiteReactif nr where nr.reactif.id = :reactifId")
    void deleteByReactifId(@Param("reactifId") Long reactifId);

    List<NecessiteReactif> findByTypeExamen(TypeExament typeExamen);
}
