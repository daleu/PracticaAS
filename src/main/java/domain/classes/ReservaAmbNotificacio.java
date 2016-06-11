package domain.classes;

import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by usuario on 06/06/2016.
 */
@Entity
@Table(name = "reservaambnotificacio", schema = "public", catalog = "postgres")
@Check(constraints = "(horainici < horafi) AND horaInici <= '23:59:59' AND horaFi>= '00:00:00' AND  horaFi<='23:59:59' AND horaInici >='00:00:00'")
@IdClass(ReservaambnotificacioPK.class)

public class ReservaAmbNotificacio extends Reserva{


}
