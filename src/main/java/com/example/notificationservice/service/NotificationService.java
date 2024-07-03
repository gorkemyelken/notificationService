package com.example.notificationservice.service;

import com.example.notificationservice.model.NotificationTemplate;
import com.example.notificationservice.model.TargetPatient;
import com.example.notificationservice.repository.NotificationTemplateRepository;
import com.example.notificationservice.repository.TargetPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationTemplateRepository templateRepository;

    @Autowired
    private TargetPatientRepository targetPatientRepository;

    public NotificationTemplate createTemplate(NotificationTemplate template) {
        return templateRepository.save(template);
    }

    public List<NotificationTemplate> getAllTemplates() {
        return templateRepository.findAll();
    }

    public void evaluateNewPatient(Long patientId, String gender, int age) {
        System.out.println("asdsadqwdqw");
        List<NotificationTemplate> templates = templateRepository.findAll();
        for (NotificationTemplate template : templates) {
            if ((template.getGenderCriteria() == null || template.getGenderCriteria().equalsIgnoreCase(gender)) &&
                    (template.getAgeCriteria() == null || evaluateAgeCriteria(template.getAgeCriteria(), age))) {
                TargetPatient target = new TargetPatient();
                target.setPatientId(patientId);
                target.setTemplateId(template.getId());
                targetPatientRepository.save(target);
            }
        }
    }

    private boolean evaluateAgeCriteria(String criteria, int age) {

        if (criteria.startsWith("age>")) {
            int ageLimit = Integer.parseInt(criteria.substring(4));
            return age > ageLimit;
        }
        return false;
    }
}
