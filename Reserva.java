import java.time.LocalDate;

public class Reserva {
    private int idPista;
    private LocalDate fecha;
    private int duracion;

    public Reserva(int idPista, LocalDate fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public int getIdPista() {
        return idPista;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getDuracion() {
        return duracion;
    }
}