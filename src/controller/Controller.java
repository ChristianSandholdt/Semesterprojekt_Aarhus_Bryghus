package controller;

import model.Produkt;
import model.Produktgruppe;

public abstract class Controller {

    private static Storage storage;

    public static Storage getStorage(){
        return storage;
    }
    public static void setStorage(Storage storage) {
        Controller.storage = storage;
    }

    //------------------------------------------------------------------------

    /**
     * Skaber et nyt objekt
     */
    public static Produkt createProdukt(String name, String beskrivelse, Produktgruppe produktgruppe){
        Produkt produkt = new Produkt(name,beskrivelse, produktgruppe);
        storage.storeProdukt(produkt);
        return produkt;
    }

    /**
     * Sletter et produkt
     * Pre: Produktet er skabt
     */
    public static void deleteProdukt(Produkt produkt, Produktgruppe produktgruppe){
        produktgruppe.fjernProdukt(produkt);
        storage.deleteProdukt(produkt);
    }

    /**
     * Opdaterer et produkt
     * Pre: Produktet er skabt
     */
    public static void updateProdukt(Produkt produkt, String name, String beskrivelse, Produktgruppe produktgruppe){
        produkt.setNavn(name);
        produkt.setBeskrivelse(beskrivelse);
        produkt.setProduktgruppe(produktgruppe);
    }

    //---------------------------------------------------------------------------

    /**
     * Opretter en produktgruppe
     * */
    public static Produktgruppe createProduktGruppe(String name, String type){
        Produktgruppe produktgruppe = new Produktgruppe(name,type);
        storage.storeProduktgruppe(produktgruppe);
        return produktgruppe;
    }

    /**
     * Sletter en produktgruppe
     * Pre: Produktgruppen er skabt
     */
    public static void deleteProduktGruppe(Produktgruppe produktgruppe){
        storage.deleteProduktgruppe(produktgruppe);
    }



}
