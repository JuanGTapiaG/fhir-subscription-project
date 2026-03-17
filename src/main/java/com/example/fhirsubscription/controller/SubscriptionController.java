package com.example.fhirsubscription.controller;

import com.example.fhirsubscription.service.SubscriptionService;
import org.hl7.fhir.r4.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {
    
    @Autowired
    private SubscriptionService subscriptionService;
    
    @PostMapping("/patient")
    public ResponseEntity<Map<String, Object>> createPatientSubscription() {
        try {
            Subscription subscription = subscriptionService.setupPatientSubscription();
            
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Suscripción creada exitosamente");
            response.put("subscriptionId", subscription.getIdElement().getIdPart());
            response.put("criteria", subscription.getCriteria());
            response.put("endpoint", subscription.getChannel().getEndpoint());
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "Error creando suscripción: " + e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
}
