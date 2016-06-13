package domain.casesControllers;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.sun.org.apache.xpath.internal.operations.String;
import domain.classes.*;
import domain.controllers.CtrlRecurs;
import domain.controllers.CtrlReserva;
import domain.exceptions.NoHiHaRecursos;
import domain.exceptions.PeriodeErrorni;
import domain.factories.FactoriaCtrl;
import domain.factories.FactoriaUseCase;
import domain.dataTypes.RecursDisponiblesPerData;

import javax.persistence.Tuple;
import java.sql.Date;
import java.util.*;


public class ConsultarRecursosDisponiblesPerDataUseCaseController {
    public List<RecursDisponiblesPerData> obtéRecursosDisponiblesPerData(Date d, Integer hi, Integer hf) throws Exception {

        List <RecursDisponiblesPerData>  result = new ArrayList<RecursDisponiblesPerData>();
        System.out.println("hi "+hi+" ieffqwf "+hf);
        if(hf < hi) {
            throw new PeriodeErrorni();
        }

        Calendar today = Calendar.getInstance();
        Date todaySQL = new Date((today.getTime()).getTime());

        System.out.println(d);
        System.out.println(todaySQL);
        System.out.println(d.before(todaySQL));

        if(d.before(todaySQL)){
            throw new PeriodeErrorni();
        }

        FactoriaCtrl facCtrl = FactoriaCtrl.getInstance();
        CtrlRecurs recCtrl = facCtrl.getCtrlRecurs();

        Collection<Recurs> llistaRecursosTotal = recCtrl.getAll();

        List<RecursDisponiblesPerData> llistaRecursosDisponibles = new ArrayList<RecursDisponiblesPerData>();

        for(Recurs r: llistaRecursosTotal) {
            if(r.getDisponibilitat(d,hi,hf)) {
                llistaRecursosDisponibles.add(r.returnInfo());
            }
        }
        if(llistaRecursosDisponibles.size() < 1){
            throw new NoHiHaRecursos();
        }
        return llistaRecursosDisponibles;
    }


    private List<Recurs> ElimnarElementsDeLaSala(java.lang.String s, List<Recurs> l) {
        for (Iterator<Recurs> iterator = l.iterator(); iterator.hasNext(); ) {
            Recurs r = iterator.next();
            if (r.getNom().equals(s)) {
                iterator.remove();

            }
        }
        return l;
    }


    //TODO: Operacions de crida a la persistencia
}
