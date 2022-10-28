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
    private final ArrayList<Ordrelinje> ordrelines = new ArrayList<>();

    public ArrayList<Ordrelinje> getOrdrelinjes() {
        return new ArrayList<>(ordrelines);
    }

    public Ordrelinje createOrderLine(int antal, Produkt produkt){
        OrderLinje
    }
}
