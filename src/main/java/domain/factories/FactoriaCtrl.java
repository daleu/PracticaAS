package domain.factories;

import domain.controllers.CtrlUsuari;

/**
 * Created by usuario on 10/06/2016.
 */
public class FactoriaCtrl {

    private static FactoriaCtrl ourInstance = new FactoriaCtrl();
    private CtrlUsuari ctrlUsuari;

    public static FactoriaCtrl getInstance() {
        return ourInstance;
    }

    private FactoriaCtrl() {


    }

    public CtrlUsuari getCtrlUsuari(){
        if (ctrlUsuari == null) {
           //ctrlUsuari = new CtrlUsuari();
        }
        return ctrlUsuari;
    }

    //TODO: Anar assignant els demes controladors de OBJECTES
}
