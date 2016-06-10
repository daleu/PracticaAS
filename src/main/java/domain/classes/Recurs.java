package domain.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by usuario on 10/06/2016.
 */
@Entity
public class Recurs {
    private String nom;

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

        Recurs recurs = (Recurs) o;

        if (nom != null ? !nom.equals(recurs.nom) : recurs.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nom != null ? nom.hashCode() : 0;
    }
}
