package model;

import java.util.ArrayList;

public class Pris {
    private final String navn;
    private final double pris;
    private final String beskrivelse;
    private Prisliste prisliste;
    private Produkt produkt;

    public Pris(String navn, double pris, String beskrivelse) {
        this.navn = navn;
        this.pris = pris;
        this.beskrivelse = beskrivelse;
    }

    public String getNavn() {
        return navn;
    }

    public double getPris(Prisliste pl, Produkt pr) {
        double realOGPrice = 0;
        for (Pris p : pl.getPriser()){
            if(p.produkt.equals(pr))
                realOGPrice = p.pris;
        }
        return realOGPrice;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }
}
