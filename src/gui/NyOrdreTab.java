package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Ordre;
import model.Ordrelinje;
import model.Produkt;
import model.Produktgruppe;
import java.util.Optional;

public class NyOrdreTab extends GridPane {

    private Ordre ordre;
    private Ordrelinje ordrelinje;
    private NyOrdreWindow nyOrdreWindow;
    private final ListView<Produktgruppe> lvwProduktGruppe = new ListView<>();
    private final ListView<Produkt> lvwProdukt = new ListView<>();
    private final ListView<Ordrelinje> lvwOrdrelinje = new ListView<>();
    private TextField txfSum = new TextField();
    private TextField txfAntal = new TextField();
    private final Label lblTotal = new Label("Total: ");
    private final Button btnAnnuller = new Button("Annuller");
    private final Button btnBetal = new Button("Betal");
    private final Button btnDecrease = new Button("-");
    private final Button btnIncrease = new Button("+");
    private final Button btnTilføj = new Button("Tilføj");
    private final Button btnFjern = new Button("Fjern");

    public NyOrdreTab(NyOrdreWindow nyOrdreWindow) {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);
        this.nyOrdreWindow = nyOrdreWindow;

        Label lblProduktGruppe = new Label("Produktgrupper:");
        this.add(lblProduktGruppe, 0, 0);
        this.add(lvwProduktGruppe, 0, 1);
        lvwProduktGruppe.getItems().setAll(Controller.getStorage().getProduktgruppe());

        ChangeListener<Produktgruppe> listener = (ov, o, n) -> this.selectedProduktgruppeChanged();
        lvwProduktGruppe.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblProdukt = new Label("Produkter:");
        this.add(lblProdukt, 1, 0);
        this.add(lvwProdukt, 1, 1);

        txfAntal.setMaxWidth(30);
        txfAntal.setText("1");
        txfAntal.setAlignment(Pos.CENTER);
        HBox hbox1 = new HBox(5,btnFjern, btnDecrease, txfAntal, btnIncrease, btnTilføj);
        this.add(hbox1, 1, 2);
        hbox1.setAlignment(Pos.CENTER);

        btnIncrease.setOnAction(event -> this.btnIncreaseAction());
        btnDecrease.setOnAction(event -> this.btnDecreaseAction());
        btnTilføj.setOnAction(event -> this.tilføjAction());
        btnFjern.setOnAction(event -> this.fjernAction());
        
        Label lblOrdrelinje = new Label("Kurv:");
        this.add(lblOrdrelinje, 0, 2);
        this.add(lvwOrdrelinje, 0, 3, 2, 2);

        this.add(txfSum, 0, 6);

        HBox box = new HBox(20, btnAnnuller, btnBetal);
        this.add(box, 1, 6, 1, 1);
        box.setAlignment(Pos.CENTER_RIGHT);
        btnAnnuller.setOnAction(event -> this.annullerAction());

        HBox box2 = new HBox(10, lblTotal, txfSum);
        this.add(box2, 0, 6, 1, 1);
        box2.setAlignment(Pos.CENTER_LEFT);


    }

    private void annullerAction() {
        lvwProdukt.getItems().clear();
        lvwOrdrelinje.getItems().clear();
        txfSum.clear();
        nyOrdreWindow.hide();

    }

    private void selectedProduktgruppeChanged() {
        this.updateControlsProduktgruppe();
    }


    public void tilføjAction() {
        int ordreID = 1;
        int antal = Integer.parseInt(txfAntal.getText().trim());
        Produkt produkt = lvwProdukt.getSelectionModel().getSelectedItem();
        if (ordre == null) {
            ordre = Controller.createOrdre(false, ordreID);
            ordreID++;
        }
        ordrelinje = Controller.createOrdrelinje(antal, produkt);
        ordre.addOrdrelinje(ordrelinje);
        lvwOrdrelinje.getItems().setAll(ordre.getOrdrelinjer());
        txfAntal.setText("1");



    }

    private void fjernAction() {
        Produktgruppe produktgruppe = lvwProduktGruppe.getSelectionModel().getSelectedItem();
        Ordrelinje o = lvwOrdrelinje.getSelectionModel().getSelectedItem();
        if (o != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(this.getScene().getWindow());
            alert.setTitle("Fjern vare fra kurv");
            alert.setHeaderText("Er du sikker?");
            Optional<ButtonType> resultat = alert.showAndWait();

            if (resultat.isPresent() && (resultat.get() == ButtonType.OK)) {
                Controller.deleteProduktGruppe(produktgruppe);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(this.getScene().getWindow());
            alert.setTitle("Fjern ordre fra kurv");
            alert.setHeaderText("Ingen ordre valgt");
            alert.setContentText("Vælg en ordre som skal fjernes");
            alert.show();
        }
    }

    public void updateControlsProduktgruppe() {
        Produktgruppe produktgruppe = lvwProduktGruppe.getSelectionModel().getSelectedItem();
        if (produktgruppe != null) {
            lvwProdukt.getItems().setAll(produktgruppe.getProdukter());
        }
    }

    private void btnIncreaseAction() {
        int increase = Integer.parseInt(txfAntal.getText()) + 1;
        txfAntal.setText(Integer.toString(increase));
    }

    private void btnDecreaseAction() {
        int decrease = Integer.parseInt(txfAntal.getText()) - 1;
        txfAntal.setText(Integer.toString(decrease));
    }
}
