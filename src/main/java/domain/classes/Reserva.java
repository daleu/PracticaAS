package domain.classes;

import domain.dataTypes.TuplaEnviarDadesAReserva;
import domain.dataTypes.TupleUsers;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.List;

/**
 * Created by usuario on 06/06/2016.
 */
@Entity
@Table(name = "reserva", schema = "public", catalog = "postgres")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Check(constraints = "(horainici < horafi) AND horainici <= '23' AND horafi>= '1' AND  horafi<='24' AND horainici >='0'")
@IdClass(ReservaPK.class)
public class Reserva {

    public static final String TAULA = "Reserva";
    protected Date data;
    protected Integer horainici;
    protected Integer horafi;
    protected String comentaris;
    private String nomrecurs;
    private String username;
    private Recurs recurs;
    private Usuari usuari;

    public Reserva() {
    }

    public Reserva(Date data, Integer horainici, Integer horafi, String comentaris, String nomrecurs, String username) {
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
    public String getNomrecurs() {
        return nomrecurs;
    }

    public void setNomrecurs(String nomrecurs) {
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

        Reserva that = (Reserva) o;

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

    public void reservaValida() throws Exception{

    }
    public Boolean reservaFeta(Date d, Integer hi, Integer hf){
        Boolean b = false;
        if(d == data && ((hi <= horainici && hf > horainici)|| (hi <horafi && hf > horafi)||(hi>=horainici && hf <= horafi))){
            b = true;
        }
        return b;
    }

    public void associarRecurs(Recurs r) {
        this.recurs = r;
    }

    public void associarUsuari(Usuari u) {
        this.usuari = u;
    }
    public List<TupleUsers> usuarisAAssignar(Collection<Usuari> usuaris) {
        return null;
    }
}
