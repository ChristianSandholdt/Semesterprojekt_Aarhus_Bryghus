package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Ordre;


public class BetalingsWindow extends Stage {

    private Ordre ordre;
    private NyOrdreWindow nyOrdreWindow;

    public BetalingsWindow(String title, Stage owner, Ordre ordre, NyOrdreWindow nyOrdreWindow) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(true);
        this.ordre = ordre;
        this.nyOrdreWindow = nyOrdreWindow;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        scene.getRoot().setStyle("-fx-font-family: monospace");
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------
    private final TextField txfPris = new TextField();
    private final TextField txfRabat = new TextField();
    private final TextField txfNyPris = new TextField();
    private final Button btnBetal = new Button("Betal");
    private final ComboBox betalingsBox = new ComboBox<>();
    private final Button btnUdregnNyPris = new Button("Udregn ny pris");
    Label lblRabat = new Label("Rabat (%):     ");
    Label lblNyPris = new Label("Ny totalpris:  ");
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // ComboBox
        HBox hboxtest = new HBox(5,betalingsBox);
        pane.add(betalingsBox, 3, 0);
        betalingsBox.setPromptText("Vælg Betaling");
        betalingsBox.getItems().add(0, "Betalingskort");
        betalingsBox.getItems().add(1, "Mobile Pay");
        betalingsBox.getItems().add(2, "Kontant");
        betalingsBox.getItems().add(3, "Klippekort");
        betalingsBox.getItems().add(4,"Regning");
        hboxtest.setMaxWidth(200);

        // Total pris
        Label lblPris = new Label("Pris:          ");
        txfPris.setMaxWidth(75);
        txfPris.setAlignment(Pos.CENTER_LEFT);
        HBox hbox = new HBox(10,lblPris,txfPris);
        hbox.setMaxWidth(200);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        pane.add(hbox, 0, 0, 2, 1);
        System.out.println("Bet: " + ordre);
        txfPris.setText(Controller.totalPris(ordre));
        txfPris.setEditable(false);

        // Rabat
        txfRabat.setMaxWidth(75);
        txfRabat.setAlignment(Pos.CENTER_RIGHT);
        HBox hbox2 = new HBox(10,lblRabat,txfRabat);
        hbox2.setMaxWidth(200);
        pane.add(hbox2, 0, 1, 2, 1);

        // Betal
        btnBetal.setAlignment(Pos.CENTER);
        btnBetal.setMaxWidth(200);
        pane.add(btnBetal, 3,1);
        btnBetal.setOnAction(event -> this.betalAction());

        // Udregn ny pris
        btnUdregnNyPris.setAlignment(Pos.CENTER);
        btnUdregnNyPris.setMaxWidth(200);
        pane.add(btnUdregnNyPris, 0, 2,2,1);
        btnUdregnNyPris.setOnAction(event -> this.udregnNyPris());

        // Ny total pris
        txfNyPris.setMaxWidth(75);
        txfNyPris.setAlignment(Pos.CENTER_RIGHT);
        HBox hBox3 = new HBox(10,lblNyPris,txfNyPris);
        hBox3.setMaxWidth(200);
        pane.add(hBox3, 0, 3,2,1);
        txfNyPris.setEditable(false);
    }

    //------------------------------------------------------------------------------------------------------------------

    private void betalAction() {
        Controller.betalOrdre(ordre, betalingsBox);
        close();
        nyOrdreWindow.close();
    }

    private void udregnNyPris() {
        double pris = Double.parseDouble(txfPris.getText());
        double rabat = Double.parseDouble(txfRabat.getText()) / 100;
        double nyPris = pris - (pris * rabat);
        String total = String.format("%.2f",nyPris);
        txfNyPris.setText(total);
    }
    
    public void hideRabat() {
        txfRabat.setVisible(false);
        lblRabat.setVisible(false);
        btnUdregnNyPris.setVisible(false);
        lblNyPris.setVisible(false);
        txfNyPris.setVisible(false);
    }

}
