package domain.classes;

import domain.dataTypes.RecursDisponiblesPerData;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by usuario on 06/06/2016.
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "recurs", schema = "public", catalog = "postgres")
public abstract class Recurs {
    public static final String TAULA = "Recurs";
    private String nom;

    public Recurs() {
    }
    public Recurs(String nom) {
        this.nom = nom;
    }

    @Id
    @Column(name = "nom", nullable = false, length = 255)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recurs that = (Recurs) o;

        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nom != null ? nom.hashCode() : 0;
    }


    protected abstract Boolean recursNoAssignatASala();


    private Collection<Reserva> reserves;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recurs")
    @Fetch(value = FetchMode.SUBSELECT)
    public Collection<Reserva> getReserves() {
        return reserves;
    }

    public void setReserves(Collection<Reserva> reserves) {
        this.reserves = reserves;
    }

    public RecursDisponiblesPerData returnInfo(){
        RecursDisponiblesPerData tuple = new RecursDisponiblesPerData();
        tuple.nom = this.nom;
        tuple = getRecursInfoEsp(tuple);
        return tuple;
    }

    protected abstract RecursDisponiblesPerData getRecursInfoEsp(RecursDisponiblesPerData r);

    public Boolean getDisponibilitat(Date d, Integer hi, Integer hf) {
        Boolean b = recursNoAssignatASala();
        for (Reserva r: reserves) {
            if(b) {
                Boolean b2 = r.reservaFeta(d,hi,hf);
                if(b2){
                    b = false;
                }
            }
        }
        return b;
    }
}
