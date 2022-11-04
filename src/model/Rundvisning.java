package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Rundvisning implements Serializable {
    private String navn;
    private String email;
    private int tlfNummer;
    private double pris;
    private int antalPersoner;
    private LocalDate dato;
    private String startTid;
    private String slutTid;

    Ordre ordre; // OBS: package visible

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

    public double getPris() {
        return pris;
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

    // Setters

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTlfNummer(int tlfNummer) {
        this.tlfNummer = tlfNummer;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public void setAntalPersoner(int antalPersoner) {
        this.antalPersoner = antalPersoner;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public void setStartTid(String startTid) {
        this.startTid = startTid;
    }

    public void setSlutTid(String slutTid) {
        this.slutTid = slutTid;
    }

    // To String metode

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
