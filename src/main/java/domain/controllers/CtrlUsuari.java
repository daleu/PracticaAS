package domain.controllers;

import domain.classes.Usuari;

import java.util.Collection;


public interface CtrlUsuari {
    public Collection<Usuari> getall();
    public Usuari getUsuari(String username);
}
