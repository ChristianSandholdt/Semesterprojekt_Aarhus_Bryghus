package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Prisliste implements Serializable {
    private String navn;
    private ArrayList<Pris> priser = new ArrayList<>();

    private ArrayList<Produktgruppe> produktgrupper = new ArrayList<>();

    public Prisliste(String navn) {
        this.navn = navn;
    }

    public ArrayList<Pris> getPriser() {
        return new ArrayList<>(priser);
    }

    public void addPris(Pris pris) {
        priser.add(pris);
    }

    public void addProduktgruppe(Produktgruppe produktgruppe) {
        produktgrupper.add(produktgruppe);
    }

    public String toString() {
        return navn;
    }
}
