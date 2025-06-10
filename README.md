# Números Mágicos 

Este proyecto es una implementación en Java de un juego llamado **"Números Mágicos"**, en el que el jugador debe adivinar un número secreto generado aleatoriamente por el sistema. El juego se estructura en varias clases que modelan el flujo del juego, el perfil del jugador y la lógica principal.

---

##  ¿Qué hace este proyecto?

- Genera un número aleatorio que el jugador debe adivinar.
- Permite múltiples intentos, indicando si el número ingresado es mayor o menor.
- Registra información del jugador (nombre, intentos, etc.).
- Organiza el código usando Programación Orientada a Objetos.
- Incluye pruebas con JUnit para validar el funcionamiento de las clases clave.

---

## Estructura del proyecto
NumerosMagicos-V2/
├── src/
│ ├── JuegoInicio.java
│ ├── PerfilJugador.java
│ ├── Principal.java
│ └── PruebasJuego.java
├── lib/
│ ├── junit-4.13.2.jar
│ └── hamcrest-core-1.3.jar
├── bin/
├── .gitignore
└── README.md

---

## Requisitos

- Java 8 o superior
- JUnit 4.13.2
- VS Code, Eclipse o cualquier otro IDE compatible

---

## Cómo compilar y ejecutar

**1. Compilar el proyecto (desde terminal):**

```bash
javac -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" -d bin src/*.java

2. Ejecutar el juego:
java -cp bin Principal

3. Ejecutar pruebas:
java -cp "bin;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore PruebasJuego

Autores:
Angie Lorena Alfonso Soto
Brandon Sebastián Barrera Nino
Juan Pablo Amorocho Chudt
Laura Valentina Acosta
Vanessa Arias Velásquez
