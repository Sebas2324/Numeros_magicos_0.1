package com.tuempresa.numerosmagicos.util;

import java.util.Random;
import java.util.Scanner;

public class Resta {
    // Instancias de Random y Scanner para uso en toda la clase
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);
    
    // Variables para almacenar los números y resultados
    private int numero1;
    private int numero2;
    private int espacioVacio; // 0: falta primer número, 1: falta segundo, 2: falta resultado
    private int resultado;
    
    /**
     * Método principal que ejecuta el flujo completo de la resta
     */
    public void realizarResta() {
        generarNumeros();          // Genera los números aleatorios
        mostrarProblema();         // Muestra el problema al usuario
        int respuestaUsuario = obtenerRespuestaValida(); // Obtiene y valida la respuesta
        validarRespuesta(respuestaUsuario); // Evalúa si la respuesta es correcta
        scanner.close();           // Cierra el scanner para liberar recursos
    }

    /**
     * Genera los números aleatorios para la operación de resta
     */
    private void generarNumeros() {
        // Genera un número entre 1 y 10 para el minuendo
        this.numero1 = random.nextInt(10) + 1;
        // Genera un sustraendo menor que el minuendo
        this.numero2 = random.nextInt(this.numero1);
        // Decide qué parte del problema se ocultará (0, 1 o 2)
        this.espacioVacio = random.nextInt(3);
        // Calcula el resultado correcto
        this.resultado = this.numero1 - this.numero2;
    }

    /**
     * Muestra el problema matemático al usuario según qué parte está oculta
     */
    private void mostrarProblema() {
        switch (this.espacioVacio) {
            case 0: // Falta el segundo número (sustraendo)
                System.out.printf("¿Cuál es el número faltante en la resta de %d - ___ = %d? ", 
                                numero1, resultado);
                break;
            case 1: // Falta el primer número (minuendo)
                System.out.printf("¿Cuál es el número faltante en la resta de ___ - %d = %d? ", 
                                numero2, resultado);
                break;
            default: // Falta el resultado
                System.out.printf("¿Cuál es el resultado de la resta de %d - %d = ___ ? ", 
                                numero1, numero2);
        }
    }

    /**
     * Obtiene y valida la respuesta del usuario
     * @return La respuesta válida (número positivo)
     */
    private int obtenerRespuestaValida() {
        int respuesta;
        do {
            respuesta = scanner.nextInt();
            if (respuesta < 0) {
                System.out.print("Por favor, ingresa un número positivo: ");
            }
        } while (respuesta < 0);
        return respuesta;
    }

    /**
     * Valida si la respuesta del usuario es correcta
     * @param respuestaUsuario La respuesta proporcionada por el usuario
     */
    private void validarRespuesta(int respuestaUsuario) {
        boolean esCorrecta = false;
        
        // Evalúa según qué parte del problema estaba oculta
        switch (this.espacioVacio) {
            case 0: // Validación cuando faltaba el segundo numero
                esCorrecta = (numero1 - respuestaUsuario) == resultado;
                break;
            case 1: // Validación cuando faltaba el primer numero
                esCorrecta = (respuestaUsuario - numero2) == resultado;
                break;
            default: // Validación cuando faltaba el resultado
                esCorrecta = respuestaUsuario == resultado;
        }

        // Muestra el feedback al usuario
        if (esCorrecta) {
            System.out.println("¡Correcto!");
        } else {
            // Muestra el número que faltaba
            System.out.printf("Incorrecto. El resultado es: %d%n", 
                           espacioVacio == 1 ? numero1 : numero2);
        }
    }
}