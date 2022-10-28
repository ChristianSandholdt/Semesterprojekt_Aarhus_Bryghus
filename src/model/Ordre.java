package model;

import java.util.ArrayList;

public class Ordre {
    public boolean betalt;
    public int sum;
    public String betalingsform;
    public String ordreID;

    public Ordre(boolean betalt, int sum, String betalingsform, String ordreID) {
        this.betalt = betalt;
        this.sum = sum;
        this.betalingsform = betalingsform;
        this.ordreID = ordreID;
    }

    // Aggregation -> 0..*
    private final ArrayList<Ordrelinje> orderLines = new ArrayList<>();

    public ArrayList<Ordrelinje> getOrdrelinjes() {
        return new ArrayList<>(orderLines);
    }

    public Ordrelinje createOrderLine(int antal, Produkt produkt){
        Ordrelinje orderLine = new Ordrelinje(antal,produkt);
        orderLines.add(orderLine);
        return orderLine;
    }

    //Pre: The OrderLine is not connected to an Order.
    public void addOrderLine(Ordrelinje ordrelinje){
        orderLines.add(ordrelinje);
    }

    //Pre: The OrderLine is connected to an Order.
    public void removeOrderLine(Ordrelinje ordrelinje){
        orderLines.remove(ordrelinje);
    }
}
