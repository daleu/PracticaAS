package domain.classes;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by usuario on 10/06/2016.
 */
@Entity
public class Sala {
    private String nomrecurs;
    private Integer aforament;
    private String ubicacio;
    private String projector;
    private String ordinador;

    @Id
    @Column(name = "nomrecurs", nullable = false, length = 255)
    public String getNomrecurs() {
        return nomrecurs;
    }

    public void setNomrecurs(String nomrecurs) {
        this.nomrecurs = nomrecurs;
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
    @Column(name = "projector", nullable = true, length = 255)
    public String getProjector() {
        return projector;
    }

    public void setProjector(String projector) {
        this.projector = projector;
    }

    @Basic
    @Column(name = "ordinador", nullable = true, length = 255)
    public String getOrdinador() {
        return ordinador;
    }

    public void setOrdinador(String ordinador) {
        this.ordinador = ordinador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sala sala = (Sala) o;

        if (nomrecurs != null ? !nomrecurs.equals(sala.nomrecurs) : sala.nomrecurs != null) return false;
        if (aforament != null ? !aforament.equals(sala.aforament) : sala.aforament != null) return false;
        if (ubicacio != null ? !ubicacio.equals(sala.ubicacio) : sala.ubicacio != null) return false;
        if (projector != null ? !projector.equals(sala.projector) : sala.projector != null) return false;
        if (ordinador != null ? !ordinador.equals(sala.ordinador) : sala.ordinador != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nomrecurs != null ? nomrecurs.hashCode() : 0;
        result = 31 * result + (aforament != null ? aforament.hashCode() : 0);
        result = 31 * result + (ubicacio != null ? ubicacio.hashCode() : 0);
        result = 31 * result + (projector != null ? projector.hashCode() : 0);
        result = 31 * result + (ordinador != null ? ordinador.hashCode() : 0);
        return result;
    }
}
