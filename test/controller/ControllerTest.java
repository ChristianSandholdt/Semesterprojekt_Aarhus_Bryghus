package controller;

import model.*;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import storage.ListStorage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {


    ExpectedException exception = ExpectedException.none();

    void setup(){
        Storage storage = new ListStorage();
        Controller.setStorage(storage);
    }

    @Test
    void createRundvisningSucces() {
       setup();
        //Act
        Rundvisning rundvisning = Controller.createRundvisning("Martin","Martin@mail.com",42557898,1200,12,
                LocalDate.of(2022,11,18),"11:30","12:30");
        Rundvisning actual = Controller.getStorage().getRundvisning().get(0);

        //Assert
        assertEquals(actual,rundvisning);
    }

    /**
     *
     * @throws RuntimeException
     * Kan ikke oprettes med 0 personer.
     */
    @Test
    void createRundvisningErrorInputExpectRunTimeError() throws Exception{
        exception.expect(RuntimeException.class);
        exception.expectMessage("Kan ikke oprettes med 0 personer");
        setup();
        //Act
        Rundvisning rundvisning = Controller.createRundvisning("Martin","Martin@mail.com",42557898,1200,0,
                LocalDate.of(2022,11,18),"11:30","12:30");
        //Assert

        }




    @Test
    void totalPris() {
        setup();
        //Act
        Ordre ordre = Controller.createOrdre(false,1,LocalDate.now(), "Klippekort");
        Produktgruppe produktgruppe = Controller.createProduktGruppe("Flaske",false);
        Produkt produkt = Controller.createProdukt("Klosterbryg",produktgruppe);
        Pris pris = new Pris(36,2);
        Ordrelinje ol = new Ordrelinje(2,produkt,pris);
        ordre.addOrdrelinje(ol);


        //Assert
        assertEquals(72.0,Double.parseDouble(Controller.totalPris(ordre)));
    }
}