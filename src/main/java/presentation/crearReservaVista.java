package presentation;

import domain.dataTypes.RecursDisponiblesPerData;

import java.util.List;


public interface crearReservaVista {
    void init(crearReservaController c);
    void mostraIntroduccioData();
    void seleccionarRecurs(List<RecursDisponiblesPerData> aux);
    void assignacioCorrecte(crearReservaController crearReservaController);
}
