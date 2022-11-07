package model;

import java.util.ArrayList;

public class Prisliste {
    private String navn;
    private ArrayList<Pris> priser = new ArrayList<>();

    public Prisliste(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Pris> getPriser() {
        return priser;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
