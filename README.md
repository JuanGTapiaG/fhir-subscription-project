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

```markdown
# 📁 FHIR Subscription with RabbitMQ

Sistema de notificaciones en tiempo real usando FHIR R4 y RabbitMQ.

---

## 📋 Índice
1. [Características](#-características)
2. [Tecnologías](#-tecnologías)
3. [Requisitos Previos](#-requisitos-previos)
4. [Instalación y Ejecución](#-instalación-y-ejecución)
5. [API Endpoints](#-api-endpoints)
6. [Monitoreo](#-monitoreo)
7. [Estructura del Proyecto](#-estructura-del-proyecto)
8. [Solución de Problemas](#-solución-de-problemas)
9. [Autor](#-autor)
10. [Licencia](#-licencia)

---

## ✨ Características

| # | Característica | Descripción |
|---|----------------|-------------|
| 1 | ✅ API REST | Endpoints para crear pacientes y suscripciones FHIR |
| 2 | ✅ Notificaciones | Envío automático a RabbitMQ al crear un paciente |
| 3 | ✅ Consumidor | Procesa las notificaciones en tiempo real |
| 4 | ✅ Persistencia | Base de datos H2 con almacenamiento permanente |
| 5 | ✅ Monitoreo | Interfaces web para RabbitMQ y H2 |

---

## 🛠️ Tecnologías

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| Java | 21 | Lenguaje principal |

| Spring Boot | 3.2.2 | Framework |
| RabbitMQ | 4.0.5 | Broker de mensajes |
| HAPI FHIR | 7.4.0 | Recursos FHIR R4 |
| H2 Database | 2.2.224 | Base de datos |

| Spring Boot | 3.2.2 | Framework de aplicación |
| RabbitMQ | 4.0.5 | Broker de mensajes |
| HAPI FHIR | 7.4.0 | Estructuras FHIR R4 |
| H2 Database | 2.2.224 | Base de datos embebida |
| Maven | 3.8+ | Gestor de dependencias |

---

## 📋 Requisitos Previos

```bash
# Instalaciones necesarias
sudo apt update
sudo apt install openjdk-21-jdk maven rabbitmq-server -y
sudo systemctl start rabbitmq-server
sudo rabbitmq-plugins enable rabbitmq_management

🚀 Instalación y Ejecución


### Software Necesario
```bash
# Versiones mínimas
- Java 21
- Maven 3.8+
- RabbitMQ 4.0+
```

### Instalación en Debian/Ubuntu
```bash
# Actualizar repositorios
sudo apt update

# Instalar Java 21
sudo apt install openjdk-21-jdk -y

# Instalar Maven
sudo apt install maven -y

# Instalar RabbitMQ
sudo apt install rabbitmq-server -y

# Iniciar RabbitMQ
sudo systemctl start rabbitmq-server
sudo systemctl enable rabbitmq-server

# Habilitar plugin de administración web
sudo rabbitmq-plugins enable rabbitmq_management

# Verificar instalaciones
java -version
mvn -version
sudo rabbitmqctl status
```

---

## 🚀 Instalación y Ejecución

### 1. Clonar el Repositorio
```bash
git clone https://github.com/JuanGTapiaG/fhir-subscription-project.git
cd fhir-subscription-project
```

### 2. Compilar el Proyecto
```bash
mvn clean compile
```

### 3. Ejecutar la Aplicación
```bash
mvn spring-boot:run
```

### 4. Verificar que Funciona
```bash
# En otra terminal
curl http://localhost:8080/api/patients/test
```
**Respuesta esperada:** `✅ Sistema funcionando correctamente`

---

## 📡 API Endpoints

### 1. Verificar Estado del Sistema
```bash
GET /api/patients/test
```
**Ejemplo:**
```bash
curl http://localhost:8080/api/patients/test
```
**Respuesta:**
```
✅ Sistema funcionando correctamente
```

### 2. Crear Suscripción para Patient
```bash
POST /api/subscriptions/patient
```
**Ejemplo:**
```bash
curl -X POST http://localhost:8080/api/subscriptions/patient
```
**Respuesta:**
```json
{
  "message": "Suscripción creada exitosamente",
  "subscriptionId": "a1b2c3d4-e5f6-7890-1234-567890abcdef",
  "criteria": "Patient?",
  "endpoint": "http://localhost:8080/fhir/callback"
}
```

