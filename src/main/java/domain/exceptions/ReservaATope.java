package domain.exceptions;

/**
 * Created by aleue on 11/6/2016.
 */
public class ReservaATope extends Exception{

    private static final String message = "reservaATope: l'usuari no pot tenir mes de 10 usuaris a notificar";

    public ReservaATope() {
        super(message);
    }
}
