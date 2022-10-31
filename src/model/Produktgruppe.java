package model;

import java.util.ArrayList;

public class Produktgruppe {
    private String navn;
    private String type;

    private ArrayList<Produkt> produkter = new ArrayList<>();

    public Produktgruppe(String navn, String type) {
        this.navn = navn;
        this.type = type;
    }
    // ----------------------------------------------------------------------------


    public Produktgruppe(String navn, String type, ArrayList<Produkt> produkter) {
        this.navn = navn;
        this.type = type;
        this.produkter = produkter;
    }
}
