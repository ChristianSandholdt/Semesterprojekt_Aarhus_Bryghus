package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Produkt implements Serializable {
    private String navn;
    private final ArrayList<Pris> priser = new ArrayList<>();
    Produktgruppe produktgruppe; // OBS: Package visible
    // ----------------------------------------------------------------------
    public Produkt(String navn, Produktgruppe produktgruppe) {
        this.navn = navn;
        produktgruppe.tilfoejProdukt(this);
        this.produktgruppe = produktgruppe;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }
    public String getNavn() {
        return navn;
    }

    public ArrayList<Pris> getPriser() {
        return priser;
    }
    public Produktgruppe getProduktgruppe() {
        return produktgruppe;
    }

    public void setProduktgruppe(Produktgruppe produktgruppe) {
        produktgruppe.tilfoejProdukt(this);
    }

    public void fjernProduktgruppe(Produktgruppe produktgruppe) {
        produktgruppe.fjernProdukt(this);
    }

    @Override
    public String toString() {
        return navn;
    }
}
