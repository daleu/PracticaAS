package domain.controllers;

import domain.classes.Recurs;

import java.util.ArrayList;
import java.util.Collection;


public interface CtrlRecurs {
    public Recurs getRecurs(String nomRecurs);
    public Collection<Recurs> getAll();
}
