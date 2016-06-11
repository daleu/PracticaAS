package domain.controllers;

import domain.classes.Reserva;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by crist_000 on 11/06/2016.
 */
public interface CtrlReserva {
    public Reserva getReserva(String nomRecurs, Integer horainici, Date data);
    public void insertarReserva(Reserva reserva);
    public ArrayList<Reserva> getAll();
}
