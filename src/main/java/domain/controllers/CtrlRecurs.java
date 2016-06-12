package domain.controllers;

import domain.classes.Recurs;

import java.util.ArrayList;


public interface CtrlRecurs {
    public Recurs getRecurs(String nomRecurs);
    public void insertarRecurs(Recurs recurs);
    public ArrayList<Recurs> getAll();
}
