package domain.classes;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by usuario on 10/06/2016.
 */
@Entity
public class Ordinador {
    private String nomrecurs;
    private String marca;
    private String model;

    @Id
    @Column(name = "nomrecurs", nullable = false, length = 255)
    public String getNomrecurs() {
        return nomrecurs;
    }

    public void setNomrecurs(String nomrecurs) {
        this.nomrecurs = nomrecurs;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ordinador ordinador = (Ordinador) o;

        if (nomrecurs != null ? !nomrecurs.equals(ordinador.nomrecurs) : ordinador.nomrecurs != null) return false;
        if (marca != null ? !marca.equals(ordinador.marca) : ordinador.marca != null) return false;
        if (model != null ? !model.equals(ordinador.model) : ordinador.model != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nomrecurs != null ? nomrecurs.hashCode() : 0;
        result = 31 * result + (marca != null ? marca.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }
}
