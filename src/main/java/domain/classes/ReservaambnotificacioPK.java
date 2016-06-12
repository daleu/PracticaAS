package domain.classes;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class ReservaambnotificacioPK implements Serializable {

    private Date data;
    private Integer horainici;
    private String nomrecurs;

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
    public Integer getHorainici() {
        return horainici;
    }

    public void setHorainici(Integer horainici) {
        this.horainici = horainici;
    }

    @Column(name = "nomrecurs", nullable = false, length = 255)
    @Id
    public String getnomrecurs() {
        return nomrecurs;
    }

    public void setnomrecurs(String nomrecurs) {
        this.nomrecurs = nomrecurs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservaambnotificacioPK that = (ReservaambnotificacioPK) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (horainici != null ? !horainici.equals(that.horainici) : that.horainici != null) return false;
        if (nomrecurs != null ? !nomrecurs.equals(that.nomrecurs) : that.nomrecurs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (horainici != null ? horainici.hashCode() : 0);
        result = 31 * result + (nomrecurs != null ? nomrecurs.hashCode() : 0);
        return result;
    }
}
