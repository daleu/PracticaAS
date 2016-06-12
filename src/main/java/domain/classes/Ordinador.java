package domain.classes;

import domain.dataTypes.RecursDisponiblesPerData;

import javax.persistence.*;


@Entity
@Table(name = "ordinador", schema = "public", catalog = "postgres")
public class Ordinador extends Recurs {

    private String marca;
    private String model;
    private String nomsala;

    public Ordinador(){
    }

    protected RecursDisponiblesPerData getRecursInfoEsp(RecursDisponiblesPerData r) {
        r.marca = this.marca;
        r.model = this.model;
        return r;
    }

    protected Boolean recursNoAssignatASala() {
        Boolean b = new Boolean(true);
        if(nomsala != null){
            b = false;
        }
        return b;
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

    @Basic
    @Column(name = "sala", nullable = true, length = 255)
    public String getNomsala() {
        return nomsala;
    }

    public void setNomsala(String nomSala) {
        this.nomsala = nomSala;
    }

    private Sala sala;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ordinador")
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
