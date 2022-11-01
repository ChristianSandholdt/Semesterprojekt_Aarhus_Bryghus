package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import model.Ordrelinje;
import model.Produkt;
import model.Produktgruppe;

public class NyOrdreTab extends GridPane {
    private final ListView<Produktgruppe> lvwProduktGruppe = new ListView<>();
    private final ListView<Produkt> lvwProdukt = new ListView<>();
    private final ListView<Ordrelinje> lvwOrdrelinje = new ListView<>();
    private final Button btnBetal = new Button("Betal");
    public NyOrdreTab() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblProduktGruppe = new Label("Produktgrupper");
        this.add(lblProduktGruppe,0,0);
        lvwProduktGruppe.getItems().setAll(Controller.getStorage().getProduktgruppe());
        lvwProduktGruppe.getSelectionModel().selectedIndexProperty().addListener(observable -> {
            lvwProdukt.getItems().setAll(
                    lvwProduktGruppe.getSelectionModel().getSelectedItem().getProdukter());
        });
        lvwProduktGruppe.getSelectionModel().selectFirst();

        this.add(lvwProduktGruppe,0,1);

        Label lblProdukt = new Label("Produkter i gruppe");
        this.add(lblProdukt, 1, 0);
        this.add(lvwProdukt, 1, 1);
        lvwProdukt.getSelectionModel().selectedItemProperty().addListener(observable -> {
           // lvwOrdrelinje.getItems().add(lvwProdukt.getSelectionModel().getSelectedItem().getNavn());
        });

        Label lblOrdrelinje = new Label("Vare i ordre:");
        this.add(lblOrdrelinje, 0, 2);
        this.add(lvwOrdrelinje,0 , 3, 2, 2);


        this.add(btnBetal, 0, 6);
    }



    public void updateControls() {
    }
}
