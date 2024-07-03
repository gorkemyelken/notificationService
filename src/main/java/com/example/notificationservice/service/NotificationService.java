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
    private NotificationTemplateRepository notificationTemplateRepository;

    @Autowired
    private TargetPatientRepository targetPatientRepository;

    public NotificationTemplate createTemplate(NotificationTemplate template) {
        return notificationTemplateRepository.save(template);
    }

    public List<NotificationTemplate> getAllTemplates() {
        return notificationTemplateRepository.findAll();
    }

    public void evaluatePatientForNotifications(Long patientId, String gender, int age) {
        List<NotificationTemplate> templates = notificationTemplateRepository.findAll();

        for (NotificationTemplate template : templates) {
            if ((template.getGender() == null || template.getGender().equals(gender)) &&
                    (template.getMinAge() == null || age >= template.getMinAge()) &&
                    (template.getMaxAge() == null || age <= template.getMaxAge())) {

                TargetPatient targetPatient = new TargetPatient();
                targetPatient.setPatientId(patientId);
                targetPatient.setTemplateId(template.getId());
                targetPatientRepository.save(targetPatient);
            }
        }
    }
}
