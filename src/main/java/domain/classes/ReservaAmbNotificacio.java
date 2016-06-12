package domain.classes;

import domain.exceptions.NoEsReservaAmbNotificacio;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by usuario on 06/06/2016.
 */
@Entity
@Table(name = "reservaambnotificacio", schema = "public", catalog = "postgres")
@Check(constraints = "(horainici < horafi) AND horainici <= '23' AND horafi>= '1' AND  horafi<='24' AND horainici >='0'")
@IdClass(ReservaambnotificacioPK.class)
public class ReservaAmbNotificacio extends Reserva{
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable (name = "reserva_usuari",
//            joinColumns ={@JoinColumn (name = "nomrecurs"),
//                    @JoinColumn (name = "horainici"),
//                    @JoinColumn (name = "data")},
//            inverseJoinColumns = {@JoinColumn(name = "username")})
//    public Set<Usuari> usuarisANotificar;

    public ReservaAmbNotificacio(){

    }

    @Override
    public void reservaValida() throws Exception{
        boolean bool = esReservaAmbNotificacio();
        if(bool==false) throw new NoEsReservaAmbNotificacio();
        boolean bool2 = esReservaCaduca();
        if(bool2==false) throw new NoEsReservaAmbNotificacio();
    }

    public ReservaAmbNotificacio(Date data, Integer horainici, Integer horafi, String comentaris, String nomrecurs, String username, Usuari user) {
        super(data,horainici,horafi,comentaris,nomrecurs,username);
        usuaris = new ArrayList<Usuari>();
        usuaris.add(user);
    }

    private boolean esReservaCaduca(){
        //Falta comparar les hores i els dies!
        return true;
    }

    private boolean esReservaAmbNotificacio(){
        return true;
    }
//
//    public Set<Usuari> getUsarisANotificar() {
//        return usarisANotificar;
//    }
//
//    public void setUsarisANotificar(Set<Usuari> usarisANotificar) {
//        this.usarisANotificar = usarisANotificar;
//    }
    private Collection<Usuari> usuaris;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    public Collection<Usuari> getUsuaris() {
        return usuaris;
    }

    public void setUsuaris(Collection<Usuari> usuaris) {
        this.usuaris = usuaris;
    }
}
