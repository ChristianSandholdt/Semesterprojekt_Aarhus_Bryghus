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

    private final Ordre ordre;

    public BetalingsWindow(String title, Stage owner, Ordre ordre) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(true);
        this.ordre = ordre;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------
    private final TextField txfPris = new TextField();
    private final TextField txfRabat = new TextField();
    private final Button btnBetal = new Button("Betal");
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // ComboBox
        ComboBox betalingsBox = new ComboBox<>();
        HBox hboxtest = new HBox(5,betalingsBox);
        pane.add(betalingsBox, 3, 0);
        betalingsBox.setPromptText("Vælg Betaling");
        betalingsBox.getItems().add(0, "Betalingskort");
        betalingsBox.getItems().add(1, "Mobile Pay");
        betalingsBox.getItems().add(2, "Kontant");
        betalingsBox.getItems().add(3, "Klippekort");
        hboxtest.setMaxWidth(200);

        // Total pris
        Label lblPris = new Label("Pris:  ");
        txfPris.setMaxWidth(50);
        HBox hbox = new HBox(10,lblPris,txfPris);
        hbox.setMaxWidth(200);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        pane.add(hbox, 0, 0, 2, 1);
        System.out.println("Bet: " +ordre);
        txfPris.setText(Controller.totalPris(ordre));

        // Rabat
        Label lblRabat = new Label("Rabat:");
        txfRabat.setMaxWidth(50);
        HBox hbox2 = new HBox(10,lblRabat,txfRabat);
        hbox2.setMaxWidth(200);
        pane.add(hbox2, 0, 1, 2, 1);

        // Betal
        pane.add(btnBetal, 3,1);
        btnBetal.setOnAction(event -> this.betalAction());
    }

    private void betalAction() {
        ordre.setBetalt(true);
        close();
    }
}
