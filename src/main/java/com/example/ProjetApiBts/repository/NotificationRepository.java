package com.example.ProjetApiBts.repository;

import com.example.ProjetApiBts.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
    List<Notification> findByMedecinIdOrderByDateCreationDesc(Long medecinId);


}
