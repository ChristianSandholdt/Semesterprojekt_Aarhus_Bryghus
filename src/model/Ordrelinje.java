package model;

import java.util.Objects;

public class Ordrelinje {

    public int antal;
    Pris pris; // OBS: Package visible
    Produkt produkt; // OBS: Package visible

    // ------------------------------------------------------------------------------------------

    public Ordrelinje(int antal, Produkt produkt, Pris pris) {
        this.antal = antal;
        this.produkt = produkt;
        this.pris = pris;
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
        String str = String.format("%15s    %.5s     %5d", produkt.getNavn(),pris, antal);
        return str;
    }
}
