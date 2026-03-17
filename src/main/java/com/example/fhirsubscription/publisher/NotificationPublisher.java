package com.example.fhirsubscription.publisher;

import ca.uhn.fhir.context.FhirContext;
import com.example.fhirsubscription.config.RabbitMQConfig;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class NotificationPublisher {
    
    private static final Logger log = LoggerFactory.getLogger(NotificationPublisher.class);
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    // Crear FhirContext directamente
    private FhirContext fhirContext = FhirContext.forR4();
    
    public void publish(Patient patient, String operation) {
        try {
            String patientJson = fhirContext.newJsonParser().encodeResourceToString(patient);
            
            Map<String, Object> notification = new HashMap<>();
            notification.put("resourceType", "Patient");
            notification.put("patientId", patient.getId());
            notification.put("operation", operation);
            notification.put("timestamp", Instant.now().toString());
            notification.put("data", patientJson);
            
            log.info("📤 Enviando notificación a RabbitMQ");
            rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,      // ← Así debe ser
                RabbitMQConfig.ROUTING_KEY,    // ← Así debe ser
                notification
            );
            
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
        }
    }
}
