import java.util.Scanner;

/**
 * Clase encargada de mostrar la pantalla de inicio del juego Números Mágicos.
 */
public class JuegoInicio {

    private final PerfilJugador jugador;

    /**
     * Crea una nueva instancia del juego e inicializa el perfil del jugador.
     */
    public JuegoInicio() {
        this.jugador = new PerfilJugador();
    }

    /**
     * Muestra en consola la pantalla de inicio con el menú de operaciones.
     */
    public void mostrarPantallaInicio() {
        System.out.println("=====================================");
        System.out.println("       ¡Bienvenido a Números Mágicos!");
        System.out.println("=====================================");
        System.out.println("Perfil del jugador: " + jugador.obtenerImagenPerfil());
        System.out.println("Vidas: " + "❤".repeat(jugador.obtenerVidas()));
        System.out.println("\nSelecciona una opción:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("0. Salir");
    }

    /**
     * Ejecuta el menú del juego, permitiendo al usuario elegir opciones.
     */
    public void ejecutar() {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do {
            mostrarPantallaInicio();
            System.out.print("Ingresa tu opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1 -> System.out.println("Has elegido: Suma.");
                case 2 -> System.out.println("Has elegido: Resta.");
                case 3 -> System.out.println("Has elegido: Multiplicación.");
                case 4 -> System.out.println("Has elegido: División.");
                case 0 -> System.out.println("Gracias por jugar. ¡Hasta pronto!");
                default -> System.out.println("Opción no válida. Intenta de nuevo.");
            }

            System.out.println(); // Línea en blanco para separar iteraciones
        } while (opcion != 0);

        entrada.close();
    }

    /**
     * Devuelve el perfil del jugador (uso interno o para pruebas).
     * @return el perfil del jugador.
     */
    public PerfilJugador obtenerPerfilJugador() {
        return jugador;
    }
}