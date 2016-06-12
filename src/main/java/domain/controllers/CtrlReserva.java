package domain.controllers;

import domain.classes.Reserva;
import domain.exceptions.NoEsReservaAmbNotificacio;

import java.util.ArrayList;
import java.sql.Date;


public interface CtrlReserva {
    public Reserva getReserva(String nomRecurs, Integer horainici, Date data) throws NoEsReservaAmbNotificacio;
    public void insertarReserva(Reserva reserva);
    public ArrayList<Reserva> getAll();
}
