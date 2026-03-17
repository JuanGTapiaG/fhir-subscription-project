package com.example.fhirsubscription.interceptor;

import ca.uhn.fhir.interceptor.api.Hook;
import ca.uhn.fhir.interceptor.api.Interceptor;
import ca.uhn.fhir.interceptor.api.Pointcut;
import com.example.fhirsubscription.publisher.NotificationPublisher;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Interceptor
public class FhirNotificationInterceptor {
    
    private static final Logger log = LoggerFactory.getLogger(FhirNotificationInterceptor.class);
    
    @Autowired
    private NotificationPublisher notificationPublisher;
    
    @Hook(Pointcut.STORAGE_PRECOMMIT_RESOURCE_CREATED)
    public void resourceCreated(IBaseResource resource) {
        if (resource instanceof Patient) {
            log.info("🔍 Interceptor detectó: Nuevo paciente creado");
            // Cambiar a publish() en lugar de publishPatientNotification()
            notificationPublisher.publish((Patient) resource, "CREATED");
        }
    }
}
