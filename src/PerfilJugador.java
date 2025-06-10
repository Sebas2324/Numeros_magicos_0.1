/**
 * Representa el perfil del jugador con una imagen y número de vidas.
 */
public class PerfilJugador {

    private int vidas;
    private final String imagenPerfil;

    /**
     * Crea un nuevo perfil de jugador con 5 vidas y una imagen por defecto.
     */
    public PerfilJugador() {
        this.vidas = 5;
        this.imagenPerfil = "[Sin foto]";
    }

    /**
     * Obtiene el número actual de vidas del jugador.
     * @return número de vidas.
     */
    public int obtenerVidas() {
        return vidas;
    }

    /**
     * Reduce en 1 el número de vidas del jugador, si tiene alguna.
     */
    public void perderVida() {
        if (vidas > 0) {
            vidas--;
        }
    }

    /**
     * Obtiene la imagen del perfil del jugador.
     * @return texto que representa la imagen del perfil.
     */
    public String obtenerImagenPerfil() {
        return imagenPerfil;
    }
}
