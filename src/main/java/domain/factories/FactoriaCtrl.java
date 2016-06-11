package domain.factories;

import domain.controllers.CtrlRecurs;
import domain.controllers.CtrlReserva;
import domain.controllers.CtrlUsuari;

/**
 * Created by usuario on 10/06/2016.
 */
public class FactoriaCtrl {

    private static FactoriaCtrl ourInstance = new FactoriaCtrl();
    private CtrlUsuari ctrlUsuari;
    private CtrlRecurs ctrlRecurs;
    private CtrlReserva ctrlReserva;
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

    public CtrlRecurs getCtrlRecurs(){
        if (ctrlRecurs == null) {
            //ctrlRecurs = new CtrlRecurs();
        }
        return ctrlRecurs;
    }

    public CtrlReserva getCtrlReserva(){
        if (ctrlReserva == null) {
            //ctrlUsuari = new CtrlUsuari();
        }
        return ctrlReserva;
    }

    //TODO: Anar assignant els demes controladors de OBJECTES
}
