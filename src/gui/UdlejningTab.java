package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;


public class UdlejningTab extends GridPane {


    private final ArrayList<Produktgruppe> produktgrupper = new ArrayList<>();
    private final ListView<Produktgruppe> lvwProduktGruppe = new ListView<>();
    private final ListView<Ordrelinje> lvwOrdreLinje = new ListView<>();
    private final ListView<Produkt> lvwProdukter = new ListView<>();
    private final TextField txfAntal = new TextField();
    private final TextField txfSum = new TextField();
    private BetalingsWindow betalingsWindow;
    private Ordre ordre;
    private Pris pris;
    private Ordrelinje ordrelinje;
    private Prisliste prisliste;

    public UdlejningTab() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        // Label & ListView Anlæg
        Label lblAnlæg = new Label("Produktgrupper: ");
        this.add(lblAnlæg, 0, 0);
        add(lvwProduktGruppe, 0, 1);
        for (Produktgruppe p : Controller.getStorage().getProduktgruppe()) {
            if (p.getUdlejning() == true) {
                produktgrupper.add(p);
                lvwProduktGruppe.getItems().setAll(produktgrupper);
            }
        }

        // Label & ListView Fustage
        Label lblFustage = new Label("Produkter: ");
        this.add(lblFustage, 1, 0);
        ChangeListener<Produktgruppe> listener = (ov, o, n) -> this.selectedProduktgruppeChanged();
        lvwProduktGruppe.getSelectionModel().selectedItemProperty().addListener(listener);
        lvwProdukter.getSelectionModel().selectFirst();
        this.add(lvwProdukter, 1, 1);

        Button btnIncrease = new Button("+");
        btnIncrease.setOnAction(event -> this.btn2IncreaseAction());

        Button btnDecrease = new Button("-");
        btnDecrease.setOnAction(event -> this.btn2DecreaseAction());

        // HBox 1
        Button btnRemove = new Button("Fjern:");
        Button btnAdd = new Button("Tilføj");
        txfAntal.setMaxWidth(30);
        txfAntal.setText("1");
        HBox hbox = new HBox(5,btnRemove,btnDecrease, txfAntal, btnIncrease,btnAdd);
        this.add(hbox, 1, 2);
        hbox.setAlignment(Pos.CENTER);
        btnRemove.setOnAction(event -> this.btnRemove());
        btnAdd.setOnAction(event -> this.btnTilføj());

        // Label & ListView Kurv
        Label lblKurv = new Label("Kurv: ");
        this.add(lblKurv, 0, 2);
        lvwOrdreLinje.getSelectionModel().selectFirst();
        lvwOrdreLinje.setMaxHeight(300);
        this.add(lvwOrdreLinje, 0, 3,2,3);

        // Total
        Label lblTotal = new Label("Total: ");
        HBox hBox3 = new HBox(10,lblTotal,txfSum);
        this.add(hBox3, 0, 7,1,1);
        hBox3.setAlignment(Pos.CENTER_LEFT);


        // Betaling + annuller
        Button btnAnnuller = new Button("Annuller");
        Button btnBetaling = new Button("Betal");
        HBox hBox = new HBox(20,btnAnnuller,btnBetaling);
        hBox.setAlignment(Pos.CENTER_RIGHT);
        this.add(hBox, 1, 7);
        btnBetaling.setOnAction(event -> this.btnÅbenBetalingAction());
    }

    private void selectedProduktgruppeChanged() {
        this.updateControlsProduktgruppe();
    }

    public void updateControls() {
        Produktgruppe produktgruppe = lvwProduktGruppe.getSelectionModel().getSelectedItem();
        if (produktgruppe != null) {
            lvwProdukter.getItems().setAll(produktgruppe.getProdukter());
        }
    }

    // -------------------------------------------------------------------------

    // Button actions:

    private void btn2IncreaseAction() {
        int increase = Integer.parseInt(txfAntal.getText()) + 1;
        txfAntal.setText(Integer.toString(increase));
    }

    private void btn2DecreaseAction() {
        int decrease = Integer.parseInt(txfAntal.getText()) - 1;
        txfAntal.setText(Integer.toString(decrease));
    }

    private void btnÅbenBetalingAction() {
        betalingsWindow = new BetalingsWindow("Betaling", new Stage(), ordre);
        betalingsWindow.show();
    }

    private void btnTilføj() {
        String betalingsform = "Betalingskort";
        int ordreID = 1;
        int antal = Integer.parseInt(txfAntal.getText().trim());
        Produkt produkt = lvwProdukter.getSelectionModel().getSelectedItem();
        if (ordre == null) {
            ordre = Controller.createOrdre(false, ordreID, LocalDate.now(),betalingsform);
            ordreID++;
        }
        prisliste = Controller.getStorage().getPrisliste().get(0);
        pris = Controller.getPris(prisliste, produkt);
        ordrelinje = Controller.createOrdrelinje(antal, produkt, pris);
        ordre.addOrdrelinje(ordrelinje);
        lvwOrdreLinje.getItems().setAll(ordre.getOrdrelinjer());
        txfAntal.setText("1");
        txfSum.setText(Controller.totalPris(ordre) + " kr.");
    }

    private void btnRemove() {
        Ordrelinje o = lvwOrdreLinje.getSelectionModel().getSelectedItem();
        int selectedID = lvwOrdreLinje.getSelectionModel().getSelectedIndex();
        if (o != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(this.getScene().getWindow());
            alert.setTitle("Fjern denne ordre fra kurv");
            alert.setHeaderText("Er du sikker?");
            Optional<ButtonType> resultat = alert.showAndWait();

            if (resultat.isPresent() && (resultat.get() == ButtonType.OK)) {
                lvwOrdreLinje.getItems().remove(selectedID);
                Controller.deleteOrdrelinje(o, ordre);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(this.getScene().getWindow());
            alert.setTitle("Fjern en ordre fra kurv");
            alert.setHeaderText("Ingen ordre valgt");
            alert.setContentText("Vælg en ordre som skal fjernes");
            alert.show();
        }
    }
    public void updateControlsProduktgruppe() {
        Produktgruppe produktgruppe = lvwProduktGruppe.getSelectionModel().getSelectedItem();
        if (produktgruppe != null) {
            lvwProdukter.getItems().setAll(produktgruppe.getProdukter());
        }
    }
}
