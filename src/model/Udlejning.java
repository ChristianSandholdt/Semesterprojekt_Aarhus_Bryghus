package model;

import java.io.Serializable;

public class Udlejning implements Serializable {
    private final int antal;
    private final double pris;
    private final Produkt produkt;
    private final int liter;
    private final double rest;
    private double pant = 200;
    private double anlaeg;
    private int krus = 60;
    private Ordrelinje ordrelinje;


    public Udlejning(int antal, double pris, Produkt produkt, int liter, double rest, double pant, double anlaeg, int krus) {
        this.antal = antal;
        this.pris = pris;
        this.produkt = produkt;
        this.liter = liter;
        this.rest = rest;
        this.pant = pant;
        this.anlaeg = anlaeg;
        this.krus = krus;
    }


    public int getAntal() {
        return antal;
    }

    public double getPris() {
        return pris;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public int getLiter() {
        return liter;
    }

    public double getRest() {
        return rest;
    }

    public double getPant() {
        return pant;
    }

    public Ordrelinje getOrdrelinje() {
        return ordrelinje;
    }

    public double pris(){
        double totalPris = 0;
        totalPris = (pris / 20 * liter + pant) * antal + krus + anlaeg;
        return totalPris;
    }
    public double udregnRest(){
        double retur = 0;
        if(antal < 1)
            return retur;
        else
            return retur + (antal * pris) + pant + anlaeg;
    }

}

