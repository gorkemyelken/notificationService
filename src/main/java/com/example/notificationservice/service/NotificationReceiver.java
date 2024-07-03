package com.example.notificationservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationReceiver {

    @Autowired
    private NotificationService notificationService;

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            PatientMessage patientMessage = objectMapper.readValue(message, PatientMessage.class);
            Long patientId = patientMessage.getPatientId();
            String gender = patientMessage.getGender();
            int age = patientMessage.getAge();

            notificationService.evaluatePatientForNotifications(patientId, gender, age);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class PatientMessage {
        private Long patientId;
        private String gender;
        private int age;

        // Getters and Setters

        public Long getPatientId() {
            return patientId;
        }

        public void setPatientId(Long patientId) {
            this.patientId = patientId;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
