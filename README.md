# FHIR Subscription Project

Sistema de gestión de suscripciones FHIR para el monitoreo de eventos en salud.

## 📋 Descripción
Este proyecto implementa un sistema de suscripciones FHIR que permite a aplicaciones médicas suscribirse a cambios en recursos de salud y recibir notificaciones automáticas.

## ✨ Características
- Gestión completa de suscripciones (CRUD)
- Validación de recursos FHIR R4
- Múltiples canales de notificación (webhooks, email, websockets)
- Sistema de reintentos para notificaciones fallidas
- Autenticación JWT y autorización RBAC
- Dashboard de monitoreo y métricas

## 🛠️ Tecnologías
- **Backend:** Node.js, Express, TypeScript
- **Base de datos:** MongoDB, Redis
- **FHIR:** HL7 FHIR R4
- **Mensajería:** Bull, Socket.io
- **Testing:** Jest, Supertest

## 📦 Instalación

### Prerrequisitos
```bash
node --version  # v18.0.0 o superior
npm --version   # v9.0.0 o superior
