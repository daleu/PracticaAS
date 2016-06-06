package src.classes;

import javax.persistence.*;

/**
 * Created by usuario on 06/06/2016.
 */
@Entity
@Table(name = "usuari", schema = "public", catalog = "postgres")
public class Usuari {
    private String username;
    private String nom;
    private String email;

    public Usuari(){

    }

    public Usuari(String username, String nom, String email) {
        this.username = username;
        this.nom = nom;
        this.email = email;
    }

    @Id
    @Column(name = "username", nullable = false, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "nom", nullable = true, length = 255)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuari that = (Usuari) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
