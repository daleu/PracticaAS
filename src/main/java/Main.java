import domain.casesControllers.ConsultarRecursosDisponiblesPerDataUseCaseController;
import domain.classes.*;
import domain.dataTypes.RecursDisponiblesPerData;
import domain.factories.FactoriaUseCase;
import domain.hibernate.HibernateUtils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by usuario on 06/06/2016.
 */
public class Main {

    public static void main(final String[] args) throws Exception {
        createJocProves();
        provaConsultarRecursosDisponibles();

    }

    private static void provaConsultarRecursosDisponibles(){
        Ordinador ord = new Ordinador();
        ord.setNom("ord");
        ord.setMarca("HP");
        ord.setModel("125");
        domain.hibernate.HibernateUtils.save(ord);

        Ordinador ord2 = new Ordinador();
        ord2.setNom("ord2");
        ord2.setMarca("HP");
        ord2.setModel("125");
        ord2.setModel("125");
        domain.hibernate.HibernateUtils.save(ord2);

        /*Sala sala = new Sala();
        sala.setNom("sala");
        sala.setAforament(12);
        sala.setOrdinador(ord2);
        sala.setUbicacio("Edifici 3");
        sala.setNomordinador("ord2");
        sala.setRecurs(sala);
        domain.hibernate.HibernateUtils.save(sala);*/

        Projector proj = new Projector();
        proj.setNom("proj");
        proj.setResolucio("1080");
        domain.hibernate.HibernateUtils.save(proj);

        FactoriaUseCase facCU = FactoriaUseCase.getInstance();
        ConsultarRecursosDisponiblesPerDataUseCaseController crData = facCU.getConsultarRecursosDisponiblesPerData();

        Calendar today = Calendar.getInstance();
        Date todaySQL = new Date((today.getTime()).getTime());
        List<RecursDisponiblesPerData> res = new ArrayList<RecursDisponiblesPerData>();
        try{
            res = crData.obtéRecursosDisponiblesPerData(todaySQL, 2, 22);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Num de recursos disponibles: "+res.size());
    }
    private static void createJocProves() {
        HibernateUtils hU = new HibernateUtils();
        /*List<Usuari> luE = new ArrayList<Usuari>();
        List<Recurs> lrE = new ArrayList<Recurs>();

        Usuari uE = new Usuari("Maria","mariae20","marimari@gmail.com");
        luE.add(uE);
        uE = new Usuari("Lucrecio","LOOP","loop9393@gmail.com");
        luE.add(uE);
        uE = new Usuari("Amancio","amador","amadorLL@gmail.com");
        luE.add(uE);

        for (Usuari u: luE) {
            domain.hibernate.HibernateUtils.save(u);
        }


        for(Recurs r: lrE) {
            domain.hibernate.HibernateUtils.save(r);
        }

        //TODO: Ejemplo de como gestionar las fechas y horas
        Calendar cDia = Calendar.getInstance();
        cDia.set(2016,4,30);
        Date dia =  new Date(cDia.getTimeInMillis());

       Calendar cHIni = Calendar.getInstance();
        cHIni.set(Calendar.HOUR_OF_DAY, 12);
        cHIni.set(Calendar.MINUTE,30);
        cHIni.set(Calendar.SECOND,0); //Hay que re-inicializarlo si no se te queda con el actual
        cHIni.set(Calendar.MILLISECOND,0);
        Date dIni =  new Date(cHIni.getTimeInMillis());
        Time tIni = new Time(dIni.getTime());
       Calendar cHFi = Calendar.getInstance();
        cHFi.set(Calendar.HOUR_OF_DAY, 12);
        cHFi.set(Calendar.MINUTE,40);
        cHFi.set(Calendar.SECOND,0);
        cHFi.set(Calendar.MILLISECOND,0);
        Date dFi =  new Date(cHFi.getTimeInMillis());
        Time tFi = new Time(dFi.getTime());

        Reserva rr = new Reserva(dia,tIni,tFi, null,rE.getNom(),uE.getUsername());

        domain.hibernate.HibernateUtils.save(rr);*/
    }
}
