package domain.casesControllers;

import domain.classes.*;
import domain.controllers.CtrlRecurs;
import domain.controllers.CtrlReserva;
import domain.factories.FactoriaCtrl;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist_000 on 11/06/2016.
 */
public class ConsultarRecursosDisponiblesPerDataUseCaseController {

    class RecursDisponiblesPerData {
        String nom;
        String marca;
        String model;
        String resolució;
        String aforament;
        String ubicació;
        String marcaOrdSala;
        String modelOrdSala;
        String resolucióProjSala;
    };


    public List<RecursDisponiblesPerData> obtéRecursosDisponiblesPerData(Date d, Integer hi, Integer hf) throws Exception {

        List <RecursDisponiblesPerData>  result = new ArrayList<RecursDisponiblesPerData>();
        if(hf < hi) {
            throw new Exception("exc períodeErroni: el periode és erroni");
        }
        Date today = new Date();
        if(d.before(today)){
            throw new Exception("exc períodeErroni: el periode és erroni");
        }

        FactoriaCtrl facCtrl = FactoriaCtrl.getInstance();
        CtrlRecurs recCtrl = facCtrl.getCtrlRecurs();
        CtrlReserva resCtrl = facCtrl.getCtrlReserva();
        List<Recurs> llistaRecursosTotal = recCtrl.getAll();
        List<Recurs> llistaRecursosDisponibles = new ArrayList<Recurs>();
        for(int i = 0; i < llistaRecursosTotal.size(); ++i){
            //Per cada recurs mirem si te alguna reserva que sigui conflictiva (es a dir que comenci dintre de hi -- hf)
            Boolean ocupat = false;
            for (int j = hi; j < hf; ++j){
                Reserva reserva = resCtrl.getReserva(llistaRecursosTotal.get(i).getNom(),j,d);
                if(reserva != null){
                    ocupat = true;
                }
            }
            if(!ocupat){
                llistaRecursosDisponibles.add(llistaRecursosTotal.get(i));
            }

        }
        //En la lista llistaRecursosDisponibles tenemos todos los recursos que no tienen una reserva en que se solape.
        //Hay que mirar de todos ellos si alguno es sala, mirar si tiene ordenadores i proyectores y quitarlos de disponibles
        //Por cada recurso si es de un tipo o de otro rellenar en el struct y añadirlo a result

        RecursDisponiblesPerData r = new RecursDisponiblesPerData();
        for(int i = 0; i < llistaRecursosDisponibles.size(); ++i){
            r.nom =  llistaRecursosDisponibles.get(i).getNom();
            result.add(r);
        }

        return result;
    }




    //TODO: Operacions de crida a la persistencia
}
