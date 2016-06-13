package presentation;

import domain.dataTypes.RecursDisponiblesPerData;
import domain.dataTypes.TupleUsers;

import java.util.List;

/**
 * Created by Usuario on 11/06/2016.
 */
public interface crearReservaVista {
    void init(crearReservaController c);
    void mostraIntroduccioData();
    void seleccionarRecurs(List<RecursDisponiblesPerData> aux);
    void assignarUsuaris(List<TupleUsers> aux2);

    void goMenuPrincipal();
}
