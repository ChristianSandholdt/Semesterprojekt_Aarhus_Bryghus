package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Ordrelinje {

    public int antal;
    private final ArrayList<Rundvisning> rundvisninger = new ArrayList<>();
    Produkt produkt; // OBS: Package visible

    // ------------------------------------------------------------------------------------------

    public Ordrelinje(int antal, Produkt produkt) {
        this.antal = antal;
        this.produkt = produkt;
    }
    // ------------------------------------------------------------------------------------------

    public ArrayList<Rundvisning> getRundvisninger() {
        return new ArrayList<>(rundvisninger);
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
        return "" + produkt + " " + antal;
    }


    public Rundvisning createRundvisning(double pris, int antalPersoner, LocalDate dato, LocalDateTime startTid, LocalDateTime slutTid) {
        Rundvisning rundvisning = new Rundvisning(pris, antalPersoner, dato, startTid, slutTid);
        rundvisninger.add(rundvisning);
        rundvisning.ordrelinje = this;
        return rundvisning;
    }
}
