package controller;

import model.Produkt;
import model.Produktgruppe;

import java.util.List;

public interface Storage {

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
