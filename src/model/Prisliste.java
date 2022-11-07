package model;

import java.util.ArrayList;

public class Prisliste {
    private double pris;
    private String navn;
    private ArrayList<Pris> priser = new ArrayList<>();

    public Prisliste(double pris, String navn) {
        this.pris = pris;
        this.navn = navn;
    }

    public Prisliste(double pris) {
        this.pris = pris;
    }

    public String getNavn() {
        return navn;
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
