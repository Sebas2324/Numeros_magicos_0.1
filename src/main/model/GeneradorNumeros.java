package main.model;

import java.util.Random;

public class GeneradorNumeros {
    private static final Random rand = new Random();

    public static int generarNumero(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
}