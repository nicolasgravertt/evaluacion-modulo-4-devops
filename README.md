### Evaluacion Modulo 4 - DevOps

Este proyecto corresponde a la **Evaluación del Módulo 4: Automatización de Pruebas** del programa de DevOps. Se desarrolla una plataforma web en Java con Spring Boot que permite a los usuarios actualizar su peso. La aplicación incluye pruebas automatizadas, pipeline CI/CD y análisis de calidad de código.

---

## 📌 Objetivo

Implementar un sistema de pruebas automatizadas (unitarias, funcionales, de regresión y de rendimiento) con integración continua (CI) usando GitHub Actions, Selenium, JMeter y SonarCloud, detectando errores como el mal manejo del peso ingresado.

---

## 🔧 Tecnologías y herramientas utilizadas

- **Java 17**
- **Spring Boot 3**
- **JUnit 5** + **Mockito** (pruebas unitarias)
- **Selenium WebDriver** (pruebas funcionales UI)
- **Apache JMeter** (pruebas de rendimiento)
- **SonarCloud** (análisis estático de código y cobertura)
- **GitHub Actions** (pipeline CI/CD)
- **ChromeDriver** (navegador automatizado)
- **Jacoco** (generación de cobertura de pruebas)

---

## 🧪 Tipos de pruebas implementadas

### ✅ Pruebas Unitarias (JUnit + Mockito)

- Validación de la lógica de actualización de peso en la clase `Usuario`.
- Mocking del servicio en `UsuarioServiceTest` y `UsuarioControllerTest`.

### ✅ Pruebas Funcionales (Selenium)

- Interacción con un formulario HTML local para actualizar el peso del usuario.
- Simulación de usuario con ChromeDriver.

### ✅ Pruebas de Regresión

- Tests automatizados sobre endpoints y servicios para evitar errores en actualizaciones futuras.
- Verificación de comportamiento correcto con datos anteriores.

### ✅ Pruebas de Rendimiento (JMeter)

- Simulación de 5 usuarios haciendo 50 solicitudes a `/usuario` simultáneamente.
- Generación de reporte HTML guardado como artefacto.

---

## ⚙️ Pipeline CI/CD

El pipeline de GitHub Actions realiza las siguientes tareas:

1. Instala JDK 17.
2. Instala Google Chrome y ChromeDriver.
3. Ejecuta pruebas unitarias con Maven (`mvn test`).
4. Analiza el código con **SonarCloud**.
5. Ejecuta pruebas de rendimiento con **JMeter** (`.jmx`).
6. Sube el reporte de JMeter como artefacto del pipeline.

El archivo `.jmx` se encuentra en la carpeta:

```bash
jmeter/usuario-carga-test.jmx
