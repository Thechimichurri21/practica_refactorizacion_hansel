import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaReservasDeportivas {

    private List<Reserva> reservas;
    //Nueva conexion con el gestor de luces
    private GestorIluminacion gestorLuces;
    private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas

    public SistemaReservasDeportivas() {
        this.reservas = new ArrayList<>();
        //El gestor se crea al iniciar el sistema
        this.gestorLuces = new GestorIluminacion(MAX_PISTAS);
    }

    public boolean reservarPista(Reserva nuevaReserva) {
        if (nuevaReserva.getIdPista() < 0 || nuevaReserva.getIdPista() >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva existente : reservas) {
            if (comparaFechas(nuevaReserva.getIdPista(), nuevaReserva.getFecha(),existente)) return false; // La pista ya está reservada en esa fecha
        }
        reservas.add(nuevaReserva);
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
        return gestorLuces.encenderLuces(idPista);
    }
    public boolean apagarLuces(int idPista) {
        return gestorLuces.encenderLuces(idPista);
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