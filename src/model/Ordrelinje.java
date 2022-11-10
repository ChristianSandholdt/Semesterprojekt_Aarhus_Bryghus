package model;

import java.io.Serializable;
import java.util.Objects;

public class Ordrelinje implements Serializable {

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
        String str = String.format("%-24s      %.4s kr.      %12d", produkt.getNavn(), pris, antal);
        return str;
    }

    public Pris getPrisOrdreLinje() {
        return pris;
    }
}
