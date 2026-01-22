import java.time.LocalDate;

/**
 * Representa una reserva individual en el sistema.
 * @author Hansel Altamirano
 * @version 1.0
 */
public class Reserva {
    private int idPista;
    private LocalDate fecha;
    private int duracion;

    /**
     * Constructor para crear una nueva reserva
     * @param idPista idPista Identificador unico de la pista.
     * @param fecha fecha Fecha de la reserva (LocalDate)
     * @param duracion duracion Tiempo de uso en minutos o bloques.
     */
    public Reserva(int idPista, LocalDate fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    /** @return El ID de la pista reservada */
    public int getIdPista() {
        return idPista;
    }

    /** @return La fecha de la reserva*/
    public LocalDate getFecha() {
        return fecha;
    }

    /** @return La duracion de la reserva*/
    public int getDuracion() {
        return duracion;
    }
}