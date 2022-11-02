package controller;

import model.Ordre;
import model.Ordrelinje;
import model.Produkt;
import model.Produktgruppe;

import java.util.List;

public interface Storage {


    //-------------------------------------------------------------------------------------------------
    List<Ordre> getOrdre();

    void storeOrdre(Ordre ordre);

    void deleteOrdre(Ordre ordre);

    List<Ordrelinje> getOrdrelinjer();

    void storeOrdrelinje(Ordrelinje ordrelinje);

    void deleteOrdreLinje(Ordrelinje ordrelinje);

    //--------------------------------------------------------------------------------------------------
    List<Produktgruppe> getProduktgruppe();
    void storeProduktgruppe(Produktgruppe produktgruppe);
    void deleteProduktgruppe(Produktgruppe produktgruppe);
    //--------------------------------------------------------------------------------------------------

    //--------------------------------------------------------------------------------------------------
    List<Produkt> getProdukt();
    void storeProdukt(Produkt produkt);
    void deleteProdukt(Produkt produkt);
    //--------------------------------------------------------------------------------------------------

    //--------------------------------------------------------------------------------------------------

}
