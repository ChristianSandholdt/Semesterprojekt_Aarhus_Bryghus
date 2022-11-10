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
import java.util.Optional;

public class NyOrdreTab extends GridPane {

    private Prisliste prisliste;
    private Pris pris;
    public static Ordre ordre;
    private BetalingsWindow betalingsWindow;
    private Ordrelinje ordrelinje;
    private NyOrdreWindow nyOrdreWindow;
    private final ComboBox<Prisliste> cbxPrisliste = new ComboBox<>();
    private final ListView<Produktgruppe> lvwProduktGruppe = new ListView<>();
    private final ListView lvwProdukt = new ListView<>();
    private final ListView lvwOrdrelinje = new ListView<>();
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

        // Dropdown-menu med prisliste
        Label lblPrisListe = new Label("Prisliste: ");
        HBox prisBox = new HBox(2, lblPrisListe, cbxPrisliste);
        this.add(prisBox, 0,0,2,1);
        cbxPrisliste.setPromptText("Vælg Prisliste: ");
        cbxPrisliste.getItems().addAll(Controller.getStorage().getPrisliste());
        cbxPrisliste.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) ->
        {
            prisliste = newValue;
            this.selectedPrisListeChanged();
        });

        // Produktgrupper listview
        Label lblProduktGruppe = new Label("Produktgrupper:");
        this.add(lblProduktGruppe, 0, 1);
        this.add(lvwProduktGruppe, 0, 2);

        ChangeListener<Produktgruppe> listener = (ov, o, n) -> this.selectedProduktgruppeChanged();
        lvwProduktGruppe.getSelectionModel().selectedItemProperty().addListener(listener);

        // Produkter til tilhørende gruppe listview
        Label lblProdukt = new Label("Produkter:");
        this.add(lblProdukt, 1, 1);
        this.add(lvwProdukt, 1, 2);

        // Antal under produkter
        txfAntal.setMaxWidth(30);
        txfAntal.setText("1");
        txfAntal.setAlignment(Pos.CENTER);
        HBox hbox1 = new HBox(5,btnFjern, btnDecrease, txfAntal, btnIncrease, btnTilføj);
        this.add(hbox1, 1, 3);
        hbox1.setAlignment(Pos.CENTER);

        btnIncrease.setOnAction(event -> this.btnIncreaseAction());
        btnDecrease.setOnAction(event -> this.btnDecreaseAction());
        btnTilføj.setOnAction(event -> this.tilføjAction());
        btnFjern.setOnAction(event -> this.fjernAction());

        // Listview af ordrelinjer "kurv"
        Label lblOrdrelinje = new Label("Kurv:");
        this.add(lblOrdrelinje, 0, 3);
        this.add(lvwOrdrelinje, 0, 4, 2, 2);

        // Textfield med totalpris af vare i ordrelinjer fra kurv listview
        this.add(txfSum, 0, 7);
        HBox box2 = new HBox(10, lblTotal, txfSum);
        this.add(box2, 0, 7, 1, 1);
        box2.setAlignment(Pos.CENTER_LEFT);

        // Annuller og betal knapper
        HBox box = new HBox(20, btnAnnuller, btnBetal);
        this.add(box, 1, 7, 1, 1);
        box.setAlignment(Pos.CENTER_RIGHT);
        btnBetal.setOnAction(event -> this.betalAction());
        btnAnnuller.setOnAction(event -> this.annullerAction());

        //Vindue til betaling
        //betalingsWindow = new BetalingsWindow("Betaling", new Stage());
    }

    // Finder og indsætter prislister og viser relevante produktgrupper
    private void selectedPrisListeChanged() {
        lvwProduktGruppe.getItems().clear();
        for (Produktgruppe p : Controller.getStorage().getProduktgruppe()){
            if (p.getPrislister().contains(prisliste) && !p.getUdlejning()){
                lvwProduktGruppe.getItems().add(p);
            }
        }
    }

    // Annuller button - Lukker NyOrdreVindue
    private void annullerAction() {
        lvwProduktGruppe.getItems().clear();
        lvwProdukt.getItems().clear();
        lvwOrdrelinje.getItems().clear();
        txfSum.clear();
        ordre = null;
        nyOrdreWindow.close();
    }

    // Til at opdatere produkter når man vælger ny produktgruppe
    private void selectedProduktgruppeChanged() {
        this.updateControlsProduktgruppe();
    }


    // Tilføj vare til kurven
    public void tilføjAction() {
        String betalingsform = "Betalingskort";
        Produktgruppe produktgruppe = lvwProduktGruppe.getSelectionModel().getSelectedItem();
        int antal = Integer.parseInt(txfAntal.getText().trim());
        Produkt produkt = null;
        if (produktgruppe.toString().equals("Rundvisning")){
            produkt = produktgruppe.getProdukter().get(0);
        } else {
            produkt = (Produkt) lvwProdukt.getSelectionModel().getSelectedItem();
        }
        double ordreID = Math.random() * 1000000;
        ordreID = Math.floor(ordreID);
        if (ordre == null){
            ordre = Controller.createOrdre(false, ordreID, LocalDate.now(),betalingsform);
        }
        pris = Controller.getPris(prisliste, produkt);
        ordrelinje = Controller.createOrdrelinje(antal, produkt, pris);
        ordre.addOrdrelinje(ordrelinje);
        lvwOrdrelinje.getItems().setAll(ordre.getOrdrelinjer());
        txfAntal.setText("1");
        System.out.println("Ny: " + ordre);
        txfSum.setText(Controller.totalPris(ordre) + " kr.");
    }

    // Action til at åbne betalingsvindue
    private void betalAction() {
        betalingsWindow = new BetalingsWindow("Betaling", new Stage(), ordre, nyOrdreWindow);
        betalingsWindow.showAndWait();
        txfSum.clear();
        lvwOrdrelinje.getItems().clear();
        txfSum.setText(Controller.resetPris());
        ordre = null;
    }

    // Fjerner vare fra kurven
    private void fjernAction() {
        Ordrelinje o = (Ordrelinje) lvwOrdrelinje.getSelectionModel().getSelectedItem();
        if (o != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(this.getScene().getWindow());
            alert.setTitle("Fjern vare fra kurv");
            alert.setHeaderText("Er du sikker?");
            Optional<ButtonType> resultat = alert.showAndWait();

            if (resultat.isPresent() && (resultat.get() == ButtonType.OK)) {
                lvwOrdrelinje.getItems().remove(o);
                Controller.deleteOrdrelinje(o, ordre);
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

    // Opdatere produkt listview med relaterede produkter når der skiftes produktgruppe
    public void updateControlsProduktgruppe() {
        Produktgruppe produktgruppe = lvwProduktGruppe.getSelectionModel().getSelectedItem();
        if (produktgruppe != null) {
            lvwProdukt.getItems().setAll(produktgruppe.getProdukter());
            if (produktgruppe.toString().equals("Rundvisning")){
                lvwProdukt.getItems().setAll(Controller.getStorage().getRundvisning());
            }
        }
    }

    // Lægger 1 til antal
    private void btnIncreaseAction() {
        int increase = Integer.parseInt(txfAntal.getText()) + 1;
        txfAntal.setText(Integer.toString(increase));
    }

    // Trækker 1 fra antal
    private void btnDecreaseAction() {
        int decrease = Integer.parseInt(txfAntal.getText()) - 1;
        txfAntal.setText(Integer.toString(decrease));
    }
}
