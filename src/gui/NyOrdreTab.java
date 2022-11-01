package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Ordrelinje;
import model.Produkt;
import model.Produktgruppe;

public class NyOrdreTab extends GridPane {
    private final ListView<Produktgruppe> lvwProduktGruppe = new ListView<>();
    private final ListView<Produkt> lvwProdukt = new ListView<>();
    private final ListView<Ordrelinje> lvwOrdrelinje = new ListView<>();
    private final TextField txfSum = new TextField();
    private final Label lblTotal = new Label("Total: ");

    private final Button btnAnnuller = new Button("Annuller");
    private final Button btnBetal = new Button("Betal");
    public NyOrdreTab() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblProduktGruppe = new Label("Produktgrupper:");
        this.add(lblProduktGruppe,0,0);
        lvwProduktGruppe.getItems().setAll(Controller.getStorage().getProduktgruppe());
        this.add(lvwProduktGruppe,0,1);

        ChangeListener<Produktgruppe> listener = (ov, o, n) -> this.selectedProduktgruppeChanged();
        lvwProduktGruppe.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblProdukt = new Label("Produkter:");
        this.add(lblProdukt, 1, 0);
        this.add(lvwProdukt, 1, 1);


        Label lblOrdrelinje = new Label("Kurv:");
        this.add(lblOrdrelinje, 0, 2);
        this.add(lvwOrdrelinje,0 , 3, 2, 2);

        this.add(txfSum, 0, 6);

        HBox box = new HBox(20,btnAnnuller,btnBetal);
        this.add(box, 0, 6, 2, 1);
        box.setAlignment(Pos.CENTER_RIGHT);

        HBox box2 = new HBox(10,lblTotal,txfSum);
        this.add(box2,0,6 , 2, 1);
        box2.setAlignment(Pos.CENTER_LEFT);

        btnAnnuller.setOnAction(event -> this.annullerAction());

    }
    private void annullerAction() {
    }
    private void selectedProduktgruppeChanged() {
        this.updateControls();
    }
    public void updateControls() {
        Produktgruppe produktgruppe = lvwProduktGruppe.getSelectionModel().getSelectedItem();
        if (produktgruppe != null) {

        }
    }
}
