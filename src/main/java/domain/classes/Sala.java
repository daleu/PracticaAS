package domain.classes;

import domain.dataTypes.RecursDisponiblesPerData;
import org.hibernate.annotations.Check;

import javax.persistence.*;


@Entity
@Table(name = "sala", schema = "public", catalog = "postgres")
@Check(constraints = "aforament>0")
public class Sala extends Recurs{

    private Integer aforament;
    private String ubicacio;
    private String nomordinador;
    private String nomprojector;
    private Recurs recurs;
    private Ordinador ordinador;
    private Projector projector;

    public Sala(){

    }

    protected RecursDisponiblesPerData getRecursInfoEsp(RecursDisponiblesPerData r) {
        return null;
    }

    @Basic
    @Column(name = "aforament", nullable = false)
    public Integer getAforament() {
        return aforament;
    }

    public void setAforament(Integer aforament) {
        this.aforament = aforament;
    }

    @Basic
    @Column(name = "ubicacio", nullable = false, length = 255)
    public String getUbicacio() {
        return ubicacio;
    }

    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }

    @Basic
    @Column(name = "nomordinador", nullable = false, length = 255, unique=true)
    public String getNomordinador() {
        return nomordinador;
    }

    public void setNomordinador(String nomordinador) {
        this.nomordinador = nomordinador;
    }

    @Basic
    @Column(name = "nomprojector", nullable = false, length = 255, unique= true)
    public String getNomprojector() {
        return nomprojector;
    }

    public void setNomprojector(String nomprojector) {
        this.nomprojector = nomprojector;
    }

    @ManyToOne
    @JoinColumn(name = "nom", referencedColumnName = "nom", nullable = false,insertable = false, updatable = false)
    public Recurs getRecurs() {
        return recurs;
    }

    public void setRecurs(Recurs recurs) {
        this.recurs = recurs;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "nomordinador", referencedColumnName = "nom", nullable = true,insertable = false, updatable = false)
    public Ordinador getOrdinador() {
        return ordinador;
    }

    public void setOrdinador(Ordinador ordinador) {
        this.ordinador = ordinador;
    }

    @OneToOne
    @JoinColumn(name = "nomprojector", referencedColumnName = "nom", nullable = true,insertable = false, updatable = false)
    public Projector getProjector() {
        return projector;
    }

    public void setProjector(Projector projector) {
        this.projector = projector;
    }

    @Override
    protected Boolean recursNoAssignatASala() {
        return true;
    }


}
