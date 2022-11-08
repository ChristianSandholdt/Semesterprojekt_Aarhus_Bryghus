package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UdlejningsStatistikWindow extends Stage {

    private String title;
    private Stage stage;

    public UdlejningsStatistikWindow(String title, Stage owner) {
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

    public void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


    }













//    // Tilbage aflevering
//    Label lblTilbageAflevering = new Label("Tilbage Aflevering: ");
//        this.add(lblTilbageAflevering, 0, 9);
//    Label lblAnlægPant = new Label("Fustager:");
//    Label lblKulsyrePant = new Label("Kulsyre:");
//    Label lblPantRetur = new Label("Pant Retur:");
//    HBox hbox4 = new HBox(12,lblKulsyrePant,txfFustage,lblAnlægPant, txfKulsyre,lblPantRetur, txfPantRetur);
//        txfFustage.setMaxWidth(82);
//        txfKulsyre.setMaxWidth(82);
//        txfPantRetur.setMaxWidth(82);
//        this.add(hbox4, 0, 10,2,1);
//
//
//
//    Button btnUdbetal = new Button("Udbetal");
//    add(btnUdbetal, 0, 11,2,1);
//        btnUdbetal.setAlignment(Pos.CENTER);
//        btnUdbetal.setMaxWidth(500);
}
