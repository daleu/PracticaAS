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
        if(hf < hi) {
            throw new PeriodeErrorni();
        }

        Calendar today = Calendar.getInstance();
        Date todaySQL = new Date((today.getTime()).getTime());

        if(d.before(todaySQL)){
            throw new PeriodeErrorni();
        }

        FactoriaCtrl facCtrl = FactoriaCtrl.getInstance();
        CtrlRecurs recCtrl = facCtrl.getCtrlRecurs();
        CtrlReserva resCtrl = facCtrl.getCtrlReserva();



        Collection<Recurs> llistaRecursosTotal = recCtrl.getAll();

        List<RecursDisponiblesPerData> llistaRecursosDisponibles = new ArrayList<RecursDisponiblesPerData>();

        for(Recurs r: llistaRecursosTotal) {
            if(r.getDisponibilitat(d,hi,hf)) {
                llistaRecursosDisponibles.add(r.getInfo());
            }
        }
        if(llistaRecursosDisponibles.size() < 1){
            throw new NoHiHaRecursos();
        }
        return llistaRecursosDisponibles;


        /*for(Recurs r: llistaRecursosTotal){
            //Per cada recurs mirem si te alguna reserva que sigui conflictiva (es a dir que comenci dintre de hi -- hf)
            Boolean ocupat = false;
            for (int j = hi; j < hf; ++j){
                Reserva reserva = resCtrl.getReserva(r.getNom(),j,d);
                if(reserva != null){
                    ocupat = true;
                }
            }
            if(!ocupat){
                llistaRecursosDisponibles.add(r);
            }
        }

        //En la lista llistaRecursosDisponibles tenemos todos los recursos que no tienen una reserva en que se solape.
        //Hay que mirar de todos ellos si alguno es sala, mirar si tiene ordenadores i proyectores y quitarlos de disponibles
        for(int i = 0; i<llistaRecursosDisponibles.size(); ++i){
            if(llistaRecursosDisponibles.get(i).getClass().equals(Sala.class)){
                Sala s = (Sala) llistaRecursosDisponibles.get(i);
                if(s.getNomordinador() != null){
                    java.lang.String nomOrd =  s.getNomordinador();
                    llistaRecursosDisponibles = ElimnarElementsDeLaSala(nomOrd, llistaRecursosDisponibles);
                }
                if(s.getNomprojector() != null){
                    java.lang.String nomProj =  s.getNomprojector();
                    llistaRecursosDisponibles = ElimnarElementsDeLaSala(nomProj, llistaRecursosDisponibles);
                }
            }
        }
        //Por cada recurso si es de un tipo o de otro rellenar en el struct y añadirlo a result
        //S'ha de fer el filtratge

        for(int i = 0; i < llistaRecursosDisponibles.size(); ++i){
            RecursDisponiblesPerData r = new RecursDisponiblesPerData();
            r.nom =  llistaRecursosDisponibles.get(i).getNom();
            if(llistaRecursosDisponibles.get(i).getClass().equals(Sala.class)){
                Sala sala = (Sala) llistaRecursosDisponibles.get(i);
                r.aforament = sala.getAforament();
                r.ubicacio = sala.getUbicacio();
                if(sala.getNomordinador() != null){
                    Ordinador ordS = (Ordinador)recCtrl.getRecurs(sala.getNomordinador());
                    r.marcaOrdSala = ordS.getMarca();
                    r.marcaOrdSala = ordS.getModel();
                }
                else if(sala.getNomprojector() != null){
                    Projector projS = (Projector)recCtrl.getRecurs(sala.getNomprojector());
                    r.resolucióProjSala = projS.getResolucio();
                }
            }
            else if(llistaRecursosDisponibles.get(i).getClass().equals(Projector.class)){
                Projector proj = (Projector) llistaRecursosDisponibles.get(i);
                r.resolucio = proj.getResolucio();
            }
            else if(llistaRecursosDisponibles.get(i).getClass().equals(Ordinador.class)){
                Ordinador ord = (Ordinador) llistaRecursosDisponibles.get(i);
                r.marca = ord.getMarca();
                r.model = ord.getModel();
            }
            result.add(r);

        }*/
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
