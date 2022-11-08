package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Pris implements Serializable {
    private final double pris;
    private Prisliste prisliste;
    private Produkt produkt;
    private final double prisIKlip;

    public Pris(double pris,double prisIKlip) {
        this.pris = pris;
        this.prisIKlip = prisIKlip;
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

    public double getPrisIKlip() {
        return prisIKlip;
    }

    @Override
    public String toString() {
        return pris + "";
    }
}
