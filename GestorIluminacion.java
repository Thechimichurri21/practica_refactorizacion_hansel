public class GestorIluminacion {
    // 1. Atributos (Variables de la clase)
    private boolean[] iluminacion;
    private int maxPistas;


    /**
     * Constructor: Inicializa el sistema de luces.
     * @param maxPistas Número total de pistas a gestionar.
     */
    public GestorIluminacion(int maxPistas) {
        this.maxPistas = maxPistas;
        this.iluminacion = new boolean[maxPistas];
    }

    /**
     * Enciende la luz de una pista.
     * @param idPista ID de la pista.
     * @return true si se encendió, false si el ID no es válido.
     */
    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= maxPistas) {
            return false;
        }
        iluminacion[idPista] = true;
        return true;
    }

    /**
     * Apaga la luz de una pista.
     * @param idPista ID de la pista.
     * @return true si se apagó, false si el ID no es válido.
     */
    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= maxPistas) {
            return false;
        }
        iluminacion[idPista] = false;
        return true;
    }
}