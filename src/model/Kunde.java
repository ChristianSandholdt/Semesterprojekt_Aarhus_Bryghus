package model;

import java.util.ArrayList;

public class Kunde {

    // Association -> 0..x Ordre
    private final ArrayList<Ordre> ordrer = new ArrayList<>();

    public ArrayList<Ordre> getOrdrer(){
        return new ArrayList<>(ordrer);
    }
    private final String name;
    private final String email;
    private final int telefonNr;
    private int antalKlip;
    private boolean studerende;

    public Kunde(String name, String email, int telefonNr, int antalKlip, boolean studerende) {
        this.name = name;
        this.email = email;
        this.telefonNr = telefonNr;
        this.antalKlip = antalKlip;
        this.studerende = studerende;
    }
    // ---------------------------------------------------------------------------------------

    /**
     * Checks whether the customer qualifies for a discount based on number of orders
     * Returns a boolean either true or false
     */
    public boolean godKunde(){
        boolean god = false;
        if (getOrdrer().size() >= 5){
            god = true;
        }
        return god;
    }


}
