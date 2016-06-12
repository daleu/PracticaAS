package domain.exceptions;


public class RecursNoSala extends Exception {

    private static final String message = "recursNoSala: aquest recurs no es pot reservar";

    public RecursNoSala() {
        super(message);
    }
}
