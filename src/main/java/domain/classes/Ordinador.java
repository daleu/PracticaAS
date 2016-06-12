package domain.classes;

import domain.dataTypes.RecursDisponiblesPerData;

import javax.persistence.*;

/**
 * Created by aleue on 9/6/2016.
 */

@Entity
@Table(name = "ordinador", schema = "public", catalog = "postgres")
public class Ordinador extends Recurs {

    private String marca;
    private String model;
    private Recurs recurs;

    public Ordinador(){

    }

    @ManyToOne
    @JoinColumn(name = "nom", referencedColumnName = "nom", nullable = false,insertable = false, updatable = false)
    public Recurs getRecurs() {
        return recurs;
    }

    public void setRecurs(Recurs recurs) {
        this.recurs = recurs;
    }

    @Basic
    @Column(name = "marca", nullable = false, length = 255)
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Basic
    @Column(name = "model", nullable = false, length = 255)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    /*public RecursDisponiblesPerData getInfo(){
        RecursDisponiblesPerData r = new RecursDisponiblesPerData();
        r.nom = this.getNom();
        r.marca = this.marca;
        r.model = this.model;
        return r;
    }*/
}
