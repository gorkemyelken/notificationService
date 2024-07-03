package com.example.notificationservice.repository;

import com.example.notificationservice.model.NotificationTemplate;
import com.example.notificationservice.model.TargetPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetPatientRepository extends JpaRepository<TargetPatient, Long> {
}
