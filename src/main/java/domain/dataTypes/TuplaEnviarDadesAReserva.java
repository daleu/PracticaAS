package domain.dataTypes;



import java.sql.Date;
import java.util.List;

public class TuplaEnviarDadesAReserva {

    private String nomR;
    private Date data;
    private Integer horaIni;
    private Integer horaFi;
    private String username;
    private String comentari;
    private List<String> emailList;

    public TuplaEnviarDadesAReserva(String nomR, java.sql.Date data, Integer horaIni,
                                    Integer horaFi, String username, String comentari, List<String> emailList) {
        this.nomR = nomR;
        this.data = data;
        this.horaIni = horaIni;
        this.horaFi = horaFi;
        this.username = username;
        this.comentari = comentari;
        this.emailList = emailList;
    }

    public void setEmails(List<String> emails) {
        this.emailList = emails;
    }
}
