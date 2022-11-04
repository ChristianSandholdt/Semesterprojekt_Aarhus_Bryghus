package model;

import java.util.ArrayList;

public class Prisliste {
    private double pris;
    private ArrayList<Pris> priser = new ArrayList<>();

    public Prisliste(double pris) {
        this.pris = pris;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public ArrayList<Pris> getPriser() {
        return priser;
    }
}
