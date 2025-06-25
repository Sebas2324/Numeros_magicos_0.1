package main.model;

import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Jugador jugador = Jugador.registrarJugador();
        Scanner sc = new Scanner(System.in);
        int rondas = 0;

        System.out.println("\n=== COMIENZA EL JUEGO ===");
        while (rondas < 5) { // 5 rondas por partida
            String[] operacion = GeneradorOperaciones.generarOperacion(jugador.getDificultad());
            String[] partes = operacion[0].split(" ");
            int posicionOculta = GeneradorNumeros.generarNumero(0, 2);

            String valorOculto = partes[posicionOculta];
            partes[posicionOculta] = "?";
            String pregunta = String.join(" ", partes);

            System.out.println("\nRonda " + (rondas + 1));
            System.out.println("Operación: " + pregunta + " = " + operacion[1]);
            System.out.print("¿Qué número falta?: ");
            String respuesta = sc.nextLine();

            if (respuesta.equals(valorOculto)) {
                jugador.sumarPuntos(10);
                System.out.println("¡Correcto! +10 puntos");
            } else {
                System.out.println("Fallaste. Era: " + valorOculto);
            }
            rondas++;
        }

        jugador.guardarPuntaje();
        System.out.println("\n=== RESULTADOS ===");
        System.out.println(jugador);
    }
}