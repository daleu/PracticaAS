package domain.factories;

/**
 * Created by usuario on 11/06/2016.
 */
public class FactoriaAdaptadors {
    private static FactoriaAdaptadors ourInstance = new FactoriaAdaptadors();

    public static FactoriaAdaptadors getInstance() {
        return ourInstance;
    }

    private FactoriaAdaptadors() {
    }
}
