import domain.classes.Recurs;
import domain.classes.Reserva;
import domain.classes.Usuari;

import java.sql.Date;
import java.util.ArrayList;
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

        /*List<Usuari> luE = new ArrayList<Usuari>();
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

        Date d = new Date(20160602);
        Date d2 = new Date(20160602);
        Date d3 = new Date(20160602);

        Reserva rr = new Reserva(d,d2,d3, null,rE.getNom(),uE.getUsername());

        HibernateUtils.save(rr);*/
    }
}
