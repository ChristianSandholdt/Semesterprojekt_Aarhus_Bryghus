package model;

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
    private final ArrayList<Ordre> ordrer = new ArrayList<>();



    public Ordrelinje createOrderLine(int antal, Produkt produkt){
        Ordrelinje orderLine = new Ordrelinje(antal,produkt);
        ordreLinjer.add(orderLine);
        return orderLine;
    }

    public boolean isBetalt() {
        return betalt;
    }

    public void setBetalt(boolean betalt) {
        this.betalt = betalt;
    }

    public int getOrdreID() {
        return ordreID;
    }

    public void setOrdreID(int ordreID) {
        this.ordreID = ordreID;
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
        removeOrdre(ordre);
    }

}
