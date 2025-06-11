package com.tuempresa.numerosmagicos.model;

import java.util.Random;
import java.util.Scanner;

public class PartidaMultiplicacion {
    private int vidas = 5;
    private int dificultad = 1;
    private int intentos = 0;
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        System.out.println("¡Bienvenido a la partida de MULTIPLICACIÓN!");

        while (vidas > 0) {
            // Se genera el primer número según la dificultad
            int numero1 = random.nextInt(dificultad * 5) + 1;

            // El segundo número será entre 1 y 10
            int numero2 = random.nextInt(10) + 1;

            int resultado = numero1 * numero2;

            System.out.println("¿Cuánto es " + numero1 + " × " + numero2 + " ?");

            String input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("Respuesta vacía. Pierdes una vida.");
                vidas--;
                continue;
            }

            try {
                int respuesta = Integer.parseInt(input);
                if (respuesta == resultado) {
                    System.out.println("¡Correcto!");
                } else {
                    System.out.println("Incorrecto. La respuesta era " + resultado);
                    vidas--;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Pierdes una vida.");
                vidas--;
            }

            intentos++;

            if (intentos % 5 == 0) {
                dificultad++;
                System.out.println("¡Nivel de dificultad aumentado!");
            }

            System.out.println("Vidas restantes: " + vidas);
            System.out.println("----------------------------");
        }

        System.out.println("Juego terminado. Regresando al inicio...");
    }
}
