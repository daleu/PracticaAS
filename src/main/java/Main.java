import domain.classes.Recurs;
import domain.classes.Reserva;
import domain.classes.Usuari;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by usuario on 06/06/2016.
 */
public class Main {

    public static void main(final String[] args) throws Exception {
        createJocProves();
    }

    private static void createJocProves() {
        HibernateUtils hU = new HibernateUtils();

        List<Usuari> luE = new ArrayList<Usuari>();
        List<Recurs> lrE = new ArrayList<Recurs>();

        Usuari uE = new Usuari("Maria","mariae20","marimari@gmail.com");
        luE.add(uE);
        uE = new Usuari("Lucrecio","LOOP","loop9393@gmail.com");
        luE.add(uE);
        uE = new Usuari("Amancio","amador","amadorLL@gmail.com");
        luE.add(uE);

        for (Usuari u: luE) {
            HibernateUtils.save(u);
        }

        Recurs rE = new Recurs("SALA15");
        lrE.add(rE);
        rE = new Recurs("Ord2323");
        lrE.add(rE);
        rE = new Recurs("projFX8");
        lrE.add(rE);

        for(Recurs r: lrE) {
            HibernateUtils.save(r);
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

        HibernateUtils.save(rr);
    }
}
