package domain.factories;

import domain.controllers.CtrlUsuari;

/**
 * Created by usuario on 10/06/2016.
 */
public class FactoriaUseCase {

    private static FactoriaUseCase ourInstance = new FactoriaUseCase();
    public static FactoriaUseCase getInstance() {
        return ourInstance;
    }


}
