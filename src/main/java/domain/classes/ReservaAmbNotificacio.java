package domain.classes;

import domain.exceptions.NoEsReservaAmbNotificacio;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Set;

/**
 * Created by usuario on 06/06/2016.
 */
@Entity
@Table(name = "reservaambnotificacio", schema = "public", catalog = "postgres")
@Check(constraints = "(horainici < horafi) AND horaInici <= '23:59:59' AND horaFi>= '00:00:00' AND  horaFi<='23:59:59' AND horaInici >='00:00:00'")
@IdClass(ReservaambnotificacioPK.class)

public class ReservaAmbNotificacio extends Reserva{

    public void reservaValida() throws Exception{
        boolean bool = esReservaAmbNotificacio();
        if(bool==false) throw new NoEsReservaAmbNotificacio();
        boolean bool2 = esReservaCaduca();
        if(bool2==false) throw new NoEsReservaAmbNotificacio();
    }

    private boolean esReservaCaduca(){
        //Falta comparar les hores i els dies!
        return true;
    }

    private boolean esReservaAmbNotificacio(){
        return true;
    }


}
