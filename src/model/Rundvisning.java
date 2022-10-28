package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Rundvisning {
    private double pris;
    private int antalPersoner;
    private LocalDate dato;
    private LocalDateTime startTid;
    private LocalDateTime slutTid;

    Ordrelinje ordrelinje; // OBS: package visible

    // ------------------------------------------------------------------------------------------

    Rundvisning(double pris, int antalPersoner, LocalDate dato, LocalDateTime startTid, LocalDateTime slutTid) {
        this.pris = pris;
        this.antalPersoner = antalPersoner;
        this.dato = dato;
        this.startTid = startTid;
        this.slutTid = slutTid;
    }

    // ------------------------------------------------------------------------------------------

    public Ordrelinje ordrelinje() {
        return ordrelinje();
    }

    // Getters

    public double getPris() {
        return pris;
    }

    public int getAntalPersoner() {
        return antalPersoner;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalDateTime getStartTid() {
        return startTid;
    }

    public LocalDateTime getSlutTid() {
        return slutTid;
    }

    // Setters


    public void setPris(double pris) {
        this.pris = pris;
    }

    public void setAntalPersoner(int antalPersoner) {
        this.antalPersoner = antalPersoner;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public void setStartTid(LocalDateTime startTid) {
        this.startTid = startTid;
    }

    public void setSlutTid(LocalDateTime slutTid) {
        this.slutTid = slutTid;
    }

    // ------------------------------------------------------------------------------------------

    public void bookRundvisning(Rundvisning rundvisning) {

    }

    // ------------------------------------------------------------------------------------------

    // To String metode

    @Override
    public String toString() {
        return "Rundvisning{" +
                "pris=" + pris +
                ", antalPersoner=" + antalPersoner +
                ", dato=" + dato +
                ", startTid=" + startTid +
                ", slutTid=" + slutTid +
                '}';
    }
}
