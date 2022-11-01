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
     * Create a new produkt
     */
    public static Produkt createProdukt(String name, String beskrivelse, Produktgruppe produktgruppe){
        Produkt produkt = new Produkt(name,beskrivelse, produktgruppe);
        storage.storeProdukt(produkt);
        produktgruppe.tilfoejProdukt(produkt);
        return produkt;

    }

    public static void deleteProdukt(Produkt produkt, Produktgruppe produktgruppe){
        produktgruppe.fjernProdukt(produkt);
        storage.deleteProdukt(produkt);
    }

    public static void updateProdukt(Produkt produkt, String name, String beskrivelse, Produktgruppe produktgruppe){
        produkt.setNavn(name);
        produkt.setBeskrivelse(name);
        produkt.setProduktgruppe(produktgruppe);
    }

    //---------------------------------------------------------------------------

    public static Produktgruppe createProduktGruppe(String name, String type){
        Produktgruppe produktgruppe = new Produktgruppe(name,type);
        storage.storeProduktgruppe(produktgruppe);
        return produktgruppe;
    }

    public static void deleteProduktGruppe(Produktgruppe produktgruppe){
        storage.deleteProduktgruppe(produktgruppe);
    }



}
