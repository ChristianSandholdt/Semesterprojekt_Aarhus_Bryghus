package model;

import java.util.ArrayList;

public class Pris {
    private final String navn;
    private final double pris;
    private final String beskrivelse;

    public Pris(String navn, double pris, String beskrivelse) {
        this.navn = navn;
        this.pris = pris;
        this.beskrivelse = beskrivelse;
    }

    public String getNavn() {
        return navn;
    }

    public double getPris() {
        return pris;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }
}
