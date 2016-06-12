package domain.exceptions;


public class PeriodeErrorni extends Exception {

    private static final String message = "periodeErroni: HoraInici i HorarFi no concordes";

    public PeriodeErrorni() {
        super(message);
    }
}
