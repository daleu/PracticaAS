package domain.classes;

import domain.dataTypes.RecursDisponiblesPerData;

import javax.persistence.*;


@Entity
@Table(name = "projector", schema = "public", catalog = "postgres")
public class Projector extends Recurs{

    private String resolucio;
    private String nomsala;


    public Projector(){
    }


    public Projector(String nom, String resolucio, String nomsala) {
        super(nom);
        this.resolucio = resolucio;
        this.nomsala = nomsala;
        this.sala = null;
    }


    protected RecursDisponiblesPerData getRecursInfoEsp(RecursDisponiblesPerData r) {
        r.resolucio = this.resolucio;
        return r;
    }

    @Basic
    @Column(name = "resolucio", nullable = false, length = 255)
    public String getResolucio() {
        return resolucio;
    }

    public void setResolucio(String resolucio) {
        this.resolucio = resolucio;
    }

    protected Boolean recursNoAssignatASala() {
        Boolean b = new Boolean(true);
        if(nomsala != null){
            b = false;
        }
        return b;
    }


    private Sala sala;

    @OneToOne(mappedBy = "projector")
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Basic
    @Column(name = "sala", nullable = true, length = 255)
    public String getNomsala() {
        return nomsala;
    }

    public void setNomsala(String nomSala) {
        this.nomsala = nomSala;
    }

}