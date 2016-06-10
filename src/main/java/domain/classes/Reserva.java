package domain.classes;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by usuario on 10/06/2016.
 */
@Entity
@IdClass(ReservaPK.class)
public class Reserva {
    private Date data;
    private Time horainici;
    private Time horafi;
    private String comentaris;
    private String usuari;
    private String recurs;



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
    public Time getHorainici() {
        return horainici;
    }

    public void setHorainici(Time horainici) {
        this.horainici = horainici;
    }

    @Basic
    @Column(name = "horafi", nullable = true)
    public Time getHorafi() {
        return horafi;
    }

    public void setHorafi(Time horafi) {
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

    @Basic
    @Column(name = "usuari", nullable = false, length = 255)
    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
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

        Reserva reserva = (Reserva) o;

        if (data != null ? !data.equals(reserva.data) : reserva.data != null) return false;
        if (horainici != null ? !horainici.equals(reserva.horainici) : reserva.horainici != null) return false;
        if (horafi != null ? !horafi.equals(reserva.horafi) : reserva.horafi != null) return false;
        if (comentaris != null ? !comentaris.equals(reserva.comentaris) : reserva.comentaris != null) return false;
        if (usuari != null ? !usuari.equals(reserva.usuari) : reserva.usuari != null) return false;
        if (recurs != null ? !recurs.equals(reserva.recurs) : reserva.recurs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (horainici != null ? horainici.hashCode() : 0);
        result = 31 * result + (horafi != null ? horafi.hashCode() : 0);
        result = 31 * result + (comentaris != null ? comentaris.hashCode() : 0);
        result = 31 * result + (usuari != null ? usuari.hashCode() : 0);
        result = 31 * result + (recurs != null ? recurs.hashCode() : 0);
        return result;
    }
}
