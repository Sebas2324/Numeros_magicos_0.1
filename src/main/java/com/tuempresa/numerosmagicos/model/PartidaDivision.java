package com.tuempresa.numerosmagicos.model;

import java.util.Random;
import java.util.Scanner;

public class PartidaDivision {
    // Número de vidas iniciales del jugador
    private int vidas = 5;

    // Nivel de dificultad que irá aumentando con los intentos
    private int dificultad = 1;

    // Contador de intentos realizados por el jugador
    private int intentos = 0;

    // Generador de números aleatorios para los problemas
    private Random random = new Random();

    // Para leer la entrada del jugador desde consola
    private Scanner scanner = new Scanner(System.in);

    // Método principal que inicia la partida de división
    public void iniciar() {
        System.out.println("¡Bienvenido a la partida de DIVISIÓN!");

        // El juego continúa mientras el jugador tenga vidas
        while (vidas > 0) {
            // Se genera un divisor aleatorio entre 1 y 9 (evitamos el 0)
            int divisor = random.nextInt(9) + 1;

            // El resultado correcto se escoge de forma aleatoria según el nivel de dificultad
            int resultado = random.nextInt(dificultad * 5) + 1;

            // Se calcula el dividendo para que el resultado siempre sea exacto
            int dividendo = resultado * divisor;

            // Se presenta el problema al usuario
            System.out.println("¿Cuánto es " + dividendo + " ÷ " + divisor + " ?");

            // Se lee la respuesta del usuario
            String input = scanner.nextLine();

            // Si el usuario no ingresa nada, pierde una vida
            if (input.isEmpty()) {
                System.out.println("Respuesta vacía. Pierdes una vida.");
                vidas--;
                continue;
            }

            try {
                // Intenta convertir la respuesta a número entero
                int respuesta = Integer.parseInt(input);

                // Si la respuesta es correcta
                if (respuesta == resultado) {
                    System.out.println("¡Correcto!");
                } else {
                    // Si es incorrecta, pierde una vida
                    System.out.println("Incorrecto. La respuesta era " + resultado);
                    vidas--;
                }
            } catch (NumberFormatException e) {
                // Si la entrada no es un número válido, también pierde una vida
                System.out.println("Entrada inválida. Pierdes una vida.");
                vidas--;
            }

            // Se incrementa el contador de intentos
            intentos++;

            // Cada 5 intentos, se aumenta el nivel de dificultad
            if (intentos % 5 == 0) {
                dificultad++;
                System.out.println("¡Nivel de dificultad aumentado!");
            }

            // Mostrar al jugador cuántas vidas le quedan
            System.out.println("Vidas restantes: " + vidas);
            System.out.println("----------------------------");
        }

        // Cuando se acaban las vidas, termina el juego
        System.out.println("Juego terminado. Regresando al inicio...");
    }
}
