package domain.exceptions;

/**
 * Created by aleue on 11/6/2016.
 */
public class NoHiHaReserva extends Exception{

    private static final String message = "noHiHaReserva: no existeix la reserva.";

    public NoHiHaReserva() {
        super(message);
    }
}
