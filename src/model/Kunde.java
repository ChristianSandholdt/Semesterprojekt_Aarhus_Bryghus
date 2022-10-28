package model;

import java.util.ArrayList;

public class Kunde {

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

    public ArrayList<Integer> koebsHistorik = new ArrayList<>();


}
