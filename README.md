# 📁 FHIR Subscription with RabbitMQ

[![Estado](https://img.shields.io/badge/Estado-Producción-green)]()
[![Versión](https://img.shields.io/badge/Versión-1.0.0-blue)]()
[![Java](https://img.shields.io/badge/Java-21-orange)]()
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.2-brightgreen)]()
[![RabbitMQ](https://img.shields.io/badge/RabbitMQ-4.0.5-red)]()
[![Licencia](https://img.shields.io/badge/Licencia-MIT-yellow)]()

## 📋 Descripción

Sistema de notificaciones en tiempo real utilizando el estándar **FHIR R4** y **RabbitMQ**. Cuando se crea un paciente, se envía una notificación automática a una cola de RabbitMQ para ser procesada.

### ✨ Características

- ✅ API REST para crear pacientes y suscripciones FHIR
- ✅ Notificaciones automáticas a RabbitMQ
- ✅ Consumidor que procesa las notificaciones
- ✅ Persistencia en H2 (archivo permanente)
- ✅ Interfaz de monitoreo RabbitMQ y H2

---

## 🏗️ Arquitectura
Cliente → API REST → RabbitMQ → Consumidor → Logs
↓
H2 DB (Permanente)

---

## 🛠️ Tecnologías

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| Java | 21 | Lenguaje principal |
| Spring Boot | 3.2.2 | Framework |
| RabbitMQ | 4.0.5 | Broker de mensajes |
| HAPI FHIR | 7.4.0 | Recursos FHIR R4 |
| H2 Database | 2.2.224 | Base de datos |

---

## 📋 Requisitos Previos
```bash
# Instalaciones necesarias
sudo apt update
sudo apt install openjdk-21-jdk maven rabbitmq-server -y
sudo systemctl start rabbitmq-server
sudo rabbitmq-plugins enable rabbitmq_management

🚀 Instalación y Ejecución
