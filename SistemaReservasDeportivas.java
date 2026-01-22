import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaReservasDeportivas {

    private List<Reserva> reservas;
    private boolean[] iluminacion;
    private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas

    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        iluminacion = new boolean[MAX_PISTAS];
    }

    public boolean reservarPista(int idPista, LocalDate fecha, int duracion) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (comparaFechas(idPista, fecha, r)) return false; // La pista ya está reservada en esa fecha
        }
        reservas.add(new Reserva(idPista, fecha, duracion));
        return true;
    }

    private static boolean comparaFechas(int idPista, LocalDate fecha, Reserva r) {
        if (r.getIdPista() == idPista && r.getFecha().isEqual(fecha)) {
            return true;
        }
        return false;
    }

    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }

    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }

    public boolean apagarluces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }

    public boolean verificarDisponibilidad(int idPista, LocalDate fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (esFechaDisponible(idPista, fecha, r)) return false; // La pista no está disponible en esa fecha
        }
        return true; // La pista está disponible
    }

    private static boolean esFechaDisponible(int idPista, LocalDate fecha, Reserva r) {
        if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
            return true;
        }
        return false;
    }
}