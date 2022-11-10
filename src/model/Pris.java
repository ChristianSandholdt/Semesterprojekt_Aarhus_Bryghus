package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Pris implements Serializable {
    private final double pris;
    private Prisliste prisliste;
    private Produkt produkt;
    private double prisIKlip;

    public Pris(double pris, double prisIKlip) {
        this.pris = pris;
        this.prisIKlip = prisIKlip;
    }


    public double getPris() {
        return pris;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public double getPrisIKlip() {
        return prisIKlip;
    }

    public void setPrisIKlip(double prisIKlip) {
        this.prisIKlip = prisIKlip;
    }

    @Override
    public String toString() {
        return pris + "";
    }
}
