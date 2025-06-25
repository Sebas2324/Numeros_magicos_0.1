package main.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jugador implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String nombre;
    private int puntaje;
    private final int dificultad;
    private static final String ARCHIVO_PUNTAJES = "puntajes.dat";

    public Jugador(String nombre, int dificultad) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.puntaje = 0;
    }

    public void sumarPuntos(int puntos) {
        puntaje += puntos;
    }

    public static Jugador registrarJugador() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- REGISTRO ---");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Dificultad:\n1. Fácil\n2. Medio\n3. Difícil");
        System.out.print("Opción: ");
        int dificultad = sc.nextInt();

        return new Jugador(nombre, dificultad);
    }

    public void guardarPuntaje() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_PUNTAJES, true))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public static List<Jugador> cargarPuntajes() {
        List<Jugador> puntajes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_PUNTAJES))) {
            while (true) {
                puntajes.add((Jugador) ois.readObject());
            }
        } catch (EOFException e) {
            // Fin del archivo
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar: " + e.getMessage());
        }
        return puntajes;
    }

    @Override
    public String toString() {
        return nombre + " - Puntos: " + puntaje + " (Dificultad: " + dificultad + ")";
    }
}