package model;

import java.util.ArrayList;

public class Prisliste {
    private String navn;
    private ArrayList<Pris> priser = new ArrayList<>();

    private ArrayList<Produktgruppe> produktgrupper = new ArrayList<>();

    public Prisliste(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Pris> getPriser() {
        return new ArrayList<>(priser);
    }

    public ArrayList<Produktgruppe> getProduktgrupper() {
        return new ArrayList<>(produktgrupper);
    }

    public void addPris(Pris pris){
        priser.add(pris);
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setPris(double pris) {
    }

    public String toString() {
        return navn;
    }
}
