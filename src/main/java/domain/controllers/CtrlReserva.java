package domain.controllers;

import domain.classes.Reserva;
import domain.exceptions.NoEsReservaAmbNotificacio;

import java.sql.Date;
import java.util.Collection;


public interface CtrlReserva {
    public Reserva getReserva(String nomRecurs, Integer horainici, Date data) throws NoEsReservaAmbNotificacio;
    public void insertarReserva(Reserva reserva);
    public Collection<Reserva> getAll();
}
