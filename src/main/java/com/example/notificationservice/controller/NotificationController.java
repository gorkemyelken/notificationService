package com.example.notificationservice.controller;

import com.example.notificationservice.model.NotificationTemplate;
import com.example.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/templates")
    public ResponseEntity<NotificationTemplate> createTemplate(@RequestBody NotificationTemplate template) {
        NotificationTemplate createdTemplate = notificationService.createTemplate(template);
        return ResponseEntity.ok(createdTemplate);
    }

    @GetMapping("/templates")
    public ResponseEntity<List<NotificationTemplate>> getAllTemplates() {
        List<NotificationTemplate> templates = notificationService.getAllTemplates();
        return ResponseEntity.ok(templates);
    }

    @PostMapping("/evaluate")
    public ResponseEntity<Void> evaluatePatient(@RequestParam Long patientId,
                                                @RequestParam String gender,
                                                @RequestParam int age) {
        notificationService.evaluatePatientForNotifications(patientId, gender, age);
        return ResponseEntity.ok().build();
    }
}