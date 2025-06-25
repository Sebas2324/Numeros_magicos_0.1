package main.model;
import .main.model.GeneradorNumeros;

public class GeneradorOperaciones {
    private static final String[] OPERADORES = {"+", "-", "*"};

    public static String[] generarOperacion(int dificultad) {
        int rango = switch(dificultad) {
            case 1 -> 10;  // Fácil
            case 2 -> 50;  // Medio
            case 3 -> 100; // Difícil
            default -> 10;
        };

        int num1 = GeneradorNumeros.generarNumero(1, rango);
        int num2 = GeneradorNumeros.generarNumero(1, rango);
        String operador = OPERADORES[GeneradorNumeros.generarNumero(0, OPERADORES.length-1)];

        String operacion = num1 + " " + operador + " " + num2;
        int resultado = calcularResultado(num1, num2, operador);

        return new String[]{operacion, String.valueOf(resultado)};
    }

    private static int calcularResultado(int a, int b, String op) {
        return switch(op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> 0;
        };
    }
}