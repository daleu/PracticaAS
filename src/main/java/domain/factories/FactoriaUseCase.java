package domain.factories;

import domain.cases.AssignarUsuarisANotificarAUnaReserva;
import domain.cases.ConsultarRecursosDisponiblesPerData;
import domain.cases.CrearReservaAmbNotificacio;
import domain.controllers.CtrlUsuari;

/**
 * Created by usuario on 10/06/2016.
 */
public class FactoriaUseCase {

    private static FactoriaUseCase ourInstance = new FactoriaUseCase();

    private AssignarUsuarisANotificarAUnaReserva assignarUsuarisANotificarAUnaReserva;
    private ConsultarRecursosDisponiblesPerData consultarRecursosDisponiblesPerData;
    private CrearReservaAmbNotificacio crearReservaAmbNotificacio;

    public static FactoriaUseCase getInstance() {
        return ourInstance;
    }

    public CrearReservaAmbNotificacio getCrearReservaAmbNotificacio(){
        if (crearReservaAmbNotificacio == null) {
            crearReservaAmbNotificacio = new CrearReservaAmbNotificacio();
        }
        return crearReservaAmbNotificacio;
    }

    //TODO: Fer les demes getInstances

}
