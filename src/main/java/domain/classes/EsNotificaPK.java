package domain.classes;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by aleue on 9/6/2016.
 */
public class EsNotificaPK implements Serializable {

    private Date data;
    private Time horainici;
    private String nomrecurs;
    private String username;

    public EsNotificaPK(){

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
    public Time getHorainici() {
        return horainici;
    }

    public void setHorainici(Time horainici) {
        this.horainici = horainici;
    }

    @Id
    @Column(name = "nomrecurs", nullable = false, length = 255)
    public String getNomrecurs() {
        return nomrecurs;
    }

    public void setNomrecurs(String nomrecurs) {
        this.nomrecurs = nomrecurs;
    }

    @Id
    @Column(name = "username", nullable = false, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
