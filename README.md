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
Pasos rápidos
bash
# Clonar repositorio
git clone https://github.com/JuanGTapiaG/fhir-subscription-project.git
cd fhir-subscription-project

# Instalar dependencias
npm install

# Configurar variables de entorno
cp .env.example .env

# Iniciar aplicación
npm run dev
⚙️ Configuración (.env)
env
NODE_ENV=development
PORT=3000
MONGODB_URI=mongodb://localhost:27017/fhir-subscriptions
REDIS_HOST=localhost
FHIR_SERVER_URL=https://hapi.fhir.org/baseR4
JWT_SECRET=tu_secreto_aqui
📚 API Endpoints Principales
Método	Endpoint	Descripción
GET	/api/subscriptions	Listar suscripciones
POST	/api/subscriptions	Crear suscripción
GET	/api/subscriptions/{id}	Obtener suscripción
PUT	/api/subscriptions/{id}	Actualizar suscripción
DELETE	/api/subscriptions/{id}	Eliminar suscripción
Ejemplo de creación
json
POST /api/subscriptions
{
  "criteria": "Patient?gender=male",
  "channel": {
    "type": "rest-hook",
    "endpoint": "https://miapp.com/webhook",
    "payload": "application/fhir+json"
  },
  "status": "active"
}
📁 Estructura
text
fhir-subscription-project/
├── src/
│   ├── controllers/
│   ├── models/
│   ├── services/
│   ├── middleware/
│   └── routes/
├── tests/
├── config/
├── .env.example
└── README.md
🧪 Pruebas
bash
npm test
npm run test:coverage
🚀 Despliegue rápido
bash
# Con Docker
docker-compose up -d

# Producción
npm run build
npm start
📊 Monitoreo
Health check: GET /health

Métricas: GET /metrics

🤝 Contribuir
Fork el proyecto

Crea tu rama (git checkout -b feature/nueva-funcionalidad)

Commit (git commit -m 'feat: agregar funcionalidad')

Push (git push origin feature/nueva-funcionalidad)

Abrir Pull Request

📄 Licencia
MIT © Juan Tapia

📞 Contacto
GitHub: @JuanGTapiaG

Proyecto: https://github.com/JuanGTapiaG/fhir-subscription-project
