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
        Pris pris = null;
        double pr = 0;
        for (Pris p : produkt.getPriser()) {
            assert false;
            if(Objects.equals(produkt.getNavn(), pris.getNavn()))
                pr = p.getPris();
        }
        String str = String.format("%15s        %.2f kr,-        %5d", produkt.getNavn(),pr, antal);
        return str;
    }
}
