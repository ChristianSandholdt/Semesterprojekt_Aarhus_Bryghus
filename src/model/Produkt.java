package model;

import java.util.ArrayList;

public class Produkt {
    private String navn;
    private String beskrivelse;
    private Produktgruppe produktgruppe;
    private final ArrayList<Pris> priser = new ArrayList<>();
    // ----------------------------------------------------------------------
    public Produkt(String navn, String beskrivelse) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }
    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
    public String getNavn() {
        return navn;
    }
    public String getBeskrivelse() {
        return beskrivelse;
    }

    public Produktgruppe getProduktgruppe() {
        return produktgruppe;
    }
}
