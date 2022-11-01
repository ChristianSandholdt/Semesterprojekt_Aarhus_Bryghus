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
    public static Produkt createProdukt(String name, String beskrivelse){
        Produkt produkt = new Produkt(name,beskrivelse);
        storage.storeProdukt(produkt);
        return produkt;
    }

    public static void deleteProdukt(Produkt produkt){
        storage.deleteProdukt(produkt);
    }

    public static void updateProdukt(Produkt produkt, String name, String beskrivelse){
        produkt.setNavn(name);
        produkt.setBeskrivelse(beskrivelse);
    }
}
