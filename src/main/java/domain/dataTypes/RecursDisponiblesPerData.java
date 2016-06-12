package domain.dataTypes;

import domain.classes.Recurs;

/**
 * Created by aleue on 11/6/2016.
 */
public class RecursDisponiblesPerData {

    public String nom;
    public String marca;
    public String model;
    public String resolucio;
    public Integer aforament;
    public String ubicacio;
    public String marcaOrdSala;
    public String modelOrdSala;
    public String resolucióProjSala;

    public RecursDisponiblesPerData(String nom, String marca, String model, String resolució, Integer aforament, String ubicació, String marcaOrdSala, String modelOrdSala, String resolucióProjSala){
        this.nom = nom;
        this.marca = marca;
        this.model = model;
        this.resolucio = resolució;
        this.aforament = aforament;
        this.ubicacio = ubicació;
        this.marcaOrdSala = marcaOrdSala;
        this.modelOrdSala = modelOrdSala;
        this.resolucióProjSala = resolucióProjSala;
    }
    public RecursDisponiblesPerData() {
        this.nom = null;
        this.marca = null;
        this.model = null;
        this.resolucio = null;
        this.aforament = null;
        this.ubicacio = null;
        this.marcaOrdSala = null;
        this.modelOrdSala = null;
        this.resolucióProjSala = null;
    }

}
