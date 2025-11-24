🚀 Estrategia de Pruebas Implementada
✔️ Pruebas Unitarias (JUnit + Surefire)

Validan funciones pequeñas y aisladas del servicio.

Se ejecutan en la etapa Build & Unit Tests del pipeline CI.

✔️ Pruebas de Integración (JUnit + Maven Failsafe)

Validan flujos completos del servicio.

Se ejecutan en la etapa Integration / Acceptance Tests del pipeline de Deploy.

✔️ Criterios adoptados

El pipeline CI debe terminar en SUCCESS para permitir merge.

Si las pruebas de integración fallan → el despliegue no continúa → se activa rollback automático.

🔄 Estrategias de CI/CD Aplicadas
🟦 Pipeline CI (Jenkinsfile)

Incluye:

Checkout desde GitHub (main)

Build con Maven

Ejecución de pruebas unitarias

Validación de artefacto

🟩 Pipeline de Deploy (Jenkinsfile-deploy)

Incluye:

Build

Pruebas unitarias

Pruebas de integración (Failsafe)

Deploy al ambiente de prueba

Rollback automático si algo falla

✔️ Mecanismo de Rollback

IF EXIST app-prev.jar → restaurar versión anterior

Salida esperada:

Restaurando version anterior desde app-prev.jar...
1 archivo(s) copiado(s).

📥 Cómo clonar el repositorio

git clone https://github.com/danpereiplax/automatizacion-examen.git
cd automatizacion-examen

📦 Cómo instalar dependencias

Maven descarga todas las dependencias con:
mvn clean install

🧪 Cómo ejecutar las pruebas
✔️ Pruebas unitarias:
mvn test

✔️ Pruebas de integración:

mvn failsafe:integration-test failsafe:verify


⚙️ Ejecución de Pipelines
Pipeline CI

Se ejecuta automáticamente con cada push a main.

Valida:

Build

Unit Tests

Generación de artefacto .jar

Pipeline Deploy

Se ejecuta manualmente desde Jenkins.

Stages:

Checkout

Build & Unit Tests

Integration Tests

Deploy a entorno de prueba (D:\deploy-pruebas\app\)

Rollback (si falla)


📚 Explicación del Pipeline y el Despliegue
🟦 CI Pipeline (Jenkinsfile)

Garantiza calidad básica del código:

Compila

Ejecuta unit tests

Genera artefacto

Uso de fail fast → si falla algo, se detiene.

🟩 Deployment Pipeline (Jenkinsfile-deploy)

Incluye:

Tests completos

Acceptance Gate

Deploy controlado

Rollback automático

Esto replica las prácticas enseñadas en la Unidad III .


Rollback Automático

El pipeline detecta FAIL en integración:

expected 41 but was 40

→ detiene el deploy
→ activa rollback
→ restaura app-prev.jar

Esto implementa las estrategias enseñadas en la unidad: rollback automático y recuperación inmediata .


📝 Conclusión

Este proyecto demuestra:

Configuración profesional de control de versiones.

Gestión de dependencias con Maven.

Uso de pruebas unitarias e integración.

Implementación de CI/CD real con Jenkins.

Despliegue controlado con rollback automático.

Todo alineado con las actividades de Automatización de Pruebas y las prácticas sugeridas por el material de estudio oficial.
