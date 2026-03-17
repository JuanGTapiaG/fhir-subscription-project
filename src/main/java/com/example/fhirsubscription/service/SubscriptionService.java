package com.example.fhirsubscription.service;

import org.hl7.fhir.r4.model.Subscription;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class SubscriptionService {
    
    public Subscription createSubscription(String criteria, String endpoint) {
        Subscription subscription = new Subscription();
        subscription.setId(UUID.randomUUID().toString());
        subscription.setStatus(Subscription.SubscriptionStatus.ACTIVE);
        subscription.setCriteria(criteria);
        subscription.setReason("Monitor Patient changes");
        
        Subscription.SubscriptionChannelComponent channel = 
            new Subscription.SubscriptionChannelComponent();
        channel.setType(Subscription.SubscriptionChannelType.RESTHOOK);
        channel.setEndpoint(endpoint);
        channel.setPayload("application/fhir+json");
        
        subscription.setChannel(channel);
        
        System.out.println("✅ Suscripción creada: " + subscription.getId());
        System.out.println("   Criteria: " + criteria);
        System.out.println("   Endpoint: " + endpoint);
        
        return subscription;
    }
    
    public Subscription setupPatientSubscription() {
        String criteria = "Patient?";
        String endpoint = "http://localhost:8080/fhir/callback";
        return createSubscription(criteria, endpoint);
    }
}
