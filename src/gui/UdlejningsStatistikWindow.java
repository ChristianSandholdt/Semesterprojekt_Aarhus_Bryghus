package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;

public class UdlejningsStatistikWindow extends Stage {

    private UdlejningsStatistikWindow udlejningsStatistikWindow;

    public UdlejningsStatistikWindow(StatistikWindow statistikWindow) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);


        this.setTitle("Oversigt over udlejninger");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        scene.getRoot().setStyle("-fx-font-family: monospace");
        this.setScene(scene);
    }
    // --------------------------------------------------------------------

    private ListView<Ordre> lvwUdlejninger = new ListView<>();
    private final ListView<String> lvwOrdre = new ListView<>();
    private final TextField txfFustage = new TextField();
    private final TextField txfKulsyre = new TextField();
    private final TextField txfSum = new TextField();

    public void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        // Oversigt over udlejninger
        Label lblUdlejninger = new Label("Udlejninger:");
        pane.add(lblUdlejninger, 0, 0);
        pane.add(lvwUdlejninger, 0, 1,3,5);
        lvwUdlejninger.setMaxHeight(160);
        lvwUdlejninger.getItems().setAll(Controller.visUdlejninger());
        ChangeListener<Ordre> listener = (ov, o, n) -> this.selectedOrdreLinjeChanged();
        lvwUdlejninger.getSelectionModel().selectedItemProperty().addListener(listener);


        // Oversigt over den valgte udlejning
        Label lblOrdre = new Label("Ordre:");
        pane.add(lblOrdre, 0, 6);
        Label lblPris = new Label("                   Pris:");
        pane.add(lblPris, 1, 6);
        Label lblAntal = new Label("               Antal:");
        pane.add(lblAntal, 2, 6);
        lvwOrdre.setMaxHeight(300);
        pane.add(lvwOrdre, 0, 7,4,3);
        //lvwOrdre.setMaxWidth(1000);

        lvwOrdre.getSelectionModel().selectFirst();

        // Udbetal pant
        Label lblPantRetur = new Label("Pant retur:");
        pane.add(lblPantRetur, 3, 0);
        Label lblFustager = new Label(" Fustager:    ");
        Label lblKulsyre = new Label(" Kulsyre:     ");
        Label lblSum = new Label(" Sum:         ");
        HBox hBoxFustager = new HBox(10,lblFustager,txfFustage);
        txfFustage.setAlignment(Pos.CENTER_RIGHT);
        pane.add(hBoxFustager, 3, 1);
        HBox hBoxKulsyre = new HBox(10,lblKulsyre,txfKulsyre);
        txfKulsyre.setAlignment(Pos.CENTER_RIGHT);
        pane.add(hBoxKulsyre, 3, 2);
        HBox hBoxSum = new HBox(10,lblSum,txfSum);
        txfSum.setAlignment(Pos.CENTER_RIGHT);
        pane.add(hBoxSum, 3, 3);

        // Button Udbetal - Button Annuller
        Button btnUdregn = new Button("Udregn");
        Button btnUdbetal = new Button("Udbetal");
        Button btnAnnuller = new Button("Annuller");
        HBox hBox = new HBox(5,btnUdregn,btnUdbetal);
        hBox.setMaxWidth(300);
        hBox.setAlignment(Pos.CENTER);
        pane.add(hBox, 3, 4);
        btnAnnuller.setMaxWidth(300);
        pane.add(btnAnnuller, 3, 5);
        btnAnnuller.setOnAction(event -> btnAnnullerAction());
        btnUdbetal.setOnAction(event -> btnUdbetalAction());
        btnUdregn.setOnAction(event -> btnUdregnAction());

    }

    private void selectedOrdreLinjeChanged() {
        Ordre ordre = lvwUdlejninger.getSelectionModel().getSelectedItem();
        if (ordre != null) {
            lvwOrdre.getItems().setAll(Controller.visUdlejningStatistik(ordre));
        }
    }

    // ------------------------------------------------------------------------------------------------

    private void btnAnnullerAction() {
        close();
    }

    private void btnUdregnAction() {
        Ordre ordre = lvwUdlejninger.getSelectionModel().getSelectedItem();
        String str = txfFustage.getText();
        String Str = txfKulsyre.getText();
        if (ordre != null && !str.isEmpty() && !Str.isEmpty()) {
            int antalFostager = Integer.parseInt(txfFustage.getText());
            int antalKulsyre = Integer.parseInt(txfKulsyre.getText());
            double sum = (antalFostager * 200) + (antalKulsyre * 1000);
            String total = String.format("%.2f", sum);
            txfSum.setText(total);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(this.getScene().getWindow());
            alert.setTitle("Fejl");
            alert.setHeaderText("Ingen udlejning valgt!");
            alert.setContentText("Vælg en udlejning og udfyld felterne før du kan fortsætte.");
            alert.show();
        }
    }

    private void btnUdbetalAction() {
        Ordre ordre = lvwUdlejninger.getSelectionModel().getSelectedItem();
        String str = txfSum.getText();
        if (ordre != null && !str.isEmpty()) {
            Controller.deleteOrdre(ordre);
            lvwOrdre.getItems().clear();
            lvwUdlejninger.getItems().remove(ordre);
            txfFustage.clear();
            txfKulsyre.clear();
            txfSum.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(this.getScene().getWindow());
            alert.setTitle("Fejl");
            alert.setHeaderText("Ingen udlejning valgt!");
            alert.setContentText("Vælg en ordre og udfyld felterne før du kan fortsætte.");
            alert.show();
        }
    }
    void update(){
        lvwUdlejninger.getItems().setAll(Controller.visUdlejninger());
    }

}
