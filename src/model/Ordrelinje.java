package model;

import java.util.Objects;

public class Ordrelinje {

    public int antal;
    Produkt produkt; // OBS: Package visible

    // ------------------------------------------------------------------------------------------

    public Ordrelinje(int antal, Produkt produkt) {
        this.antal = antal;
        this.produkt = produkt;
    }

    // ------------------------------------------------------------------------------------------

    public int getAntal() {
        return antal;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    @Override
    public String toString() {
        Pris pris;
        String str = String.format("%15s         %5d", produkt.getNavn(), antal);
        return str;
    }
}
