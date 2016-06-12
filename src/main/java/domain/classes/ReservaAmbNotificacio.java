package domain.classes;

import domain.dataTypes.TuplaEnviarDadesAReserva;
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


    public ReservaAmbNotificacio(){

    }



    @Override
    public void reservaValida() throws Exception{
        boolean bool = esReservaAmbNotificacio();
        if(bool==false) throw new NoEsReservaAmbNotificacio();
        boolean bool2 = esReservaCaduca();
        if(bool2==false) throw new NoEsReservaAmbNotificacio();
    }

    public ReservaAmbNotificacio(Date data, Integer horainici, Integer horafi, String comentaris, Recurs r, Usuari u) {
        super(data,horainici,horafi,comentaris,r.getNom(),u.getUsername());

        super.associarRecurs(r);
        super.associarUsuari(u);
        this.usuaris = null;
    }

    private boolean esReservaCaduca(){
        //Falta comparar les hores i els dies!
        return true;
    }

    private boolean esReservaAmbNotificacio(){
        return true;
    }

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

        //Afegeix nous usuaris
        usuaris.addAll(usuarisAAfegir);

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

    public void assignarUsuaris(List<String> usuariList) {

        //CREAR INSTANCIA DE ESNOTIFICA PER A CADA USUARILIST
    }

    public void associarUsuaris(Collection<Usuari> usuarisAAssignar) {

        this.usuaris = usuarisAAssignar;
    }
}
