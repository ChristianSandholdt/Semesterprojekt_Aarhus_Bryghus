package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Produkt implements Serializable {
    private String navn;
    private String beskrivelse;
    Produktgruppe produktgruppe;
    // ----------------------------------------------------------------------
    public Produkt(String navn, String beskrivelse, Produktgruppe produktgruppe) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.produktgruppe = produktgruppe;
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

    public void setProduktgruppe(Produktgruppe produktgruppe) {
        this.produktgruppe = produktgruppe;
    }

    @Override
    public String toString() {
        return navn;
    }
}
