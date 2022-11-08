package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Ordre implements Serializable {
    public boolean betalt;
    public int sum;
    public String betalingsform;
    public int ordreID;

    public LocalDate dato;

    private Kunde kunde;

    public Ordre(boolean betalt, int ordreID,LocalDate dato) {
        this.betalt = betalt;
        this.ordreID = ordreID;
        this.dato = dato;
    }

    // Aggregation -> 0..*
    private final ArrayList<Ordrelinje> ordreLinjer = new ArrayList<>();
    private final ArrayList<Rundvisning> rundvisninger = new ArrayList<>();
    private final ArrayList<Ordre> ordrer = new ArrayList<>();

    public Ordrelinje createOrderLine(int antal, Produkt produkt, Pris pris){
        Ordrelinje orderLine = new Ordrelinje(antal,produkt,pris);
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
        ordrer.add(ordre);
    }
    public void removeOrdre(Ordre ordre){
        ordrer.remove(ordre);
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setBetalt(boolean betalt) {
        this.betalt = betalt;
    }


    @Override
    public String toString() {
        return "Ordre: " + ordreID;
    }
}
