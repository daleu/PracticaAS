package domain.factories;

import persistence.classesDBCtrls.CtrlRecursDB;
import persistence.classesDBCtrls.CtrlReservaDB;
import persistence.classesDBCtrls.CtrlUsuariDB;
import domain.controllers.CtrlRecurs;
import domain.controllers.CtrlReserva;
import domain.controllers.CtrlUsuari;

public class FactoriaCtrl {

    private static FactoriaCtrl ourInstance = new FactoriaCtrl();
    private CtrlUsuari ctrlUsuari;
    private CtrlReserva ctrlReserva;
    private CtrlRecurs ctrlRecurs;

    public static FactoriaCtrl getInstance() {
        return ourInstance;
    }

    private FactoriaCtrl() {
    }

    public CtrlUsuari getCtrlUsuari(){
        if (ctrlUsuari == null) {
           ctrlUsuari = new CtrlUsuariDB();
        }
        return ctrlUsuari;
    }

    public CtrlReserva getCtrlReserva() {
        if (ctrlReserva == null) {
            ctrlReserva = new CtrlReservaDB();
        }
        return ctrlReserva;
    }

    public CtrlRecurs getCtrlRecurs() {
        if (ctrlRecurs == null) {
            ctrlRecurs = new CtrlRecursDB();
        }
        return ctrlRecurs;
    }

}
