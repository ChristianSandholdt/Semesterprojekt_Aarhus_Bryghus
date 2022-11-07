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

        initStorage();

        Application.launch(Gui.class);

        Produktgruppe p1 = new Produktgruppe("Øl", false);
        Controller.createProdukt("Klosterbryg",p1);
        System.out.println(p1.getProdukter());
    }

    public static void initStorage(){
        Controller.createPrisliste("Butik");
        Controller.createPrisliste("Fredagsbar");

        Produktgruppe pg1 = Controller.createProduktGruppe("Flaske",false);
        Controller.createProdukt("Klosterbryg",pg1);
        Controller.createProdukt("Sweet Georgie Brown", pg1);
        Controller.createProdukt("Extra Pilsner",pg1);
        Controller.createProdukt("Celebration",pg1);
        Controller.createProdukt("Blondie",pg1);
        Controller.createProdukt("Forårsbryg",pg1);
        Controller.createProdukt("India Pale Ale",pg1);
        Controller.createProdukt("Julebryg",pg1);
        Controller.createProdukt("Juletønden",pg1);
        Controller.createProdukt("Old Strong Ale",pg1);
        Controller.createProdukt("Fregatten Jylland",pg1);
        Controller.createProdukt("Imperial Stout",pg1);
        Controller.createProdukt("Tribute",pg1);
        Controller.createProdukt("Black Monster",pg1);

        Produktgruppe pg2 = Controller.createProduktGruppe("Fadøl 40 cl",false);
        Controller.createProdukt("Klosterbryg",pg2);
        Controller.createProdukt("Jazz Classic",pg2);
        Controller.createProdukt("Extra pilsner",pg2);
        Controller.createProdukt("Celebration",pg2);
        Controller.createProdukt("Blondie",pg2);
        Controller.createProdukt("Forårsbryg",pg2);
        Controller.createProdukt("India Pale Ale",pg2);
        Controller.createProdukt("Julebryg",pg2);
        Controller.createProdukt("Imperial Stout",pg2);
        Controller.createProdukt("Special",pg2);
        Controller.createProdukt("Æblebrus",pg2);
        Controller.createProdukt("Chips",pg2);
        Controller.createProdukt("Peanuts",pg2);
        Controller.createProdukt("Cola",pg2);
        Controller.createProdukt("Nikoline",pg2);
        Controller.createProdukt("7-Up",pg2);
        Controller.createProdukt("Vand",pg2);
        Controller.createProdukt("Ølpølser",pg2);

        Produktgruppe pg3 = Controller.createProduktGruppe("Spiritus",false);
        Controller.createProdukt("Whisky 43% 50 cl rør",pg3);
        Controller.createProdukt("u/ egesplint",pg3);
        Controller.createProdukt("m/ egesplint",pg3);
        Controller.createProdukt("2*whisky glas + brikker",pg3);
        Controller.createProdukt("Liquor of Aarhus",pg3);
        Controller.createProdukt("Lyng gin 50 cl",pg3);
        Controller.createProdukt("Lyng gin 4 cl",pg3);


        Produktgruppe pg4 = Controller.createProduktGruppe("Fustage",true);
        Controller.createProdukt("Klosterbryg, 20 liter",pg4);
        Controller.createProdukt("Jazz Classic, 25 liter",pg4);
        Controller.createProdukt("Extra Pilsner, 25 liter",pg4);
        Controller.createProdukt("Celebration, 20 liter",pg4);
        Controller.createProdukt("Blondie, 25 liter",pg4);
        Controller.createProdukt("Forårsbryg, 20 liter",pg4);
        Controller.createProdukt("India Pale Ale, 20 liter",pg4);
        Controller.createProdukt("Julebryg, 20 liter",pg4);
        Controller.createProdukt("Imperial Stout, 20 liter",pg4);
        Controller.createProdukt("Pant",pg4);

        Produktgruppe pg5 = Controller.createProduktGruppe("Kulsyre",true);
        Controller.createProdukt("4 kg",pg5);
        Controller.createProdukt("6 kg",pg5);
        Controller.createProdukt("10",pg5);
        Controller.createProdukt("Pant",pg5);

        Produktgruppe pg6 = Controller.createProduktGruppe("Malt",false);
        Controller.createProdukt("25 kg sæk",pg6);

        Produktgruppe pg7 = Controller.createProduktGruppe("Beklædning",false);
        Controller.createProdukt("T-shirt",pg7);
        Controller.createProdukt("Polo",pg7);
        Controller.createProdukt("Cap",pg7);

        Produktgruppe pg8 = Controller.createProduktGruppe("Anlæg",true);
        Controller.createProdukt("1-hane",pg8);
        Controller.createProdukt("2-haner",pg8);
        Controller.createProdukt("Bar med flere haner",pg8);
        Controller.createProdukt("Levering",pg8);
        Controller.createProdukt("Krus",pg8);

        Produktgruppe pg9 = Controller.createProduktGruppe("Glas",false);
        Controller.createProdukt("Glas",pg9);


        Produktgruppe pg10 = Controller.createProduktGruppe("Sampakninger",false);

        Controller.createProdukt("Gaveæske med 2 øl, 2 glas",pg10);
        Controller.createProdukt("gaveæske 4 øl",pg10);
        Controller.createProdukt("trækasse 6 øl",pg10);
        Controller.createProdukt("gavekurv 6 øl, 2 glas",pg10);
        Controller.createProdukt("trækasse 6 øl, 6 glas",pg10);
        Controller.createProdukt("trækasse 12 øl",pg10);
        Controller.createProdukt("papkasse 12 øl",pg10);





    }
}
