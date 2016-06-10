package domain.classes;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by usuario on 10/06/2016.
 */
public class EsnotificaPK implements Serializable {
    private Date data;
    private Time horainici;
    private String recurs;
    private String usuari;

    @Column(name = "data", nullable = false)
    @Id
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Column(name = "horainici", nullable = false)
    @Id
    public Time getHorainici() {
        return horainici;
    }

    public void setHorainici(Time horainici) {
        this.horainici = horainici;
    }

    @Column(name = "recurs", nullable = false, length = 255)
    @Id
    public String getRecurs() {
        return recurs;
    }

    public void setRecurs(String recurs) {
        this.recurs = recurs;
    }

    @Column(name = "usuari", nullable = false, length = 255)
    @Id
    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EsnotificaPK that = (EsnotificaPK) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (horainici != null ? !horainici.equals(that.horainici) : that.horainici != null) return false;
        if (recurs != null ? !recurs.equals(that.recurs) : that.recurs != null) return false;
        if (usuari != null ? !usuari.equals(that.usuari) : that.usuari != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (horainici != null ? horainici.hashCode() : 0);
        result = 31 * result + (recurs != null ? recurs.hashCode() : 0);
        result = 31 * result + (usuari != null ? usuari.hashCode() : 0);
        return result;
    }
}
