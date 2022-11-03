package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Ordrelinje;
import model.Produkt;
import model.Produktgruppe;

import java.util.Optional;


public class UdlejningTab extends GridPane {

    private final ListView<Produktgruppe> lvwAnlæg = new ListView<>();
    private final ListView<Ordrelinje> lvwOrdreLinje = new ListView<>();
    private final ListView<Produktgruppe> lvwFustage = new ListView<>();
    private final ListView<Produkt> lvwProdukt = new ListView<>();
    private final TextField txfAntal1 = new TextField();
    private final TextField txfAntal2 = new TextField();
    private final TextField txfPris = new TextField();
    private final TextField txfPant = new TextField();
    private final TextField txfSum = new TextField();
    private final TextField txfAntalReturn = new TextField();
    private final TextField txfPantReturn = new TextField();
    private BetalingsWindow betalingsWindow;

    public UdlejningTab() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        // Label & ListView Anlæg
        Label lblAnlæg = new Label("Anlæg");
        this.add(lblAnlæg, 0, 0);
        // Indsæt shit her makker
        lvwAnlæg.getItems().setAll(Controller.getStorage().getProduktgruppe());
        this.add(lvwAnlæg, 0, 1);

        lvwAnlæg.getSelectionModel().selectFirst();

        // Label & ListView Fustage
        Label lblFustage = new Label("Fustage");
        this.add(lblFustage, 1, 0);
        // Indsæt shit her makker

        lvwFustage.getSelectionModel().selectFirst();
        this.add(lvwFustage, 1, 1);

        // Button; Increase
        Button btnIncrease1 = new Button(">");
        btnIncrease1.setOnAction(event -> this.btn1IncreaseAction());
        Button btnIncrease2 = new Button(">");
        btnIncrease2.setOnAction(event -> this.btn2IncreaseAction());

        // Button; Decrease
        Button btnDecrease1 = new Button("<");
        btnDecrease1.setOnAction(event -> this.btn1DecreaseAction());
        Button btnDecrease2 = new Button("<");
        btnDecrease2.setOnAction(event -> this.btn2DecreaseAction());

        // HBox 1
        txfAntal1.setMaxWidth(30);
        txfAntal1.setText("1");
        HBox hbox1 = new HBox(5,btnDecrease1,txfAntal1, btnIncrease1);
        this.add(hbox1, 0, 2);
        hbox1.setAlignment(Pos.CENTER);

        // HBox 2
        txfAntal2.setMaxWidth(30);
        txfAntal2.setText("1");
        HBox hbox2 = new HBox(5,btnDecrease2,txfAntal2, btnIncrease2);
        this.add(hbox2, 1, 2);
        hbox2.setAlignment(Pos.CENTER);

        // Add til kurv knap - (sat i hbox for at align i midten)
        Button btnAdd = new Button(" Tilføj til kurv ");
        HBox hbox3 = new HBox(btnAdd);
        hbox3.setAlignment(Pos.CENTER);
        this.add(hbox3, 0, 3,2,1);
        btnAdd.setOnAction(event -> this.btnTilføj());

        // Fjern fra kurv knap - (sat i hbox for at align i midten)
        Button btnRemove = new Button("Fjern fra kurv");
        HBox hbox4 = new HBox(btnRemove);
        hbox4.setAlignment(Pos.CENTER);
        btnRemove.setMaxWidth(200);
        this.add(hbox4, 0,4,2,1);
        btnRemove.setOnAction(event -> this.btnRemove());

        // Label & ListView Kurv
        Label lblKurv = new Label("Kurv");
        this.add(lblKurv, 0, 4);
        // Indsæt shit her makker

        lvwOrdreLinje.getSelectionModel().selectFirst();
        this.add(lvwOrdreLinje, 0, 5,1,2);

        // Mellemregning
//        Label lblPris = new Label("                               Pris");
//        Label lblPant = new Label("                               Pant");
//        Label lblSum = new Label("                               Sum");
        Label lblPris = new Label("        Pris:");
        Label lblPant = new Label("        Pant:");
        Label lblSum = new Label("        Sum:");

