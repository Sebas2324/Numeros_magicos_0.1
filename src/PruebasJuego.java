import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas unitarias para verificar el comportamiento del juego:
 * Para este caso, las pruebas fueron ejecutadas desde el terminal CMD de Visual Studio Code
 * para lo cual, se utiliza el siguiente comando: 
 * -cp " bin;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar org.junit.runner.JunitCore PruebasJuego.
 */

public class PruebasJuego {

    @Test
    public void testVidasIniciales() {
        PerfilJugador jugador = new PerfilJugador();
        assertEquals(5, jugador.obtenerVidas());
    }

    @Test
    public void testPerderVida() {
        PerfilJugador jugador = new PerfilJugador();
        jugador.perderVida();
        assertEquals(4, jugador.obtenerVidas());
    }
    
}