### 3. Crear Nuevo Paciente
```bash
POST /api/patients
Content-Type: application/json
```
**Ejemplo con Omar Gómez:**
```bash
curl -X POST http://localhost:8080/api/patients \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Omar",
    "lastName": "Gómez",
    "identifier": "1007588983"
  }'
```
**Respuesta:**
```json
{
  "message": "Paciente guardado exitosamente",
  "patientId": "3f8469df-fc0d-4819-bbd2-2a433b8652aa",
  "name": "Omar Gómez",
  "cedula": "1007588983"
}
```

### 4. Ejemplos Adicionales
```bash
# Crear Ana Martínez
curl -X POST http://localhost:8080/api/patients \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Ana",
    "lastName": "Martínez",
    "identifier": "52436789"
  }'

# Crear Carlos Rodríguez
curl -X POST http://localhost:8080/api/patients \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Carlos",
    "lastName": "Rodríguez",
    "identifier": "78901234"
  }'
```

---

## 👀 Monitoreo

### RabbitMQ Management UI
- **URL:** http://localhost:15672
- **Usuario:** guest
- **Contraseña:** guest
- **Ruta:** Queues and Streams → patient.queue → Get messages

### H2 Database Console
- **URL:** http://localhost:8080/h2-console
- **JDBC URL:** `jdbc:h2:file:./data/testdb`
- **Usuario:** sa
- **Contraseña:** (vacío)

### Comandos de Verificación
```bash
# Ver colas de RabbitMQ
sudo rabbitmqctl list_queues

# Ver estadísticas detalladas
sudo rabbitmqctl list_queues name messages consumers memory

# Ver logs de RabbitMQ
sudo journalctl -u rabbitmq-server -f
```

---

## 📁 Estructura del Proyecto

```
fhir-subscription-project/
├── pom.xml
├── README.md
├── data/
│   └── testdb.mv.db          # Base de datos H2 (permanente)
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── example/
        │           └── fhirsubscription/
        │               ├── FhirSubscriptionApplication.java
        │               ├── config/
        │               │   ├── RabbitMQConfig.java
        │               │   └── FhirConfig.java
        │               ├── controller/
        │               │   └── PatientController.java
        │               ├── service/
        │               │   └── PatientService.java
        │               ├── publisher/
        │               │   └── NotificationPublisher.java
        │               ├── consumer/
        │               │   └── NotificationConsumer.java
        │               └── interceptor/
        │                   └── FhirNotificationInterceptor.java
        └── resources/
            └── application.yml
```

### Descripción de Componentes

| Componente | Archivo | Función |
|------------|---------|---------|
| **Main** | `FhirSubscriptionApplication.java` | Punto de entrada de la aplicación |
| **Config** | `RabbitMQConfig.java` | Configura colas y exchanges de RabbitMQ |
| **Config** | `FhirConfig.java` | Configura contexto FHIR |
| **Controller** | `PatientController.java` | Endpoints REST para pacientes |
| **Service** | `PatientService.java` | Lógica de negocio y guardado en H2 |
| **Publisher** | `NotificationPublisher.java` | Envía notificaciones a RabbitMQ |
| **Consumer** | `NotificationConsumer.java` | Recibe notificaciones de RabbitMQ |
| **Interceptor** | `FhirNotificationInterceptor.java` | Detecta cambios en recursos FHIR |

---

## ❗ Solución de Problemas

### Error: Puerto 8080 ocupado
```bash
# Ver proceso usando el puerto
sudo lsof -i :8080

# Matar el proceso (reemplazar PID)
sudo kill -9 <PID>

# O matar todos los procesos Java
pkill -f java
```

### Error: No se puede conectar a RabbitMQ
```bash
# Verificar estado
sudo systemctl status rabbitmq-server

# Reiniciar RabbitMQ
sudo systemctl restart rabbitmq-server

# Verificar puerto
sudo netstat -tlnp | grep 5672
```

### Error: Tabla PATIENT no encontrada en H2
La tabla se crea automáticamente. Si no existe:
```sql
CREATE TABLE IF NOT EXISTS PATIENT (
    ID VARCHAR(100) PRIMARY KEY,
    FIRST_NAME VARCHAR(100),
    LAST_NAME VARCHAR(100),
    IDENTIFIER VARCHAR(50),
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Error: JDBC URL incorrecta en H2 Console
Usar:
```
jdbc:h2:file:./data/testdb
```
NO usar `jdbc:h2:mem:testdb`

### Error de Compilación
```bash
# Limpiar y recompilar
mvn clean compile

