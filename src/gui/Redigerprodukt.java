package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Redigerprodukt extends Stage {
    private final String title;

    public Redigerprodukt(String title, Stage owner) {
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

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        //Navn
        Label lblName = new Label("Navn");
        pane.add(lblName, 0,0);

        TextField txfName = new TextField();
        pane.add(txfName,0, 1);

        //Beskrivelse
        Label lblBeskrivelse = new Label("Beskrivelse");
        pane.add(lblBeskrivelse,0,2);

        TextField txfBeskrivelse = new TextField();
        pane.add(txfBeskrivelse, 0,3);

        //Produktgruppe
        Label lblProduktGruppe = new Label("Produkgruppe");
        pane.add(lblProduktGruppe,0,4);

        ListView lvwProduktGruppe = new ListView();
        pane.add(lvwProduktGruppe,0,5);



    }


    }
