package com.tuempresa.numerosmagicos.util;
import java.util.Random;
import java.util.Scanner;

public class Resta {
    
    Random random = new Random();
    private int numero1;
    private int numero2; 
    private int espacio_vacio 
    private int resultado;
    private int resultado_usuario;
    private int respuestaUsuario;
    public static void realizarResta() {
        // Verifica que el primer número sea mayor que el segundo
        this.numero1 = random.nextInt(10) + 1; // Genera un número aleatorio entre 1 y 100
        this.numero2 = random.nextInt(this.numero1); // Genera un número aleatorio menor que numero1
        this.espacio_vacio = random.nextInt(3); // Número entre 0 y 3
        Scanner scanner = new Scanner(System.in);
        this.resultado = this.numero1 - this.numero2; // Calcula la resta
        if this.espacio_vacio == 0 {
            // Si espacio_vacio es 0, muestra el primer número y un espacio vacío
            System.out.print("¿Cuál es el número faltante en la resta de " + this.numero1 + " - ___ ="+this.resultado+"? ");
        } else if this.espacio_vacio == 1 {
            // Si espacio_vacio es 1, muestra un espacio vacío y el segundo número
            System.out.print("¿Cuál es el número faltante en la resta de ___ - " + this.numero2 + "="+this.resultado+"? ");
        } else {
            // Si espacio_vacio es 2, muestra ambos números con un espacio vacío
            System.out.print("¿Cuál es el resultado de la resta de " + this.numero1 + " y " + this.numero2 + "= ___ ? ");
        }
                 
        this.respuestaUsuario = scanner.nextInt(); // Lee la respuesta del usuario
        while this.respuestaUsuario < 0 {
            // Si la respuesta es negativa, pide al usuario que ingrese un número positivo
            System.out.print("Por favor, ingresa un número positivo: ");
            this.respuestaUsuario = scanner.nextInt();
        }
        // Imprime el resultado de la resta
        System.out.println("Resultado de la resta: " + numero1 + " - " + numero2 + " = " + resultado);
        if this.espacio_vacio == 0 {
            this.resultado_usuario=this.numero1-this.respuestaUsuario;
            this validar_respuesta(this.resultado_usuario, this.resultado, this.numero2);
        } else if espacio_vacio == 1 {
            this.resultado_usuario=this.respuestaUsuario-this.numero2;
             this validar_respuesta(this.resultado_usuario, this.resultado, this.numero2);
        } else {
            this.resultado_usuario=this.respuestaUsuario;
             this validar_respuesta(this.resultado_usuario, this.resultado, this.numero2);
        }
       
            
    }
    public static void validar_respuesta(int respuestaUsuario, int resultado, int numero_secreto) {
        if (respuestaUsuario == resultado) {
            System.out.println("¡Correcto!");
        } else {
            System.out.println("Incorrecto. El resultado es: " + numero_secreto);
        }
        
       }   
    
}