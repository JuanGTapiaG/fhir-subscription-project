package com.example.fhirsubscription.consumer;

import ca.uhn.fhir.context.FhirContext;
import com.example.fhirsubscription.config.RabbitMQConfig;
import org.hl7.fhir.r4.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class NotificationConsumer {
    
    private static final Logger log = LoggerFactory.getLogger(NotificationConsumer.class);
    
    // Crear FhirContext directamente
    private FhirContext fhirContext = FhirContext.forR4();
    
    // Cambiar PATIENT_QUEUE por QUEUE
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receive(Map<String, Object> notification) {
        try {
            log.info("==========================================");
            log.info("📨 NOTIFICACIÓN RECIBIDA EN CONSUMIDOR");
            log.info("==========================================");
            log.info("Paciente ID: {}", notification.get("patientId"));
            log.info("Operación: {}", notification.get("operation"));
            log.info("Timestamp: {}", notification.get("timestamp"));
            
            String json = (String) notification.get("data");
            Patient patient = fhirContext.newJsonParser().parseResource(Patient.class, json);
            
            String patientName = patient.getNameFirstRep().getNameAsSingleString();
            log.info("Paciente: {}", patientName);
            log.info("✅ Notificación procesada exitosamente");
            
        } catch (Exception e) {
            log.error("Error procesando notificación: {}", e.getMessage());
        }
    }
}
