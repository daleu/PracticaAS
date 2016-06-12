package domain.exceptions;

/**
 * Created by aleue on 12/6/2016.
 */
public class ReservaCaducada extends Exception{

    private static final String message = "reservaCaducada: la reserva ja ha caducat";

    public ReservaCaducada() {
        super(message);
    }
}
