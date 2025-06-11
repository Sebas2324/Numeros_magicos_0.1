package com.tuempresa.numerosmagicos.util;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

class RestaTest {
    private Resta resta;
    private Random mockRandom;
    private Scanner mockScanner;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        mockRandom = mock(Random.class);
        mockScanner = mock(Scanner.class);
        resta = new Resta(mockRandom, mockScanner);
        System.setOut(new PrintStream(outContent)); // Captura System.out
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out); // Restaura System.out
    }

    @Test
    @DisplayName("Generar números debe configurar valores correctos")
    void testGenerarNumeros() {
        when(mockRandom.nextInt(10)).thenReturn(5);  // numero1 = 6 (5+1)
        when(mockRandom.nextInt(6)).thenReturn(2);   // numero2 = 2
        when(mockRandom.nextInt(3)).thenReturn(0);   // espacioVacio = 0

        resta.generarNumeros();

        assertEquals(6, resta.getNumero1());
        assertEquals(2, resta.getNumero2());
        assertEquals(4, resta.getResultado());
    }

    @Test
    @DisplayName("Validar respuesta correcta cuando falta el resultado")
    void testValidarRespuesta_Correcta() {
        resta.numero1 = 10;
        resta.numero2 = 4;
        resta.resultado = 6;
        resta.espacioVacio = 2; // Falta resultado

        assertTrue(resta.validarRespuestaInterna(6));
    }

    @Test
    @DisplayName("Mostrar problema imprime formato correcto")
    void testMostrarProblema() {
        resta.numero1 = 7;
        resta.numero2 = 2;
        resta.resultado = 5;
        resta.espacioVacio = 1; // Falta primer número

        resta.mostrarProblema();
        assertEquals("¿Cuál es el número faltante en la resta de ___ - 2 = 5? ", outContent.toString());
    }
}