# Si persiste, limpiar caché de Maven
rm -rf ~/.m2/repository/com/example/
mvn clean compile
```

---

## 🔧 Mantenimiento

### Backup de Base de Datos
```bash
# Backup manual
cp data/testdb.mv.db ~/backup-fhir-$(date +%Y%m%d).mv.db

# Restaurar backup
cp ~/backup-fhir-20250316.mv.db data/testdb.mv.db
```

### Limpiar Base de Datos (empezar de cero)
```bash
# Detener la aplicación (Ctrl+C)
rm data/testdb.mv.db
mvn spring-boot:run  # La tabla se recreará automáticamente
```

### Script de Monitoreo
```bash
#!/bin/bash
# monitor.sh
while true; do
  clear
  echo "=== MONITOREO FHIR-RABBITMQ ==="
  echo "Fecha: $(date)"
  echo ""
  echo "--- RabbitMQ ---"
  sudo rabbitmqctl list_queues | grep patient || echo "❌ Cola no encontrada"
  echo ""
  echo "--- Aplicación ---"
  curl -s http://localhost:8080/api/patients/test || echo "❌ App no responde"
  echo ""
  echo "--- Base de Datos ---"
  ls -lh data/ | grep testdb
  sleep 5
done
```

---

## 🧪 Script de Prueba Completo

```bash
#!/bin/bash
# test-completo.sh

echo "=================================="
echo "🧪 TEST COMPLETO DEL SISTEMA"
echo "=================================="

# 1. Verificar aplicación
echo -e "\n1. Verificando aplicación..."
curl -s http://localhost:8080/api/patients/test

# 2. Crear suscripción
echo -e "\n\n2. Creando suscripción..."
curl -s -X POST http://localhost:8080/api/subscriptions/patient

# 3. Crear paciente de prueba
echo -e "\n\n3. Creando paciente Omar Gómez..."
curl -s -X POST http://localhost:8080/api/patients \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Omar",
    "lastName": "Gómez",
    "identifier": "1007588983"
  }' | json_pp

# 4. Crear segundo paciente
echo -e "\n\n4. Creando paciente Ana Martínez..."
curl -s -X POST http://localhost:8080/api/patients \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Ana",
    "lastName": "Martínez",
    "identifier": "52436789"
  }' | json_pp

# 5. Verificar RabbitMQ
echo -e "\n\n5. Verificando RabbitMQ..."
sudo rabbitmqctl list_queues | grep patient

echo -e "\n✅ Prueba completada"
```

---

## 📊 Cumplimiento de Requisitos

| # | Requisito | Estado | Verificación |
|---|-----------|--------|--------------|
| 1 | Configurar Subscription para Patient | ✅ | `POST /api/subscriptions/patient` |
| 2 | Crear nuevo Patient | ✅ | `POST /api/patients` con datos |
| 3 | Notificación enviada a RabbitMQ | ✅ | Logs y `sudo rabbitmqctl list_queues` |
| 4 | Consumir desde microservicio | ✅ | Logs del consumidor |

---

## 👤 Autor

**Juan Tapia**
- GitHub: [@JuanGTapiaG](https://github.com/JuanGTapiaG)
- Proyecto: [fhir-subscription-project](https://github.com/JuanGTapiaG/fhir-subscription-project)

---

## 📄 Licencia

MIT License

Copyright (c) 2026 Juan Tapia

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

---

## 🙏 Agradecimientos

- HAPI FHIR por la biblioteca FHIR
- Spring Boot por el framework
- RabbitMQ por el broker de mensajes
- Comunidad de código abierto

---

## 📞 Contacto

- **Issues:** [https://github.com/JuanGTapiaG/fhir-subscription-project/issues](https://github.com/JuanGTapiaG/fhir-subscription-project/issues)
- **Email:** juan.tapia@example.com

---

## 🏁 Estado del Proyecto

✅ **Producción** - Versión 1.0.0 estable

---

**¡Gracias por usar este proyecto!** 🚀
```
