package domain.factories;


import domain.adaptadors.AdaptadorMissatgeria;
import domain.adaptadors.IAdaptadorMissatgeria;

public class FactoriaAdaptadors {

    private IAdaptadorMissatgeria iAdaptadorMissatgeria;

    private static FactoriaAdaptadors ourInstance = new FactoriaAdaptadors();

    public static FactoriaAdaptadors getInstance() {
        return ourInstance;
    }

    private FactoriaAdaptadors() {
    }

    public IAdaptadorMissatgeria getAdaptadorMissatgeria(){

        if(iAdaptadorMissatgeria == null) {
           // iAdaptadorMissatgeria  = new IAdaptadorMissatgeria();
        }
        return iAdaptadorMissatgeria;
    }
}
