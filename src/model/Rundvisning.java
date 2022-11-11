package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Rundvisning implements Serializable {
    private String navn;
    private String email;
    private int tlfNummer;
    private double pris;
    private int antalPersoner;
    private LocalDate dato;
    private String startTid;
    private String slutTid;

    // ------------------------------------------------------------------------------------------

    public Rundvisning(String navn, String email, int tlfNummer, double pris, int antalPersoner, LocalDate dato, String startTid, String slutTid) {
        this.navn = navn;
        this.email = email;
        this.tlfNummer = tlfNummer;
        this.pris = pris;
        this.antalPersoner = antalPersoner;
        this.dato = dato;
        this.startTid = startTid;
        this.slutTid = slutTid;
    }

    // ------------------------------------------------------------------------------------------

    // Getters

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    public int getTlfNummer() {
        return tlfNummer;
    }

    public int getAntalPersoner() {
        return antalPersoner;
    }

    public LocalDate getDato() {
        return dato;
    }

    public String getStartTid() {
        return startTid;
    }

    public String getSlutTid() {
        return slutTid;
    }


    public void setPris(double pris) {
        this.pris = pris;
    }


    @Override
    public String toString() {
        return "Rundvisning {" +
                "Navn: " + navn +
                ", email: " + email +
                ", telefon: " + tlfNummer +
                ", pris: " + pris +
                ", antalPersoner: " + antalPersoner +
                ", dato: " + dato +
                ", startTid: " + startTid +
                ", slutTid: " + slutTid +
                '}';
    }
}
