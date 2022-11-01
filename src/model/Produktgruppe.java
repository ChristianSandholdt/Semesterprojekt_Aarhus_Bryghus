package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Produktgruppe implements Serializable {
    private String navn;
    private String type;

    private ArrayList<Produkt> produkter = new ArrayList<>();

    public Produktgruppe(String navn, String type) {
        this.navn = navn;
        this.type = type;
    }

    public ArrayList<Produkt> getProdukter() {
        return new ArrayList<>(produkter);
    }

    public void tilfoejProdukt(Produkt produkt){
        produkter.add(produkt);
    }

    public void fjernProdukt(Produkt produkt){
        produkter.remove(produkt);
    }

    @Override
    public String toString() {
        return navn + ", " + type;
    }
}
