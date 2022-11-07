package model;

import java.util.ArrayList;

public class Pris {
    private final double pris;
    private Prisliste prisliste;
    private Produkt produkt;

    public Pris(double pris) {
        this.pris = pris;
    }
    public double getPris() {
        return pris;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }


}
