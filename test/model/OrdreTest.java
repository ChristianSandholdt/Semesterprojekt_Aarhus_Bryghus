package model;

import controller.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrdreTest {

    @org.junit.jupiter.api.Test
    void getOrdrelinjer() {
        //Act
        Produktgruppe produktgruppe = new Produktgruppe("Flaske",false);
        Produkt produkt = new Produkt("KlosterBryg",produktgruppe);
        Produkt produkt2 = new Produkt("Georgia Brown Ale",produktgruppe);
        Produkt produkt3 = new Produkt("Blondie",produktgruppe);
        Pris pris = new Pris(36,2);
        Ordrelinje ol1 = new Ordrelinje(1,produkt,pris);
        Ordrelinje ol2 = new Ordrelinje(1,produkt2,pris);
        Ordrelinje ol3 = new Ordrelinje(1,produkt3,pris);
        ArrayList<Ordrelinje> temp = new ArrayList<>();
        temp.add(ol1);
        temp.add(ol2);
        temp.add(ol3);

        Ordre ordre = new Ordre(true,1, LocalDate.now(),"Klippekort");
        ordre.addOrdrelinje(ol1);
        ordre.addOrdrelinje(ol2);
        ordre.addOrdrelinje(ol3);
        ArrayList<Ordrelinje> actual = ordre.getOrdrelinjer();

        //Assert
        assertEquals(temp,actual);
    }

    @org.junit.jupiter.api.Test
    void addOrdrelinje() {
        Produktgruppe produktgruppe = new Produktgruppe("Flaske",false);
        Produkt produkt = new Produkt("KlosterBryg",produktgruppe);
        Pris pris = new Pris(36,2);
        Ordrelinje ol1 = new Ordrelinje(1,produkt,pris);
        ArrayList<Ordrelinje> temp = new ArrayList<>();
        temp.add(ol1);


        Ordre ordre = new Ordre(true,1, LocalDate.now(),"Klippekort");
        ordre.addOrdrelinje(ol1);

        ArrayList<Ordrelinje> actual = ordre.getOrdrelinjer();

        //Assert
        assertEquals(temp,actual);
    }

    @org.junit.jupiter.api.Test
    void removeOrdrelinje() {
        //Act
        Produktgruppe produktgruppe = new Produktgruppe("Flaske",false);
        Produkt produkt = new Produkt("KlosterBryg",produktgruppe);
        Produkt produkt2 = new Produkt("Georgia Brown Ale",produktgruppe);
        Pris pris = new Pris(36,2);
        Ordrelinje ol1 = new Ordrelinje(1,produkt,pris);
        Ordrelinje ol2 = new Ordrelinje(1,produkt2,pris);
        ArrayList<Ordrelinje> temp = new ArrayList<>();
        temp.add(ol1);

        Ordre ordre = new Ordre(true,1, LocalDate.now(),"Klippekort");
        ordre.addOrdrelinje(ol1);
        ordre.addOrdrelinje(ol2);
        ordre.removeOrdrelinje(ol2);
        ArrayList<Ordrelinje> actual = ordre.getOrdrelinjer();

        //Assert
        assertEquals(temp,actual);
    }

    @org.junit.jupiter.api.Test
    void getDato() {
        //Act
        Ordre actual = new Ordre(false,1,LocalDate.now(),"Klippekort");
        LocalDate temp = LocalDate.now();

        //Assert
        assertEquals(temp,actual.getDato());
    }

    @org.junit.jupiter.api.Test
    void setBetaltTrue() {
        //Act
        Ordre actual = new Ordre(false,1,LocalDate.now(),"Klippekort");
        boolean temp = true;
        actual.setBetalt(true);

        //Assert
        assertEquals(temp,actual.isBetalt());
    }
    @org.junit.jupiter.api.Test
    void setBetaltFalse() {
        //Act
        Ordre actual = new Ordre(true,1,LocalDate.now(),"Klippekort");
        boolean temp = false;
        actual.setBetalt(false);

        //Assert
        assertEquals(temp,actual.isBetalt());
    }

    @org.junit.jupiter.api.Test
    void getBetalingsform() {
        //Act
        Ordre actual = new Ordre(true,1,LocalDate.now(),"Klippekort");

        String temp = "Klippekort";
        //Assert
        assertEquals(temp,actual.getBetalingsform());
    }

    @org.junit.jupiter.api.Test
    void setBetalingsformKlippekort() {
        //Act
        Ordre actual = new Ordre(true,1,LocalDate.now(),"Betalingskort");
        actual.setBetalingsform("Klippekort");

        String temp = "Klippekort";
        //Assert
        assertEquals(temp,actual.getBetalingsform());
    }

    @org.junit.jupiter.api.Test
    void setBetalingsformBetalingskort() {
        //Act
        Ordre actual = new Ordre(true,1,LocalDate.now(),"Klippekort");
        actual.setBetalingsform("Betalingskort");

        String temp = "Betalingskort";
        //Assert
        assertEquals(temp,actual.getBetalingsform());
    }

    @org.junit.jupiter.api.Test
    void setBetalingsformKontant() {
        //Act
        Ordre actual = new Ordre(true,1,LocalDate.now(),"Betalingskort");
        actual.setBetalingsform("Kontant");

        String temp = "Kontant";
        //Assert
        assertEquals(temp,actual.getBetalingsform());
    }

    @org.junit.jupiter.api.Test
    void setBetalingsformMobilepay() {
        //Act
        Ordre actual = new Ordre(true,1,LocalDate.now(),"Betalingskort");
        actual.setBetalingsform("Mobilepay");

        String temp = "Mobilepay";
        //Assert
        assertEquals(temp,actual.getBetalingsform());
    }
}