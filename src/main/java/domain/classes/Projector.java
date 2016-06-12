package domain.classes;

import domain.dataTypes.RecursDisponiblesPerData;

import javax.persistence.*;

/**
 * Created by aleue on 9/6/2016.
 */

@Entity
@Table(name = "projector", schema = "public", catalog = "postgres")
public class Projector {

    private String nom;
    private String resolucio;
    private Recurs recurs;

    public Projector(){

    }

    @Id
    @Column(name = "nom", nullable = false, length = 255)
    public String getNom() {
        return nom;
    }

    public void setNom(String nomP) {
        this.nom = nomP;
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

    public void setRecurs(Recurs recurs) {
        this.recurs = recurs;
    }

    /*public RecursDisponiblesPerData getInfo(){
        RecursDisponiblesPerData r = new RecursDisponiblesPerData();
        r.nom = this.getNom();
        r.resolucio = this.resolucio;
        return r;
    }*/
}
