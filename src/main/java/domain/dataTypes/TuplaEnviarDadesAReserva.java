package domain.dataTypes;


import java.util.List;

public class TuplaEnviarDadesAReserva {

    private String nomR;
    private String data;
    private String horaIni;
    private Integer horaFi;
    private String username;
    private String comentari;
    private List<String> emailList;

    public TuplaEnviarDadesAReserva(String nomR, String data, String horaIni,
                                    Integer horaFi, String username, String comentari, List<String> emailList) {
        this.nomR = nomR;
        this.data = data;
        this.horaIni = horaIni;
        this.horaFi = horaFi;
        this.username = username;
        this.comentari = comentari;
        this.emailList = emailList;
    }

}
