package model;

import java.util.ArrayList;

public class Pris {
    private final double pris;
    private Prisliste prisliste;
    private Produkt produkt;

    public Pris(double pris) {
        this.pris = pris;
    }


    public double getPris(Prisliste pl, Produkt pr) {
        double realOGPrice = 0;
        for (Pris p : pl.getPriser()) {
            if (p.produkt.equals(pr))
                realOGPrice = p.pris;
        }
        return realOGPrice;
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

    @Override
    public String toString() {
        return pris + "";
    }
}