        VBox vbox1 = new VBox(10,txfPris,txfPant,txfSum);
        add(vbox1, 1, 5);
        vbox1.setAlignment(Pos.CENTER);
        txfPris.setMaxWidth(100);
        txfPant.setMaxWidth(100);
        txfSum.setMaxWidth(100);

        VBox vbox2 = new VBox(20,lblPris,lblPant,lblSum);
        add(vbox2, 1, 5);

        Button btnBetaling = new Button("Betaling");
        btnBetaling.setMaxWidth(225);
        btnBetaling.setAlignment(Pos.BOTTOM_CENTER);
        this.add(btnBetaling, 1, 6);
        btnBetaling.setOnAction(event -> this.btnÅbenBetalingAction());

        // Tilbage aflevering

        Label lblTilbageAflevering = new Label("Tilbage Aflevering");
        this.add(lblTilbageAflevering, 0, 7);
        add(txfAntalReturn, 0, 8);
        add(txfPantReturn, 0, 9);
        Label lblAntalTilbage = new Label("Antal Tilbage");
        Label lblPantTilbage = new Label("Pant Tilbage");
        lblAntalTilbage.setAlignment(Pos.BASELINE_LEFT);
        lblPantTilbage.setAlignment(Pos.BASELINE_LEFT);
        add(lblAntalTilbage, 1, 8);
        add(lblPantTilbage, 1, 9);


        Button btnUdbetal = new Button("Udbetal");
        add(btnUdbetal, 0, 10,2,1);
        btnUdbetal.setAlignment(Pos.CENTER);
        btnUdbetal.setMaxWidth(500);


        // Betalings window
        betalingsWindow = new BetalingsWindow("Betaling", new Stage());

    }

    public void updateControls() {
        Produktgruppe produktgruppe = lvwAnlæg.getSelectionModel().getSelectedItem();
        if (produktgruppe != null) {
            lvwProdukt.getItems().setAll(produktgruppe.getProdukter());
        }
    }

    // -------------------------------------------------------------------------

    // Button actions:
    private void btn1IncreaseAction() {
        int increase = Integer.parseInt(txfAntal1.getText()) + 1;
        txfAntal1.setText(Integer.toString(increase));
    }

    private void btn2IncreaseAction() {
        int increase = Integer.parseInt(txfAntal2.getText()) + 1;
        txfAntal2.setText(Integer.toString(increase));
    }

    private void btn1DecreaseAction() {
        int decrease = Integer.parseInt(txfAntal1.getText()) - 1;
        txfAntal1.setText(Integer.toString(decrease));
    }

    private void btn2DecreaseAction() {
        int decrease = Integer.parseInt(txfAntal2.getText()) - 1;
        txfAntal2.setText(Integer.toString(decrease));
    }

    private void btnÅbenBetalingAction() {
        betalingsWindow.show();
    }

    private void btnTilføj() {
        Produktgruppe produktgruppe = lvwAnlæg.getSelectionModel().getSelectedItem();
        String antal = txfAntal1.getText();
        if (produktgruppe != null) {
            Produkt p = new Produkt(antal,"",produktgruppe);
            lvwOrdreLinje.getItems().add(new Ordrelinje(Integer.parseInt(antal),p));
            txfAntal1.setText("1");
            txfAntal2.setText("1");
        }
    }

    private void btnRemove() {
        Ordrelinje ordrelinje = lvwOrdreLinje.getSelectionModel().getSelectedItem();
        if (ordrelinje != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(this.getScene().getWindow());
            alert.setTitle("Fjern varer fra kurv");
            alert.setHeaderText("Er du sikker?");
            Optional<ButtonType> resultat = alert.showAndWait();

            if (resultat.isPresent() && (resultat.get() == ButtonType.OK)) {
                lvwOrdreLinje.getItems().setAll(Controller.getStorage().getOrdrelinjer());
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(this.getScene().getWindow());
            alert.setTitle("Fjern ordrer fra kurv");
            alert.setHeaderText("Ingen ordre valgt");
            alert.setContentText("Klik på kurven for at fjerne ordrene");
            alert.show();
        }
    }
}
