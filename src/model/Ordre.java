package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Ordre implements Serializable {
    public boolean betalt;
    public String betalingsform;
    public double ordreID;
    public LocalDate dato;

    public Ordre(boolean betalt, double ordreID, LocalDate dato, String betalingsform) {
        this.betalt = betalt;
        this.ordreID = ordreID;
        this.dato = dato;
        this.betalingsform = betalingsform;
    }

    // Aggregation -> 0..*
    private final ArrayList<Ordrelinje> ordreLinjer = new ArrayList<>();
    private final ArrayList<Rundvisning> rundvisninger = new ArrayList<>();



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

    public LocalDate getDato() {
        return dato;
    }

    public void setBetalt(boolean betalt) {
        this.betalt = betalt;
    }

    //Bruges til test. Testes ikke selv direkte.
    public boolean isBetalt() {
        return betalt;
    }

    public String getBetalingsform() {
        return betalingsform;
    }

    public void setBetalingsform(String betalingsform){
        this.betalingsform = betalingsform;
    }

    @Override
    public String toString() {
        return "Ordre: " + ordreID;
    }
}
