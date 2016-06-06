package domain.classes;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by usuario on 06/06/2016.
 */
@Entity
@Table(name = "reserva", schema = "public", catalog = "postgres")
@IdClass(ReservaPK.class)
public class Reserva {
    private Date data;
    private Date horainici;
    private Date horafi;
    private String comentaris;
    private String recurs;

    public Reserva() {
    }

    public Reserva(Date data, Date horainici, Date horafi, String comentaris, String recurs) {
        this.data = data;
        this.horainici = horainici;
        this.horafi = horafi;
        this.comentaris = comentaris;
        this.recurs = recurs;
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
    public Date getHorainici() {
        return horainici;
    }

    public void setHorainici(Date horainici) {
        this.horainici = horainici;
    }

    @Basic
    @Column(name = "horafi", nullable = true)
    public Date getHorafi() {
        return horafi;
    }

    public void setHorafi(Date horafi) {
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
    @Column(name = "recurs", nullable = false, length = 255)
    public String getRecurs() {
        return recurs;
    }

    public void setRecurs(String recurs) {
        this.recurs = recurs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reserva that = (Reserva) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (horainici != null ? !horainici.equals(that.horainici) : that.horainici != null) return false;
        if (horafi != null ? !horafi.equals(that.horafi) : that.horafi != null) return false;
        if (comentaris != null ? !comentaris.equals(that.comentaris) : that.comentaris != null) return false;
        if (recurs != null ? !recurs.equals(that.recurs) : that.recurs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (horainici != null ? horainici.hashCode() : 0);
        result = 31 * result + (horafi != null ? horafi.hashCode() : 0);
        result = 31 * result + (comentaris != null ? comentaris.hashCode() : 0);
        result = 31 * result + (recurs != null ? recurs.hashCode() : 0);
        return result;
    }
}
