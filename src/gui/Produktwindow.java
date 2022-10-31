package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Produkt;
import model.Produktgruppe;

public class Produktwindow extends Stage{

    private String title;
    private Stage stage;

    public Produktwindow(String title, Stage owner) {
        this.title = title;
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

    }
    private final ListView<Produktgruppe> lvwProduktGruppe = new ListView<>();
    private final ListView<Produkt> lvwProdukt = new ListView<>();

    private void initContent(GridPane pane){
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblProduktGruppe = new Label("Produktgrupper");
        pane.add(lblProduktGruppe,0,0);

        Label lblProdukt = new Label("Produkter");
        pane.add(lblProdukt,1,0);

        pane.add(lvwProduktGruppe,0,1);
        pane.add(lvwProdukt,1,1);

        //Tilføj ny produktgruppe
        Button btnTilfoejProduktGruppe = new Button("Opret ny produktgruppe");
        pane.add(btnTilfoejProduktGruppe,0,2);


        //Tilføj nyt produkt
        Button btnTilfoejProdukt = new Button("Tilføj nyt produkt");
        pane.add(btnTilfoejProdukt,1,2);
        //Fjern produkt
        Button btnFjernProdukt = new Button("Fjern produkt");
        pane.add(btnFjernProdukt,1,3);

        //Rediger produkt
        Button btnRedigerProdukt = new Button("Rediger produkt");
        pane.add(btnRedigerProdukt,1,4);
    }


}
