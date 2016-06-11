package domain.classes;

import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by usuario on 06/06/2016.
 */
@Entity
@Table(name = "reservaambnotificacio", schema = "public", catalog = "postgres")
//@Check(constraints = "(horainici < horafi) AND horaInici <= '23:59:59' AND horaFi>= '00:00:00' AND  horaFi<='23:59:59' AND horaInici >='00:00:00'")
@Check(constraints = "(horainici < horafi) AND horaInici <= '23' AND horaFi>= '1' AND  horaFi<='24' AND horaInici >='0'")
@IdClass(ReservaambnotificacioPK.class)
public class ReservaAmbNotificacio {
    private Date data;
    private Integer horainici;
    private Integer horafi;
    private String comentaris;
    private String nomrecurs;
    private String username;
    private Recurs recurs;
    private Usuari usuari;

    public ReservaAmbNotificacio() {
    }

    public ReservaAmbNotificacio(Date data, Integer horainici, Integer horafi, String comentaris, String nomrecurs, String username) {
        this.data = data;
        this.horainici = horainici;
        this.horafi = horafi;
        this.comentaris = comentaris;
        this.nomrecurs = nomrecurs;
        this.username = username;
    }

    @Id
    @Column(name = "data", nullable = false)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Id
    @Column(name = "horainici", nullable = false)
    public Integer getHorainici() {
        return horainici;
    }

    public void setHorainici(Integer horainici) {
        this.horainici = horainici;
    }

    @Basic
    @Column(name = "horafi", nullable = true)
    public Integer getHorafi() {
        return horafi;
    }

    public void setHorafi(Integer horafi) {
        this.horafi = horafi;
    }

    @Basic
    @Column(name = "comentaris", nullable = true, length = 255)
    public String getComentaris() {
        return comentaris;
    }

    public void setComentaris(String comentaris) {
        this.comentaris = comentaris;
    }

    @Id
    @Column(name = "nomrecurs", nullable = false, length = 255)
    public String getnomrecurs() {
        return nomrecurs;
    }

    public void setnomrecurs(String nomrecurs) {
        this.nomrecurs = nomrecurs;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservaAmbNotificacio that = (ReservaAmbNotificacio) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (horainici != null ? !horainici.equals(that.horainici) : that.horainici != null) return false;
        if (horafi != null ? !horafi.equals(that.horafi) : that.horafi != null) return false;
        if (comentaris != null ? !comentaris.equals(that.comentaris) : that.comentaris != null) return false;
        if (nomrecurs != null ? !nomrecurs.equals(that.nomrecurs) : that.nomrecurs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (horainici != null ? horainici.hashCode() : 0);
        result = 31 * result + (horafi != null ? horafi.hashCode() : 0);
        result = 31 * result + (comentaris != null ? comentaris.hashCode() : 0);
        result = 31 * result + (nomrecurs != null ? nomrecurs.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "nomrecurs", referencedColumnName = "nom", nullable = false,insertable = false, updatable = false)
    public Recurs getRecurs() {
        return recurs;
    }

    public void setRecurs(Recurs recurs) {
        this.recurs = recurs;
    }

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = true,insertable = false, updatable = false)
    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }
}
