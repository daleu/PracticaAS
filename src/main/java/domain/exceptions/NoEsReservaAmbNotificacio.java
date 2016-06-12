package domain.exceptions;

/**
 * Created by aleue on 11/6/2016.
 */
public class NoEsReservaAmbNotificacio extends Exception{

    private static final String message = "noReservaAmbNotificació: la reserva no és del tipus amb notificació";

    public NoEsReservaAmbNotificacio() {
        super(message);
    }
}
