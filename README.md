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

## Como usar el juego para usuario Windows que solo tenga instalado Java

Si el usuario solo tiene JAVA instalado en la computadora con Windows, debe seguir los siguientes pasos para ejecutar el juego correctamente:
-Asegurarse de que tenga java Runtime Environment (JRE)  o Java Development Kit (JDK) instalado.
Se puede verificar con el comando:
Java-versión

Si este comando funciona, entonces Java está instalado correctamente.

-	El juego debe estar en formato .jar (archivo ejecutable de Java)


## Como ejecutar el juego en Java en Windows


Opción 1 : Desde la línea de comandos

-	Abre el símbolo del sistema (CDM)
-	Navega hasta el directorio donde esta el archivo .jar del juego
Cd C:\Ruta\Del\Juego
-	Ejecutar el archivo .jar con:

Java -jar NombreDel Juego.jar

 Opción 2: Doble clic (si está bien configurado)
 el sistema tiene asociado .jar con Java, bata con hacer clic en el archivo .jar y se ejecutara.
-	Haz clic derecho >Abrir con…>

Buscar Java en   c:\ProgramFiles\Java\jreX\bin\javaw.exe

- Marca “Usar siempre esta aplicación “


## Crear un archivo .bat para facilitar la ejecución

Se puede crear un pequeño script para que el usuario solo tenga que hacer doble clic:
 
-	Abrir el bloc de notas.

-	Escribir el siguiente contenido (ajusta el nombre del .jar)

@echo off
Java -jar NombreDelJuego.jar
Pause

-	Guardar el archivo como Iniciar Juego.bat (asegurarse de seleccionar “Todos los archivos” al guardar, no  .txt )

-	El usuario puede hacer doble clic en este archivo para iniciar el juego.

## Consejos adicionales:

-	Si tienes problemas para ejecutar el juego, asegurase de que la versión de Java que esta instalada es compatible con el juego.

-	Algunos Juegos pueden requerir configuraciones adicionales en el panel de control de Java


-Si el juego no funciona, intentar ejecutarlo como administrador o verifica si hay actualizaciones de Java disponibles.


Autores:
Angie Lorena Alfonso Soto
Brandon Sebastián Barrera Nino
Juan Pablo Amorocho Chudt
Laura Valentina Acosta
Vanessa Arias Velásquez
