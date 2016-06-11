package domain.factories;

import domain.casesControllers.AssignarUsuarisANotificarUseCaseController;
import domain.casesControllers.ConsultarRecursosDisponiblesPerDataUseCaseController;
import domain.casesControllers.CrearReservaAmbNotificacioUseCaseController;
import domain.controllers.CtrlUsuari;

/**
 * Created by usuario on 10/06/2016.
 */
public class FactoriaUseCase {

    private static FactoriaUseCase ourInstance = new FactoriaUseCase();

    private AssignarUsuarisANotificarUseCaseController assignarUsuarisANotificarAUnaReserva;
    private ConsultarRecursosDisponiblesPerDataUseCaseController consultarRecursosDisponiblesPerData;
    private CrearReservaAmbNotificacioUseCaseController crearReservaAmbNotificacio;

    public static FactoriaUseCase getInstance() {
        return ourInstance;
    }

    public CrearReservaAmbNotificacioUseCaseController getCrearReservaAmbNotificacio(){
        if (crearReservaAmbNotificacio == null) {
            crearReservaAmbNotificacio = new CrearReservaAmbNotificacioUseCaseController();
        }
        return crearReservaAmbNotificacio;
    }

    //TODO: Fer les demes getInstances

}
