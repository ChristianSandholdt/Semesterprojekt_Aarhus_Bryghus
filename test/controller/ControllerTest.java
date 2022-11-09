package controller;

import model.Rundvisning;
import org.junit.jupiter.api.Test;
import storage.ListStorage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {



    @Test
    void createRundvisning() {
        //Act
        Storage storage = new ListStorage();
        Controller.setStorage(storage);
        Rundvisning rundvisning = Controller.createRundvisning("Martin","Martin@mail.com",42557898,1200,12,
                LocalDate.of(2022,11,18),"11:30","12:30");
        List<Rundvisning> actual = Controller.getStorage().getRundvisning();

        Rundvisning rundvisning1 = new Rundvisning("Martin","Martin@mail.com",42557898,1200,12,
                LocalDate.of(2022,11,18),"11:30","12:30");
        List<Rundvisning> temp = new ArrayList<>(List.of(rundvisning));

        //Assert
        assertEquals(temp,actual);
    }

    @Test
    void totalPris() {
        
    }
}