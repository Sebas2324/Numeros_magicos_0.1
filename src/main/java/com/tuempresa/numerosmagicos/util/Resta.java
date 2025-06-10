package com.tuempresa.numerosmagicos.util;

import java.util.Scanner;

public class Resta {
    /**
     * Realiza la resta entre dos números, pregunta al usuario el resultado
     * y verifica si la respuesta es correcta.
     * 
     * @param numero1 Primer número (debe ser mayor que numero2)
     * @param numero2 Segundo número
     */
    public static void realizarResta(int numero1, int numero2) {
        // Verifica que el primer número sea mayor que el segundo
        if (numero1 > numero2) {
            int resultado = numero1 - numero2; // Calcula la resta
            Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario

            // Solicita al usuario que ingrese el resultado de la resta
            System.out.print("¿Cuál es el resultado de la resta de " + numero1 + " y " + numero2 + "? ");
            int respuestaUsuario = scanner.nextInt(); // Lee la respuesta del usuario

            // Compara la respuesta del usuario con el resultado real
            if (respuestaUsuario == resultado) {
                System.out.println("¡Correcto!");
            } else {
                System.out.println("Incorrecto. El resultado es: " + resultado);
            }
            // No se cierra el scanner para evitar problemas si se usa en otras partes
        } else {
            // Mensaje si el primer número no es mayor que el segundo
            System.out.println("El primer número debe ser mayor que el segundo.");
        }
    }
}