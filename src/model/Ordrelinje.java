package model;

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
//        String str = String.format("%15s %.2f %5d", produkt.getNavn(),produkt.getPriser(), antal);
        String str = String.format("%5s %25d", produkt.getNavn(),antal);
        return str;
    }
}
