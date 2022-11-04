package gui;

import controller.Controller;
import controller.Storage;
import javafx.application.Application;
import model.Produkt;
import model.Produktgruppe;
import storage.ListStorage;

public class App {

    public static void main(String[] args) {
        ListStorage storage = ListStorage.loadStorage();
        if (storage == null){
            storage = new ListStorage();
            System.out.println("Empty liststorage created");
        }

        Controller.setStorage(storage);

        Application.launch(Gui.class);

        Produktgruppe p1 = new Produktgruppe("Øl", false);
        Controller.createProdukt("Klosterbryg",p1);
        System.out.println(p1.getProdukter());
    }


    Produktgruppe pg1 = new Produktgruppe("Flaske", false);
    Produkt p1 = new Produkt("Klosterbryg",pg1);
    Produkt p2 = new Produkt("Sweet Georgia Brown",pg1);
    Produkt p3 = new Produkt("Extra Pilsner",pg1);
    Produkt p4 = new Produkt("Celebration",pg1);
    Produkt p5 = new Produkt("Blondie",pg1);
    Produkt p6 = new Produkt("Forårsbryg", pg1);
    Produkt p7 = new Produkt("India Pale Ale",pg1);
    Produkt p8 = new Produkt("Julebryg", pg1);
    Produkt p9 = new Produkt("Juletønden",pg1);
    Produkt p10 = new Produkt("Old Strong Ale", pg1);
    Produkt p11 = new Produkt("Fregatten Jylland",pg1);
    Produkt p12 = new Produkt("Imperial Stout",pg1);
    Produkt p13 = new Produkt("Tribute",pg1);
    Produkt p14 = new Produkt("Black Monster",pg1);

    Produktgruppe pg2 = new Produktgruppe("Fadøl 40 cl",false);
    Produkt p15 = new Produkt("Klosterbryg",pg2);
    Produkt p16 = new Produkt("Jazz Classic",pg2);
    Produkt p17 = new Produkt("Extra Pilsner",pg2);
    Produkt p18 = new Produkt("Celebration",pg2);
    Produkt p19 = new Produkt("Blondie",pg2);
    Produkt p20 = new Produkt("Forårsbryg",pg2);
    Produkt p21 = new Produkt("India Pale Ale",pg2);
    Produkt p22 = new Produkt("Julebryg",pg2);
    Produkt p23 = new Produkt("Imperial Stout",pg2);
    Produkt p24 = new Produkt("Special",pg2);
    Produkt p25 = new Produkt("Æblebrus",pg2);
    Produkt p26 = new Produkt("Chips",pg2);
    Produkt p27 = new Produkt("Peanuts",pg2);
    Produkt p28 = new Produkt("Cola",pg2);
    Produkt p29 = new Produkt("Nikoline",pg2);
    Produkt p30 = new Produkt("7-up",pg2);
    Produkt p31 = new Produkt("Vand",pg2);
    Produkt p32 = new Produkt("Ølpølser",pg2);

    Produktgruppe pg3 = new Produktgruppe("Spiritus",false);
    Produkt p33 = new Produkt("Whisky 45% 50 cl rør",pg3);
    Produkt p34 = new Produkt("Whisky 4 cl",pg3);
    Produkt p35 = new Produkt("Whisky 43% 50 cl rør",pg3);
    Produkt p36 = new Produkt("u/ egesplint",pg3);
    Produkt p37 = new Produkt("m/ egesplint",pg3);
    Produkt p38 = new Produkt("2*whisky glas + brikker",pg3);
    Produkt p39 = new Produkt("Liquor of Aarhus",pg3);
    Produkt p40 = new Produkt("Lyng gin 50 cl",pg3);
    Produkt p41 = new Produkt("Lyng gin 4 cl",pg3);

    Produktgruppe pg4 = new Produktgruppe("Fustage", true);
    Produkt p42 = new Produkt("Klosterbryg, 20 liter",pg4);
    Produkt p43 = new Produkt("Jazz Classic, 25 liter",pg4);
    Produkt p44 = new Produkt("Extra Pilsner, 25 liter",pg4);
    Produkt p45 = new Produkt("Celebration, 20 liter",pg4);
    Produkt p46 = new Produkt("Blondie, 25 liter",pg4);
    Produkt p47 = new Produkt("Forårsbryg, 20 liter",pg4);
    Produkt p48 = new Produkt("India Pale Ale, 20 liter",pg4);
    Produkt p49 = new Produkt("Julebryg, 20 liter",pg4);
    Produkt p50 = new Produkt("Imperial Stout, 20 liter",pg4);
    Produkt p51 = new Produkt("Pant",pg4);

    Produktgruppe pg5 = new Produktgruppe("Kulsyre", true);
    Produkt p52 = new Produkt("6 kg",pg5);
    Produkt p53 = new Produkt("Pant",pg5);
    Produkt p54 = new Produkt("4 kg",pg5);
    Produkt p55 = new Produkt("10 kg",pg5);






}
