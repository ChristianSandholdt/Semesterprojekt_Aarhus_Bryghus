package controller;

import model.Ordre;
import model.Ordrelinje;
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
     * Skaber en ordre
     */
    public static Ordre createOrdre(boolean betalt, int ordreID){
        Ordre ordre = new Ordre(betalt,ordreID);
        storage.storeOrdre(ordre);
        return ordre;
    }
    /**
     *Sletter et produkt
     * Pre: Ordren er skabt
     */
    public static void deleteOrdre(Ordre ordre){
        ordre.removeOrdre(ordre);
        storage.deleteOrdre(ordre);
    }
    /**
     * Skabet en ordrelinje
     */
    public static Ordrelinje createOrdrelinje(int antal, Produkt produkt){
        Ordrelinje ordrelinje = new Ordrelinje(antal,produkt);
        storage.storeOrdrelinje(ordrelinje);
        return ordrelinje;
    }
    /**
     * Sletter en ordrelinje
     * Pre: Ordrelinjen er skabt
     */
    public static void deleteOrdrelinje(Ordrelinje ordrelinje, Ordre ordre){
        ordre.removeOrdrelinje(ordrelinje);
        storage.deleteOrdreLinje(ordrelinje);
    }

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
        if (produkt.getProduktgruppe() != null){
            produkt.fjernProduktgruppe(produkt.getProduktgruppe());
        }
        produkt.setProduktgruppe(produktgruppe);

    }

    //---------------------------------------------------------------------------

    /**
     * Opretter en produktgruppe
     * */
    public static Produktgruppe createProduktGruppe(String name, String type, boolean udlejning){
        Produktgruppe produktgruppe = new Produktgruppe(name,type,udlejning);
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
