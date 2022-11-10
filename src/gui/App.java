package gui;

import controller.Controller;
import javafx.application.Application;
import model.*;
import storage.ListStorage;

public class App {

    public static void main(String[] args) {
        ListStorage storage = ListStorage.loadStorage();
        if (storage == null){
            storage = new ListStorage();
            System.out.println("Empty liststorage created");
        }

        Controller.setStorage(storage);

        initStorage();
        Application.launch(Gui.class);

    }

    public static void initStorage(){
        Prisliste butik = Controller.createPrisliste("Butik");
        Prisliste fredagsbar = Controller.createPrisliste("Fredagsbar");

        Produktgruppe pgKlippeKort = Controller.createProduktGruppe("Klippekort",false);
        Produkt p = Controller.createProdukt("Klippekort",pgKlippeKort);
        Controller.createPris(p,butik,130,0);
        Controller.createPris(p,fredagsbar,130,0);

        Produktgruppe pg1 = Controller.createProduktGruppe("Flaske",false);
        Produkt p1 = Controller.createProdukt("Klosterbryg",pg1);
        Controller.createPris(p1,butik,36,0);
        Controller.createPris(p1,fredagsbar,70,2);

        Produkt p2 = Controller.createProdukt("Sweet Georgie Brown", pg1);
        Controller.createPris(p2,butik,36,0);
        Controller.createPris(p2,fredagsbar,70,2);

        Produkt p3 = Controller.createProdukt("Extra Pilsner",pg1);
        Controller.createPris(p3,butik,36,0);
        Controller.createPris(p3,fredagsbar,70,2);

        Produkt p4 = Controller.createProdukt("Celebration",pg1);
        Controller.createPris(p4,butik,36,0);
        Controller.createPris(p4,fredagsbar,70,2);

        Produkt p5 = Controller.createProdukt("Blondie",pg1);
        Controller.createPris(p5,butik,36,0);
        Controller.createPris(p5,fredagsbar,70,2);

        Produkt p6 = Controller.createProdukt("Forårsbryg",pg1);
        Controller.createPris(p6,butik,36,0);
        Controller.createPris(p6,fredagsbar,70,2);

        Produkt p7 = Controller.createProdukt("India Pale Ale",pg1);
        Controller.createPris(p7,butik,36,0);
        Controller.createPris(p7,fredagsbar,70,2);

        Produkt p8 = Controller.createProdukt("Julebryg",pg1);
        Controller.createPris(p8,butik,36,0);
        Controller.createPris(p8,fredagsbar,70,2);

        Produkt p9 = Controller.createProdukt("Juletønden",pg1);
        Controller.createPris(p9,butik,36,0);
        Controller.createPris(p9,fredagsbar,70,2);

        Produkt p10 = Controller.createProdukt("Old Strong Ale",pg1);
        Controller.createPris(p10,butik,36,0);
        Controller.createPris(p10,fredagsbar,70,2);

        Produkt p11 = Controller.createProdukt("Fregatten Jylland",pg1);
        Controller.createPris(p11,butik,36,0);
        Controller.createPris(p11,fredagsbar,70,2);

        Produkt p12 = Controller.createProdukt("Imperial Stout",pg1);
        Controller.createPris(p12,butik,36,0);
        Controller.createPris(p12,fredagsbar,70,2);

        Produkt p13 = Controller.createProdukt("Tribute",pg1);
        Controller.createPris(p13,butik,36,0);
        Controller.createPris(p13,fredagsbar,70,2);

        Produkt p14 = Controller.createProdukt("Black Monster",pg1);
        Controller.createPris(p14,butik,60,0);
        Controller.createPris(p14,fredagsbar,100,3);





        Produktgruppe pg2 = Controller.createProduktGruppe("Fadøl 40 cl",false);

        Produkt p15 = Controller.createProdukt("Klosterbryg",pg2);
        Controller.createPris(p15, fredagsbar, 38, 1);

        Produkt p16 = Controller.createProdukt("Jazz Classic",pg2);
        Controller.createPris(p16, fredagsbar, 38, 1);

        Produkt p17 = Controller.createProdukt("Extra pilsner",pg2);
        Controller.createPris(p17, fredagsbar, 38, 1);

        Produkt p18 = Controller.createProdukt("Celebration",pg2);
        Controller.createPris(p18, fredagsbar, 38, 1);

        Produkt p19 = Controller.createProdukt("Blondie",pg2);
        Controller.createPris(p19, fredagsbar, 38, 1);

        Produkt p20 = Controller.createProdukt("Forårsbryg",pg2);
        Controller.createPris(p20, fredagsbar, 38, 1);

        Produkt p21 = Controller.createProdukt("India Pale Ale",pg2);
        Controller.createPris(p21, fredagsbar, 38, 1);

        Produkt p22 = Controller.createProdukt("Julebryg",pg2);
        Controller.createPris(p22, fredagsbar, 38, 1);

        Produkt p23 = Controller.createProdukt("Imperial Stout",pg2);
        Controller.createPris(p23, fredagsbar, 38, 1);

        Produkt p24 = Controller.createProdukt("Special",pg2);
        Controller.createPris(p24, fredagsbar, 38, 1);

        Produkt p25 = Controller.createProdukt("Æblebrus",pg2);
        Controller.createPris(p25, fredagsbar, 15, 0);

        Produkt p26 = Controller.createProdukt("Chips",pg2);
        Controller.createPris(p26, fredagsbar, 10, 0);

        Produkt p27 = Controller.createProdukt("Peanuts",pg2);
        Controller.createPris(p27, fredagsbar, 15, 0);

        Produkt p28 = Controller.createProdukt("Cola",pg2);
        Controller.createPris(p28, fredagsbar, 15, 0);

        Produkt p29 = Controller.createProdukt("Nikoline",pg2);
        Controller.createPris(p29, fredagsbar, 15, 0);

        Produkt p30 = Controller.createProdukt("7-Up",pg2);
        Controller.createPris(p30, fredagsbar, 15, 0);

        Produkt p31 = Controller.createProdukt("Vand",pg2);
        Controller.createPris(p31, fredagsbar, 10, 0);

        Produkt p32 = Controller.createProdukt("Ølpølser",pg2);
        Controller.createPris(p32, fredagsbar, 30, 1);



        Produktgruppe pg3 = Controller.createProduktGruppe("Spiritus",false);

        Produkt p33 = Controller.createProdukt("Whisky 45% 50 cl rør",pg3);
        Controller.createPris(p33, fredagsbar, 599, 0);
        Controller.createPris(p33, butik, 599, 0);

        Produkt p34 = Controller.createProdukt("Whiskey 4 cl",pg3);
        Controller.createPris(p34, fredagsbar,50,0);

        Produkt p35 = Controller.createProdukt("Whiskey 43% 50cl rør", pg3);
        Controller.createPris(p35, fredagsbar, 499, 0);
        Controller.createPris(p35, butik, 499, 0);

        Produkt p36 = Controller.createProdukt("u/ egesplint",pg3);
        Controller.createPris(p36, fredagsbar, 300, 0);
        Controller.createPris(p36, butik, 300, 0);

        Produkt p37 = Controller.createProdukt("m/ egesplint",pg3);
        Controller.createPris(p37, fredagsbar, 350, 0);
        Controller.createPris(p37, butik, 350, 0);

        Produkt p38 = Controller.createProdukt("2*whisky glas + brikker",pg3);
        Controller.createPris(p38, fredagsbar, 80, 0);
        Controller.createPris(p38, butik, 80, 0);

        Produkt p39 = Controller.createProdukt("Liquor of Aarhus",pg3);
        Controller.createPris(p39, fredagsbar, 175, 0);
        Controller.createPris(p39, butik, 175, 0);

        Produkt p40 = Controller.createProdukt("Lyng gin 50 cl",pg3);
        Controller.createPris(p40, fredagsbar, 350, 0);
        Controller.createPris(p40, butik, 350, 0);

        Produkt p41 = Controller.createProdukt("Lyng gin 4 cl",pg3);
        Controller.createPris(p41, fredagsbar, 40, 0);


        Produktgruppe pg4 = Controller.createProduktGruppe("Fustage",true);
        Produkt p42 = Controller.createProdukt("Klosterbryg, 20 liter",pg4);
        Controller.createPris(p42, butik, 775, 0);

        Produkt p43 = Controller.createProdukt("Jazz Classic, 25 liter",pg4);
        Controller.createPris(p43, butik, 625, 0);

        Produkt p44 = Controller.createProdukt("Extra Pilsner, 25 liter",pg4);
        Controller.createPris(p44, butik, 575, 0);

        Produkt p45 = Controller.createProdukt("Celebration, 20 liter",pg4);
        Controller.createPris(p45, butik, 775, 0);

        Produkt p46 = Controller.createProdukt("Blondie, 25 liter",pg4);
        Controller.createPris(p46, butik, 700, 0);

        Produkt p47 = Controller.createProdukt("Forårsbryg, 20 liter",pg4);
        Controller.createPris(p47, butik, 775, 0);

        Produkt p48 = Controller.createProdukt("India Pale Ale, 20 liter",pg4);
        Controller.createPris(p48, butik, 775, 0);

        Produkt p49 = Controller.createProdukt("Julebryg, 20 liter",pg4);
        Controller.createPris(p49, butik, 775, 0);

        Produkt p50 = Controller.createProdukt("Imperial Stout, 20 liter",pg4);
        Controller.createPris(p50, butik, 775, 0);

        Produkt p51 = Controller.createProdukt("Pant",pg4);
        Controller.createPris(p51, butik, 200, 0);

        Produktgruppe pg5 = Controller.createProduktGruppe("Kulsyre",true);
        Produkt GG1 = Controller.createProdukt("4 kg",pg5);
        Controller.createPris(GG1,butik,280, 0);
        Controller.createPris(GG1,fredagsbar, 280,0);
        Produkt GG2 = Controller.createProdukt("6 kg",pg5);
        Controller.createPris(GG2,butik,420, 0);
        Controller.createPris(GG2,fredagsbar,420, 0);
        Produkt GG3 = Controller.createProdukt("10 kg",pg5);
        Controller.createPris(GG3,butik,700, 0);
        Controller.createPris(GG3,fredagsbar,700, 0);
        Produkt GG4 = Controller.createProdukt("Pant",pg5);
        Controller.createPris(GG4,butik,1000, 0);
        Controller.createPris(GG4,fredagsbar,1000, 0);


        Produktgruppe pg6 = Controller.createProduktGruppe("Malt",false);
        Produkt GG5 = Controller.createProdukt("25 kg sæk",pg6);
        Controller.createPris(GG5,butik,300, 0);


        Produktgruppe pg7 = Controller.createProduktGruppe("Beklædning",false);
        Produkt GG6 = Controller.createProdukt("T-shirt",pg7);
        Controller.createPris(GG6,butik,70, 0);
        Controller.createPris(GG6,fredagsbar,70, 0);
        Produkt GG7 = Controller.createProdukt("Polo",pg7);
        Controller.createPris(GG7,butik,100, 0);
        Controller.createPris(GG7,fredagsbar,100, 0);
        Produkt GG8 = Controller.createProdukt("Cap",pg7);
        Controller.createPris(GG8,butik,30, 0);
        Controller.createPris(GG8,fredagsbar,30, 0);

        Produktgruppe pg8 = Controller.createProduktGruppe("Anlæg",true);
        Produkt GG9 = Controller.createProdukt("1-hane",pg8);
        Controller.createPris(GG9,butik,250, 0);
        Produkt GG10 = Controller.createProdukt("2-haner",pg8);
        Controller.createPris(GG10,butik,400, 0);
        Produkt GG11 = Controller.createProdukt("Bar med flere haner",pg8);
        Controller.createPris(GG11,butik,500, 0);
        Produkt GG12 = Controller.createProdukt("Levering",pg8);
        Controller.createPris(GG12,butik,500, 0);
        Produkt GG13 = Controller.createProdukt("Krus",pg8);
        Controller.createPris(GG13,butik,60, 0);


        Produktgruppe pg9 = Controller.createProduktGruppe("Glas",false);
        Produkt GG14 = Controller.createProdukt("Glas",pg9);
        Controller.createPris(GG14,butik,15, 0);


        Produktgruppe pg10 = Controller.createProduktGruppe("Sampakninger",false);
        Produkt GG15 = Controller.createProdukt("Gaveæske med 2 øl, 2 glas",pg10);
        Controller.createPris(GG15,butik,110, 0);
        Controller.createPris(GG15,butik,110, 0);
        Produkt GG16 = Controller.createProdukt("gaveæske 4 øl",pg10);
        Controller.createPris(GG16,butik,140, 0);
        Controller.createPris(GG16,fredagsbar,140, 0);
        Produkt GG17 = Controller.createProdukt("trækasse 6 øl",pg10);
        Controller.createPris(GG17,butik,260, 0);
        Controller.createPris(GG17,fredagsbar,260, 0);
        Produkt GG18 = Controller.createProdukt("gavekurv 6 øl, 2 glas",pg10);
        Controller.createPris(GG18,butik,260, 0);
        Controller.createPris(GG18,fredagsbar,260, 0);
        Produkt GG19 = Controller.createProdukt("trækasse 6 øl, 6 glas",pg10);
        Controller.createPris(GG19,butik,350, 0);
        Controller.createPris(GG19,fredagsbar,350, 0);
        Produkt GG20 = Controller.createProdukt("trækasse 12 øl",pg10);
        Controller.createPris(GG20,butik,410, 0);
        Controller.createPris(GG20,fredagsbar,410, 0);
        Produkt GG21 = Controller.createProdukt("papkasse 12 øl",pg10);
        Controller.createPris(GG21,butik,370, 0);
        Controller.createPris(GG21,fredagsbar,370, 0);

        Produktgruppe pg11 = Controller.createProduktGruppe("Rundvisning",false);
        Produkt GG22 = Controller.createProdukt("Rundvisning",pg11);
        Controller.createPris(GG22,butik,100,0);


    }
}
