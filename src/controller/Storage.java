package controller;

import model.*;

import java.util.List;

public interface Storage {

    //-------------------------------------------------------------------------------------------------
    List<Ordre> getOrdre();
    void storeOrdre(Ordre ordre);
    void deleteOrdre(Ordre ordre);
    //--------------------------------------------------------------------------------------------------
    List<Ordrelinje> getOrdrelinjer();
    void storeOrdrelinje(Ordrelinje ordrelinje);
    void deleteOrdreLinje(Ordrelinje ordrelinje);
    //--------------------------------------------------------------------------------------------------
    List<Produktgruppe> getProduktgruppe();
    void storeProduktgruppe(Produktgruppe produktgruppe);
    void deleteProduktgruppe(Produktgruppe produktgruppe);
    //--------------------------------------------------------------------------------------------------
    List<Produkt> getProdukt();
    void storeProdukt(Produkt produkt);
    void deleteProdukt(Produkt produkt);
    //--------------------------------------------------------------------------------------------------
    List<Rundvisning> getRundvisning();
    void storeRundvisning(Rundvisning rundvisning);
    void deleteRundvisning(Rundvisning rundvisning);
    //--------------------------------------------------------------------------------------------------
    List<Prisliste> getPrisliste();
    void storePrisliste(Prisliste prisliste);
    void deletePrisliste(Prisliste prisliste);
}
