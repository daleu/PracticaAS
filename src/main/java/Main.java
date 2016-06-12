import domain.casesControllers.AssignarUsuarisANotificarUseCaseController;
import domain.casesControllers.ConsultarRecursosDisponiblesPerDataUseCaseController;
import domain.classes.*;
import domain.dataTypes.RecursDisponiblesPerData;
import domain.dataTypes.TupleUsers;
import domain.factories.FactoriaUseCase;
import persistence.hibernate.HibernateUtils;
import presentation.crearReservaController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Created by usuario on 06/06/2016.
 */
public class Main {

    public static void main(final String[] args) throws Exception {
        //createJocProves();
        //provaConsultarRecursosDisponibles();
        provaConsultarUsuarisAAssignar();
        //crearReservaController crc = new crearReservaController();
    }

    private static void provaConsultarUsuarisAAssignar() {

        Projector proj = new Projector();
        proj.setNom("proj2");
        proj.setResolucio("1080");
        persistence.hibernate.HibernateUtils.save(proj);

        Usuari uE = new Usuari("Maria","mariae20","marimari@gmail.com");
        persistence.hibernate.HibernateUtils.save(uE);
        Usuari uR = new Usuari("Elena","elenabdn","elena.bdn@gmail.com");
        persistence.hibernate.HibernateUtils.save(uR);
        Usuari uX = new Usuari("David","aleueet","aleueet@gmail.com");
        persistence.hibernate.HibernateUtils.save(uX);

        Calendar cDia = Calendar.getInstance();
        cDia.set(2016,7,30);
        Date dia =  new Date(cDia.getTimeInMillis());

        Integer hi = 2;
        Integer hf = 3;

        ReservaAmbNotificacio rr = new ReservaAmbNotificacio(dia,hi,hf, null,proj.getNom(),uE.getUsername(),uE);
        ArrayList<Usuari> aux = new ArrayList<Usuari>();
        aux.add(uR);
        aux.add(uE);
        rr.setUsuaris(aux);
        persistence.hibernate.HibernateUtils.save(rr);

        uR.setReserves(Collections.singletonList(rr));
        persistence.hibernate.HibernateUtils.update(uR);

        uE.setReserves(Collections.singletonList(rr));
        persistence.hibernate.HibernateUtils.update(uE);


        FactoriaUseCase facCU = FactoriaUseCase.getInstance();
        AssignarUsuarisANotificarUseCaseController auanucc = facCU.getAssignarUsuarisANotificarAUnaReserva();

        List<TupleUsers> res = new ArrayList<TupleUsers>();

        try{
            res = auanucc.obteUsuarisAAssignar(rr.getNomrecurs(),rr.getData(),rr.getHorainici());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Num usuaris disponibles: "+res.size());
    }

    private static void provaConsultarRecursosDisponibles() throws Exception {
        Ordinador ord = new Ordinador();
        ord.setNom("ord");
        ord.setMarca("HP");
        ord.setModel("125");
        persistence.hibernate.HibernateUtils.save(ord);

        Ordinador ord2 = new Ordinador();
        ord2.setNom("ord2");
        ord2.setMarca("HP");
        ord2.setModel("125");
        ord2.setModel("125");
        persistence.hibernate.HibernateUtils.save(ord2);

       /*
        Sala sala = new Sala();
        sala.setNom("sala");
        sala.setAforament(12);
        sala.setOrdinador(ord2);
        sala.setUbicacio("Edifici 3");
        sala.setNomordinador("ord2");
        sala.setRecurs(sala);
        persistence.hibernate.HibernateUtils.save(sala);*/

        Projector proj = new Projector();
        proj.setNom("proj");
        proj.setResolucio("1080");
        persistence.hibernate.HibernateUtils.save(proj);

        FactoriaUseCase facCU = FactoriaUseCase.getInstance();
        ConsultarRecursosDisponiblesPerDataUseCaseController crData = facCU.getConsultarRecursosDisponiblesPerData();

        Calendar today = Calendar.getInstance();
        Date todaySQL = new Date((today.getTime()).getTime());

        List<RecursDisponiblesPerData> res = new ArrayList<RecursDisponiblesPerData>();
        try{
            res = crData.obtéRecursosDisponiblesPerData(todaySQL, 2, 22);
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        System.out.println("Num de recursos disponibles per data "+todaySQL.toString()+": "+res.size()+" recursos");
    }
    private static void createJocProves() {
        HibernateUtils hU = new HibernateUtils();
        Projector proj = new Projector();
        proj.setNom("proj2");
        proj.setResolucio("1080");
        persistence.hibernate.HibernateUtils.save(proj);

        Usuari uE = new Usuari("Maria","mariae20","marimari@gmail.com");
        persistence.hibernate.HibernateUtils.save(uE);

        Calendar cDia = Calendar.getInstance();
        cDia.set(2016,4,30);
        Date dia =  new Date(cDia.getTimeInMillis());

        Integer hi = 2;
        Integer hf = 3;

        ReservaAmbNotificacio rr = new ReservaAmbNotificacio(dia,hi,hf, null,proj.getNom(),uE.getUsername(),uE);
        persistence.hibernate.HibernateUtils.save(rr);
        uE.setReserves(Collections.singletonList(rr));
        persistence.hibernate.HibernateUtils.update(uE);
        /*List<Usuari> luE = new ArrayList<Usuari>();
        List<Recurs> lrE = new ArrayList<Recurs>();

        Usuari uE = new Usuari("Maria","mariae20","marimari@gmail.com");
        luE.add(uE);
        uE = new Usuari("Lucrecio","LOOP","loop9393@gmail.com");
        luE.add(uE);
        uE = new Usuari("Amancio","amador","amadorLL@gmail.com");
        luE.add(uE);

        for (Usuari u: luE) {
            persistence.hibernate.HibernateUtils.save(u);
        }


        for(Recurs r: lrE) {
            persistence.hibernate.HibernateUtils.save(r);
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

        persistence.hibernate.HibernateUtils.save(rr);*/
    }
}
