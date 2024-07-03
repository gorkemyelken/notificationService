package com.example.notificationservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class NotificationTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gender;
    private Integer minAge;
    private Integer maxAge;
    private String message;
}
