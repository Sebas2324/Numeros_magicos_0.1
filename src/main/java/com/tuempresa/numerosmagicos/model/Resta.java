package com.tuempresa.numerosmagicos.util;

import java.util.Random;
import java.util.Scanner;

public class Resta {
    private final Random random;
    private final Scanner scanner;
    private int numero1;
    private int numero2;
    private int espacioVacio;
    private int resultado;

    // Constructor para inyección de dependencias
    public Resta(Random random, Scanner scanner) {
        this.random = random;
        this.scanner = scanner;
    }

    // Constructor predeterminado para uso normal
    public Resta() {
        this(new Random(), new Scanner(System.in));
    }

    public void realizarResta() {
        generarNumeros();
        mostrarProblema();
        int respuestaUsuario = obtenerRespuestaValida();
        validarRespuesta(respuestaUsuario);
    }

    protected void generarNumeros() {
        this.numero1 = random.nextInt(10) + 1;
        this.numero2 = random.nextInt(this.numero1);
        this.espacioVacio = random.nextInt(3);
        this.resultado = this.numero1 - this.numero2;
    }

    protected void mostrarProblema() {
        String mensaje = switch (this.espacioVacio) {
            case 0 -> String.format("¿Cuál es el número faltante en la resta de %d - ___ = %d? ", numero1, resultado);
            case 1 -> String.format("¿Cuál es el número faltante en la resta de ___ - %d = %d? ", numero2, resultado);
            default -> String.format("¿Cuál es el resultado de la resta de %d - %d = ___ ? ", numero1, numero2);
        };
        System.out.print(mensaje);
    }

    protected int obtenerRespuestaValida() {
        int respuesta;
        do {
            respuesta = scanner.nextInt();
            if (respuesta < 0) {
                System.out.print("Por favor, ingresa un número positivo: ");
            }
        } while (respuesta < 0);
        return respuesta;
    }

    protected boolean validarRespuestaInterna(int respuestaUsuario) {
        return switch (this.espacioVacio) {
            case 0 -> (numero1 - respuestaUsuario) == resultado;
            case 1 -> (respuestaUsuario - numero2) == resultado;
            default -> respuestaUsuario == resultado;
        };
    }

    protected void validarRespuesta(int respuestaUsuario) {
        boolean esCorrecta = validarRespuestaInterna(respuestaUsuario);
        if (esCorrecta) {
            System.out.println("¡Correcto!");
        } else {
            System.out.printf("Incorrecto. El resultado es: %d%n", resultado);
        }
    }

    // Getters para testing
    public int getNumero1() { return numero1; }
    public int getNumero2() { return numero2; }
    public int getEspacioVacio() { return espacioVacio; }
    public int getResultado() { return resultado; }
}