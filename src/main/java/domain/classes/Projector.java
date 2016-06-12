package domain.classes;

import domain.dataTypes.RecursDisponiblesPerData;

import javax.persistence.*;

/**
 * Created by aleue on 9/6/2016.
 */

@Entity
@Table(name = "projector", schema = "public", catalog = "postgres")
public class Projector extends Recurs{

    private String resolucio;
    private Recurs recurs;

    private Sala sala;

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Projector(){


    }



    @Basic
    @Column(name = "resolucio", nullable = false, length = 255)
    public String getResolucio() {
        return resolucio;
    }

    public void setResolucio(String resolucio) {
        this.resolucio = resolucio;
    }

    @ManyToOne
    @JoinColumn(name = "nom", referencedColumnName = "nom", nullable = false,insertable = false, updatable = false)
    public Recurs getRecurs() {
        return recurs;
    }


    @OneToOne
    @JoinColumn(name = "nom", referencedColumnName = "nomprojector", nullable = true,insertable = false, updatable = false)
    public Sala getSala() {
        return sala;
    }


    public void setRecurs(Recurs recurs) {
        this.recurs = recurs;
    }


    protected boolean recursAssignatASala() {
        return false;
    }

}