package domain.classes;

import domain.dataTypes.TuplaEnviarDadesAReserva;
import domain.dataTypes.TupleUsers;
import domain.exceptions.NoEsReservaAmbNotificacio;
import domain.exceptions.ReservaATope;
import domain.exceptions.ReservaCaducada;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;


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


    public ReservaAmbNotificacio(){

    }

    public ReservaAmbNotificacio(Date data, Integer horainici, Integer horafi, String comentaris, String nomrecurs, String username) {
        super(data, horainici, horafi, comentaris, nomrecurs, username);
        this.usuaris = null;
    }



    @Override
    public boolean reservaValida() throws Exception{
        boolean bool = esReservaAmbNotificacio();
        if(bool==false) throw new NoEsReservaAmbNotificacio();
        boolean bool2 = esReservaCaduca();
        if(bool2==false) throw new ReservaCaducada();
        int usuarisnotificats = UsuarisANotificar();
        if(usuarisnotificats==10) throw new ReservaATope();
        return true;
    }

    public ReservaAmbNotificacio(Date data, Integer horainici, Integer horafi, String comentaris, Recurs r, Usuari u) {
        super(data,horainici,horafi,comentaris,r.getNom(),u.getUsername());
        super.associarRecurs(r);
        super.associarUsuari(u);
        this.usuaris.add(u);
    }

    private boolean esReservaCaduca(){
        Calendar today = Calendar.getInstance();
        Date todaySQL = new Date((today.getTime()).getTime());
        Integer horaactual =today.get(Calendar.HOUR_OF_DAY);
        if(todaySQL.after(data))return false;
        else if(todaySQL.equals(data) && horaactual>horainici) return false;
        else return true;
    }

    @Override
    public List<TupleUsers> usuarisAAssignar(Collection<Usuari> usuarisexistents) {
        List<TupleUsers> aux = new ArrayList<TupleUsers>();
        for(Usuari u : usuarisexistents){
            if(!usuaris.contains(u)){
                TupleUsers aux2 = new TupleUsers(u.getUsername(),u.getNom(),u.getEmail());
                aux.add(aux2);
            }
        }
        return aux;
    }

    private boolean esReservaAmbNotificacio(){
        return true;
    }

    private Collection<Usuari> usuaris;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.ALL}, fetch = FetchType.EAGER)
    public Collection<Usuari> getUsuaris() {
        return usuaris;
    }

    public void setUsuaris(Collection<Usuari> usuaris) {
        this.usuaris = usuaris;
    }

    public TuplaEnviarDadesAReserva afegirUsuaris(Collection<Usuari> usuarisAAfegir) throws Exception {

        if(usuaris.size() + usuarisAAfegir.size() > 10) throw new ReservaATope();

        //Afegeix nous usuaris
       usuaris.addAll(usuarisAAfegir);

        //Assigna l'altre navegavilitat
        ArrayList<ReservaAmbNotificacio> rr = new ArrayList<ReservaAmbNotificacio>();
        rr.add(this);
        for (Usuari u:
             usuarisAAfegir) {
            u.setReserves(rr);
        }

        //Agafa info per a enviar la info al servei
        TuplaEnviarDadesAReserva tupla = new TuplaEnviarDadesAReserva(super.getNomrecurs(),
                                                                        super.getData(),
                                                                        super.getHorainici(),
                                                                        super.getHorafi(),
                                                                        super.getUsername(),
                                                                        super.getComentaris(),
                                                                        null);
        return tupla;
    }

    public int UsuarisANotificar() {
        return usuaris.size();
    }
}
