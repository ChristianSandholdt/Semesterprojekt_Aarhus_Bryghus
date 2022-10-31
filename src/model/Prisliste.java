package model;

public class Prisliste {
    private int pris;
    private Produkt produkt;
    private Prisliste prisliste;

    public Prisliste(int pris) {
        this.pris = pris;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public Prisliste getPrisliste() {
        return prisliste;
    }

    public void setPrisliste(Prisliste prisliste) {
        this.prisliste = prisliste;
    }
}
