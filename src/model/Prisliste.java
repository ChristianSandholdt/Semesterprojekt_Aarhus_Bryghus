package model;

import java.util.ArrayList;

public class Prisliste {
    private double pris;
    private Produkt produkt;

    public Prisliste(double pris) {
        this.pris = pris;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }
}
