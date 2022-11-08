package controller;

import model.*;

import java.time.LocalDate;

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
    public static Ordre createOrdre(boolean betalt, int ordreID,LocalDate localDate){
        Ordre ordre = new Ordre(betalt,ordreID,localDate);
        storage.storeOrdre(ordre);
        return ordre;
    }
    /**
     * Sletter en ordre
     * Pre: Ordren er skabt
     */
    public static void deleteOrdre(Ordre ordre){
        ordre.removeOrdre(ordre);
        storage.deleteOrdre(ordre);
    }
    /**
     * Skabet en ordrelinje
     */
    public static Ordrelinje createOrdrelinje(int antal, Produkt produkt, Pris pris){
        Ordrelinje ordrelinje = new Ordrelinje(antal,produkt,pris);
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
    public static Produkt createProdukt(String name, Produktgruppe produktgruppe){
        Produkt produkt = new Produkt(name, produktgruppe);
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
    public static void updateProdukt(Produkt produkt, String name, Produktgruppe produktgruppe){
        produkt.setNavn(name);
        if (produkt.getProduktgruppe() != null){
            produkt.fjernProduktgruppe(produkt.getProduktgruppe());
        }
        produkt.setProduktgruppe(produktgruppe);

    }

    //---------------------------------------------------------------------------

    /**
     * Opretter en produktgruppe
     * */
    public static Produktgruppe createProduktGruppe(String name, boolean udlejning){
        Produktgruppe produktgruppe = new Produktgruppe(name,udlejning);
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

    //---------------------------------------------------------------------------

    public static Rundvisning createRundvisning(String navn, String email, int tlfNummer, double pris, int antalPersoner,
                                                LocalDate dato, String startTid, String slutTid){
        Rundvisning rundvisning = new Rundvisning(navn, email, tlfNummer, pris, antalPersoner,
                dato, startTid, slutTid);
        storage.storeRundvisning(rundvisning);
        return rundvisning;
    }

    public static void deleteRundvisning(Rundvisning rundvisning) {
        storage.deleteRundvisning(rundvisning);
    }

    public static void updateRundvisning(String navn, String email, int tlfNummer, double pris, int antalPersoner,
                                         LocalDate dato, String startTid, String slutTid){
        Rundvisning rundvisning = new Rundvisning(navn, email, tlfNummer, pris, antalPersoner,
                dato, startTid, slutTid);
        for (Rundvisning r : Controller.getStorage().getRundvisning()){
            if (r.getDato() == rundvisning.getDato()){
                Controller.getStorage().deleteRundvisning(r);
            }
        }
        storage.storeRundvisning(rundvisning);
    }
    //---------------------------------------------------------------------------

    /**
     * Skaber en ny prisliste og gemmer den i storage
     */
    public static Prisliste createPrisliste(String navn){
        Prisliste prisliste = new Prisliste(navn);
        storage.storePrisliste(prisliste);
        return prisliste;
    }

    /**
     * Sletter en prisliste
     * Pre: Prislisten er skabt
     */
    public static void deletePrisliste(Prisliste prisliste){
        storage.deletePrisliste(prisliste);
    }

    /**
     * Opdaterer en prisliste
     * Pre: Prislisten er skabt
     */
    public static void updatePrisliste(Prisliste prisliste, String navn){
        prisliste.setNavn(navn);
    }

    public static void createPris(Produkt produkt, Prisliste prisliste,double pris,int prisIKlip){
        Pris p = new Pris(pris);
        prisliste.addPris(p);
        produkt.addPris(p);
        p.setProdukt(produkt);
        produkt.getProduktgruppe().addPrisliste(prisliste);
        prisliste.addProduktgruppe(produkt.getProduktgruppe());
        storage.storePris(p);
    }

    public static Pris getPris(Prisliste pl, Produkt pr){
        Pris pris = null;
        for (Pris p : storage.getPris()){
            if (pr.getPriser().contains(p) && pl.getPriser().contains(p)){
                pris = p;
            }
        }
        return pris;
    }
    public static String totalPris(Ordre ordre){
        double pris = 0;
        for(Ordrelinje o : storage.getOrdrelinjer()){
            pris = pris + o.getPrisOrdreLinje().getPris() * o.getAntal();
        }
        return pris + "";
    }
}
