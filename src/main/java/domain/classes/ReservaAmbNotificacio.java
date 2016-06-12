package domain.classes;

import domain.dataTypes.TuplaEnviarDadesAReserva;
import domain.dataTypes.TupleUsers;
import domain.exceptions.NoEsReservaAmbNotificacio;
import domain.exceptions.ReservaATope;
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
//    public Set<Usuari> usuarisANotificar;

    public ReservaAmbNotificacio(){

    }

    public ReservaAmbNotificacio(Date data, Integer horainici, Integer horafi, String comentaris, String nomrecurs, String username, Collection<Usuari> usuaris) {
        super(data, horainici, horafi, comentaris, nomrecurs, username);

        this.usuaris = usuaris;
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

    public TuplaEnviarDadesAReserva afegirUsuaris(Collection<Usuari> usuarisAAfegir) throws Exception {

        if(usuaris.size() + usuarisAAfegir.size() > 10) throw new ReservaATope();
        usuaris.addAll(usuarisAAfegir);

        TuplaEnviarDadesAReserva tupla = new TuplaEnviarDadesAReserva(super.getNomrecurs(),
                                                                        super.getData(),
                                                                        super.getHorainici(),
                                                                        super.getHorafi(),
                                                                        super.getUsername(),
                                                                        super.getComentaris(),
                                                                        null);
        return tupla;
    }

}
