# 📁 FHIR Subscription with RabbitMQ

[![Estado](https://img.shields.io/badge/Estado-Producción-green)]()
[![Versión](https://img.shields.io/badge/Versión-1.0.0-blue)]()
[![Java](https://img.shields.io/badge/Java-21-orange)]()
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.2-brightgreen)]()
[![RabbitMQ](https://img.shields.io/badge/RabbitMQ-4.0.5-red)]()
[![Licencia](https://img.shields.io/badge/Licencia-MIT-yellow)]()

## 📋 Descripción

Sistema de notificaciones en tiempo real utilizando el estándar **FHIR R4** y **RabbitMQ**. Cuando se crea un paciente, se envía una notificación automática a una cola de RabbitMQ para ser procesada.

## ✨ Características

- ✅ API REST para crear pacientes y suscripciones FHIR
- ✅ Notificaciones automáticas a RabbitMQ
- ✅ Consumidor que procesa las notificaciones
- ✅ Persistencia en H2 (archivo permanente)
- ✅ Interfaz de monitoreo RabbitMQ y H2

## 🛠️ Tecnologías

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| Java | 21 | Lenguaje principal |
| Spring Boot | 3.2.2 | Framework |
| RabbitMQ | 4.0.5 | Broker de mensajes |
| HAPI FHIR | 7.4.0 | Recursos FHIR R4 |
| H2 Database | 2.2.224 | Base de datos |

## 📋 Requisitos Previos

```bash
sudo apt update
sudo apt install openjdk-21-jdk maven rabbitmq-server -y
sudo systemctl start rabbitmq-server
sudo rabbitmq-plugins enable rabbitmq_management
```
## 🚀 Instalación y Ejecución
```bash
git clone https://github.com/JuanGTapiaG/fhir-subscription-project.git
cd fhir-subscription-project
mvn clean compile
mvn spring-boot:run
```

## 📡 API Endpoints
Crear Suscripción
```bash
curl -X POST http://localhost:8080/api/subscriptions/patient
```

Crear Paciente
```bash
curl -X POST http://localhost:8080/api/patients \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Omar",
    "lastName": "Gómez",
    "identifier": "1007588983"
  }'
```

Verificar Estado
```bash
curl http://localhost:8080/api/patients/test
```

## 👀 Monitoreo
RabbitMQ: http://localhost:15672 (guest/guest)

H2 Console: http://localhost:8080/h2-console (JDBC: jdbc:h2:file:./data/testdb, usuario: sa)

## 📁 Estructura
src/main/java/com/example/fhirsubscription/
├── FhirSubscriptionApplication.java
├── config/
│   ├── RabbitMQConfig.java
│   └── FhirConfig.java
├── controller/
│   └── PatientController.java
├── service/
│   └── PatientService.java
├── publisher/
│   └── NotificationPublisher.java
├── consumer/
│   └── NotificationConsumer.java
└── interceptor/
    └── FhirNotificationInterceptor.java

## ❗ Solución de Problemas
Puerto 8080 ocupado
```bash
sudo lsof -i :8080
sudo kill -9 <PID>
pkill -f java
```

RabbitMQ no conecta
```bash
sudo systemctl status rabbitmq-server
sudo systemctl start rabbitmq-server
```

## 👤 Autores
Omar Gomez
Juan Tapia
