package domain.classes;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by aleue on 9/6/2016.
 */
@Entity
@Table(name = "esnotifica", schema = "public", catalog = "postgres")
@IdClass(EsNotificaPK.class)
public class EsNotifica {

    private Date data;
    private Date horainici;
    private String nomrecurs;
    private String username;
    private ReservaAmbNotificacio reserva;
    private Usuari usuari;

    public EsNotifica(){

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

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = true,insertable = false, updatable = false)
    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "data", referencedColumnName = "data", nullable = false,insertable = false, updatable = false), @JoinColumn(name = "horainici", referencedColumnName = "horainici", nullable = false,insertable = false, updatable = false), @JoinColumn(name = "nomrecurs", referencedColumnName = "nomrecurs", nullable = false,insertable = false, updatable = false)})
    public ReservaAmbNotificacio getReserva() {
        return reserva;
    }

    public void setReserva(ReservaAmbNotificacio reserva) {
        this.reserva = reserva;
    }
}
