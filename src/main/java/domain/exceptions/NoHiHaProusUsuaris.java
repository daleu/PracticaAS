package domain.exceptions;

/**
 * Created by aleue on 12/6/2016.
 */
public class NoHiHaProusUsuaris  extends Exception{

    private static final String message = "noHiHaProusUsuaris: no hi ha usuaris al sistema que puguin ser assignats";

    public NoHiHaProusUsuaris() {
        super(message);
    }
}