package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Ordre {
    public boolean betalt;
    public int sum;
    public String betalingsform;
    public int ordreID;

    private Kunde kunde;

    public Ordre(boolean betalt, int ordreID) {
        this.betalt = betalt;
        this.ordreID = ordreID;
    }

    // Aggregation -> 0..*
    private final ArrayList<Ordrelinje> ordreLinjer = new ArrayList<>();
    private final ArrayList<Rundvisning> rundvisninger = new ArrayList<>();

    public Ordrelinje createOrderLine(int antal, Produkt produkt){
        Ordrelinje orderLine = new Ordrelinje(antal,produkt);
        ordreLinjer.add(orderLine);
        return orderLine;
    }

    public ArrayList<Rundvisning> getRundvisninger() {
        return new ArrayList<>(rundvisninger);
    }
    public ArrayList<Ordrelinje> getOrdrelinjer() {
        return new ArrayList<>(ordreLinjer);
    }

    //Pre: The OrderLine is not connected to an Order.
    public void addOrdrelinje(Ordrelinje ordrelinje){
        ordreLinjer.add(ordrelinje);
    }

    //Pre: The OrderLine is connected to an Order.
    public void removeOrdrelinje(Ordrelinje ordrelinje){
        ordreLinjer.remove(ordrelinje);
    }

    public void addOrdre(Ordre ordre) {
        ordre.addOrdre(ordre);
    }
    public void removeOrdre(Ordre ordre){
        removeOrdre(ordre);
    }

    public Rundvisning createRundvisning(String navn, String email, int tlfNummer, double pris, int antalPersoner, LocalDate dato, LocalDateTime startTid, LocalDateTime slutTid) {
        Rundvisning rundvisning = new Rundvisning(navn, email, tlfNummer, pris, antalPersoner, dato, startTid, slutTid);
        rundvisninger.add(rundvisning);
        rundvisning.ordre = this;
        return rundvisning;
    }

}
