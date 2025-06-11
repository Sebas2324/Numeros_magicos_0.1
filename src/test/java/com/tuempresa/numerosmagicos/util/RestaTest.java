package com.tuempresa.numerosmagicos.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Random;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RestaTest {
    
    private Resta resta;
    private Random randomFijo;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    
    @BeforeEach
    public void setUp() {
        randomFijo = new Random(12345);
        System.setOut(new PrintStream(outputStream));
    }
    
    @Test
    @DisplayName("Constructor con inyección de dependencias")
    public void testConstructorConInyeccion() {
        Scanner testScanner = new Scanner(System.in);
        Resta restaInyectada = new Resta(randomFijo, testScanner);
        assertNotNull(restaInyectada);
    }
    
    @Test
    @DisplayName("Constructor predeterminado")
    void testConstructorPredeterminado() {
        Resta restaDefault = new Resta();
        assertNotNull(restaDefault);
    }
    
    @Test
    @DisplayName("Generación de números - valores válidos")
    void testGenerarNumeros() {
        resta = new Resta(randomFijo, new Scanner(System.in));
        resta.generarNumeros();
        
        int numero1 = resta.getNumero1();
        int numero2 = resta.getNumero2();
        int espacioVacio = resta.getEspacioVacio();
        int resultado = resta.getResultado();
        
        assertTrue(numero1 >= 1 && numero1 <= 10, "Número1 debe estar entre 1 y 10");
        assertTrue(numero2 >= 0 && numero2 < numero1, "Número2 debe ser menor que número1");
        assertTrue(espacioVacio >= 0 && espacioVacio <= 2, "Espacio vacío debe ser 0, 1 o 2");
        assertEquals(numero1 - numero2, resultado, "El resultado debe ser número1 - número2");
    }
    
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("Mostrar problema - diferentes casos de espacio vacío")
    void testMostrarProblema(int espacioVacio) {
        resta = new Resta(randomFijo, new Scanner(System.in));
        
        // Usamos reflexión para establecer el espacioVacio ya que no tiene setter público
        try {
            java.lang.reflect.Field field = Resta.class.getDeclaredField("espacioVacio");
            field.setAccessible(true);
            field.set(resta, espacioVacio);
            
            field = Resta.class.getDeclaredField("numero1");
            field.setAccessible(true);
            field.set(resta, 5);
            
            field = Resta.class.getDeclaredField("numero2");
            field.setAccessible(true);
            field.set(resta, 2);
            
            field = Resta.class.getDeclaredField("resultado");
            field.setAccessible(true);
            field.set(resta, 3);
        } catch (Exception e) {
            fail("Error al configurar campos para la prueba");
        }
        
        outputStream.reset();
        resta.mostrarProblema();
        String mensaje = outputStream.toString().trim();
        
        switch(espacioVacio) {
            case 0:
                assertTrue(mensaje.contains(" - ___ ="), "Debe mostrar espacio para número2");
                break;
            case 1:
                assertTrue(mensaje.contains("___ - "), "Debe mostrar espacio para número1");
                break;
            case 2:
                assertTrue(mensaje.contains("= ___"), "Debe mostrar espacio para resultado");
                break;
        }
    }
    
    @Test
    @DisplayName("Obtener respuesta válida - entrada positiva")
    void testObtenerRespuestaValidaPositiva() {
        String input = "5";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner testScanner = new Scanner(in);
        
        resta = new Resta(randomFijo, testScanner);
        int respuesta = resta.obtenerRespuestaValida();
        
        assertEquals(5, respuesta);
    }
    
    @Test
    @DisplayName("Obtener respuesta válida - entrada negativa seguida de positiva")
    void testObtenerRespuestaValidaCorrigeNegativo() {
        String input = "-3\n4";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner testScanner = new Scanner(in);
        
        resta = new Resta(randomFijo, testScanner);
        outputStream.reset();
        int respuesta = resta.obtenerRespuestaValida();
        
        assertEquals(4, respuesta);
        assertTrue(outputStream.toString().contains("Por favor, ingresa un número positivo"));
    }
    
    @Test
    @DisplayName("Validar respuesta interna - caso 0 (falta número2)")
    void testValidarRespuestaInternaCaso0() {
        resta = new Resta(randomFijo, new Scanner(System.in));
        
        // Configurar estado interno para prueba
        try {
            java.lang.reflect.Field field = Resta.class.getDeclaredField("numero1");
            field.setAccessible(true);
            field.set(resta, 8);
            
            field = Resta.class.getDeclaredField("resultado");
            field.setAccessible(true);
            field.set(resta, 5);
            
            field = Resta.class.getDeclaredField("espacioVacio");
            field.setAccessible(true);
            field.set(resta, 0);
        } catch (Exception e) {
            fail("Error al configurar campos para la prueba");
        }
        
        assertTrue(resta.validarRespuestaInterna(3)); // 8 - 3 = 5
        assertFalse(resta.validarRespuestaInterna(4)); // 8 - 4 ≠ 5
    }
    
    @Test
    @DisplayName("Validar respuesta interna - caso 1 (falta número1)")
    void testValidarRespuestaInternaCaso1() {
        resta = new Resta(randomFijo, new Scanner(System.in));
        
        // Configurar estado interno para prueba
        try {
            java.lang.reflect.Field field = Resta.class.getDeclaredField("numero2");
            field.setAccessible(true);
            field.set(resta, 3);
            
            field = Resta.class.getDeclaredField("resultado");
            field.setAccessible(true);
            field.set(resta, 5);
            
            field = Resta.class.getDeclaredField("espacioVacio");
            field.setAccessible(true);
            field.set(resta, 1);
        } catch (Exception e) {
            fail("Error al configurar campos para la prueba");
        }
        
        assertTrue(resta.validarRespuestaInterna(8)); // 8 - 3 = 5
        assertFalse(resta.validarRespuestaInterna(7)); // 7 - 3 ≠ 5
    }
    
    @Test
    @DisplayName("Validar respuesta interna - caso 2 (falta resultado)")
    void testValidarRespuestaInternaCaso2() {
        resta = new Resta(randomFijo, new Scanner(System.in));
        
        // Configurar estado interno para prueba
        try {
            java.lang.reflect.Field field = Resta.class.getDeclaredField("numero1");
            field.setAccessible(true);
            field.set(resta, 9);

            field = Resta.class.getDeclaredField("numero2");
            field.setAccessible(true);
            field.set(resta, 4);

            field = Resta.class.getDeclaredField("espacioVacio");
            field.setAccessible(true);
            field.set(resta, 2);

            field = Resta.class.getDeclaredField("resultado");
            field.setAccessible(true);
            field.set(resta, 5);
        } catch (Exception e) {
            fail("Error al configurar campos para la prueba");
        }
        
        assertTrue(resta.validarRespuestaInterna(5)); // 9 - 4 = 5
        assertFalse(resta.validarRespuestaInterna(6)); // 9 - 4 ≠ 6
    }
    
    @Test
    @DisplayName("Validar respuesta - caso correcto")
    void testValidarRespuestaCorrecta() {
        resta = new Resta(randomFijo, new Scanner(System.in));
        
        // Configurar estado interno para prueba
        try {
            java.lang.reflect.Field field = Resta.class.getDeclaredField("numero1");
            field.setAccessible(true);
            field.set(resta, 7);
            
            field = Resta.class.getDeclaredField("numero2");
            field.setAccessible(true);
            field.set(resta, 2);
            
            field = Resta.class.getDeclaredField("resultado");
            field.setAccessible(true);
            field.set(resta, 5);
            
            field = Resta.class.getDeclaredField("espacioVacio");
            field.setAccessible(true);
            field.set(resta, 2);
        } catch (Exception e) {
            fail("Error al configurar campos para la prueba");
        }
        
        outputStream.reset();
        resta.validarRespuesta(5);
        assertTrue(outputStream.toString().contains("¡Correcto!"));
    }
    
    @Test
    @DisplayName("Validar respuesta - caso incorrecto")
    void testValidarRespuestaIncorrecta() {
        resta = new Resta(randomFijo, new Scanner(System.in));
        
        // Configurar estado interno para prueba
        try {
            java.lang.reflect.Field field = Resta.class.getDeclaredField("numero1");
            field.setAccessible(true);
            field.set(resta, 7);
            
            field = Resta.class.getDeclaredField("numero2");
            field.setAccessible(true);
            field.set(resta, 2);
            
            field = Resta.class.getDeclaredField("resultado");
            field.setAccessible(true);
            field.set(resta, 5);
            
            field = Resta.class.getDeclaredField("espacioVacio");
            field.setAccessible(true);
            field.set(resta, 2);
        } catch (Exception e) {
            fail("Error al configurar campos para la prueba");
        }
        
        outputStream.reset();
        resta.validarRespuesta(4);
        assertTrue(outputStream.toString().contains("Incorrecto"));
        assertTrue(outputStream.toString().contains("5")); // El resultado correcto
    }
}