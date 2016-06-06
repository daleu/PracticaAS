package src.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by usuario on 06/06/2016.
 */
@Entity
@Table(name = "recurs", schema = "public", catalog = "postgres")
public class Recurs {
    private String nom;

    public Recurs() {
    }
    public Recurs(String nom) {
        this.nom = nom;
    }

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

        Recurs that = (Recurs) o;

        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nom != null ? nom.hashCode() : 0;
    }
}
