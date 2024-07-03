package com.example.notificationservice.service;

import com.example.notificationservice.config.RabbitMQConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {
    @Autowired
    private NotificationService notificationService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(message);

            Long patientId = jsonNode.get("patientId").asLong();
            String gender = jsonNode.get("gender").asText();
            int age = jsonNode.get("age").asInt();

            notificationService.evaluateNewPatient(patientId, gender, age);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
