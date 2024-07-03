package com.example.notificationservice.controller;

import com.example.notificationservice.model.NotificationTemplate;
import com.example.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/templates")
    public NotificationTemplate createTemplate(@RequestBody NotificationTemplate template) {
        return notificationService.createTemplate(template);
    }

    @GetMapping("/templates")
    public List<NotificationTemplate> getAllTemplates() {
        return notificationService.getAllTemplates();
    }

    @PostMapping("/evaluate")
    public void evaluateNewPatient(@RequestParam Long patientId, @RequestParam String gender, @RequestParam int age) {
        notificationService.evaluateNewPatient(patientId, gender, age);
    }
}