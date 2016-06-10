package domain.classes;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by usuario on 10/06/2016.
 */
@Entity
public class Projector {
    private String nomrecurs;
    private String resolucio;

    @Id
    @Column(name = "nomrecurs", nullable = false, length = 255)
    public String getNomrecurs() {
        return nomrecurs;
    }

    public void setNomrecurs(String nomrecurs) {
        this.nomrecurs = nomrecurs;
    }

    @Basic
    @Column(name = "resolucio", nullable = false, length = 255)
    public String getResolucio() {
        return resolucio;
    }

    public void setResolucio(String resolucio) {
        this.resolucio = resolucio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Projector projector = (Projector) o;

        if (nomrecurs != null ? !nomrecurs.equals(projector.nomrecurs) : projector.nomrecurs != null) return false;
        if (resolucio != null ? !resolucio.equals(projector.resolucio) : projector.resolucio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nomrecurs != null ? nomrecurs.hashCode() : 0;
        result = 31 * result + (resolucio != null ? resolucio.hashCode() : 0);
        return result;
    }
}
