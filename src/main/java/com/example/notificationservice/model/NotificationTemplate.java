package com.example.notificationservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class NotificationTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String messageTemplate;
    private String genderCriteria;
    private String ageCriteria;
}
