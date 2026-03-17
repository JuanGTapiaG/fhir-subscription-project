package com.example.fhirsubscription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FhirSubscriptionApplication {
    public static void main(String[] args) {
        SpringApplication.run(FhirSubscriptionApplication.class, args);
        System.out.println("==========================================");
        System.out.println("FHIR Subscription Application Started!");
        System.out.println("RabbitMQ Management: http://localhost:15672");
        System.out.println("H2 Database: http://localhost:8080/h2-console");
        System.out.println("==========================================");
    }
}
