package domain.exceptions;


public class NoHiHaRecursos extends Exception {

    private static final String message = "noHiHaRecursos: No hi ha recursos disponibles per aquest periode";

    public NoHiHaRecursos() {
        super(message);
    }
}
