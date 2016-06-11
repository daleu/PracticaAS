package domain.controllers;

import domain.classes.Recurs;

import java.util.ArrayList;

/**
 * Created by crist_000 on 11/06/2016.
 */
public interface CtrlRecurs {
    public Recurs getLocal(String nomRecurs);
    public void insertarLocal(Recurs recurs);
    public ArrayList<Recurs> getAll();
}
