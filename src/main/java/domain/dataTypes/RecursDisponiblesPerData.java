package domain.dataTypes;

import domain.classes.Recurs;


public class RecursDisponiblesPerData {

    String nom;
    String marca;
    String model;
    String resolució;
    Integer aforament;
    String ubicació;
    String marcaOrdSala;
    String modelOrdSala;
    String resolucióProjSala;

    public RecursDisponiblesPerData(String nom, String marca, String model, String resolució, Integer aforament, String ubicació, String marcaOrdSala, String modelOrdSala, String resolucióProjSala){
        this.nom = nom;
        this.marca = marca;
        this.model = model;
        this.resolució = resolució;
        this.aforament = aforament;
        this.ubicació = ubicació;
        this.marcaOrdSala = marcaOrdSala;
        this.modelOrdSala = modelOrdSala;
        this.resolucióProjSala = resolucióProjSala;
    }

}
