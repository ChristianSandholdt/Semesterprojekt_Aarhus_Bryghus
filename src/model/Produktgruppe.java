package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Produktgruppe implements Serializable {
    private String navn;
    private String type;
    private boolean udlejning;

    private ArrayList<Produkt> produkter = new ArrayList<>();

    public Produktgruppe(String navn, boolean udlejning) {
        this.navn = navn;
        this.udlejning = udlejning;
    }

    public boolean getUdlejning(){
        return this.udlejning;
    }

    public ArrayList<Produkt> getProdukter() {
        return new ArrayList<>(produkter);
    }

    public void tilfoejProdukt(Produkt produkt){
        produkter.add(produkt);
        produkt.produktgruppe=this;
    }

    public void fjernProdukt(Produkt produkt){
        produkter.remove(produkt);
    }

    @Override
    public String toString() {
        return navn + ", " + type;
    }
}
