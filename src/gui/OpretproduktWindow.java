package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Prisliste;
import model.Produkt;
import model.Produktgruppe;

public class OpretproduktWindow extends Stage {

    private String title;
    private Stage stage;

    public OpretproduktWindow(String title, Stage owner) {
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
        scene.getRoot().setStyle("-fx-font-family: monospace");
        this.setScene(scene);
    }

    private final TextField txfNavn = new TextField();

    private final ListView<Produktgruppe> lvwProduktGruppe = new ListView<>();

    private final TextField txfpris = new TextField();

    private final ComboBox<Prisliste> cbxPrisliste = new ComboBox<>();

    private final ComboBox<Integer> cbxPrisIKlip = new ComboBox<>();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNavn = new Label("Navn");
        pane.add(lblNavn, 0, 0);
        pane.add(txfNavn, 0, 1);
        txfNavn.setEditable(true);


        pane.add(lvwProduktGruppe, 0, 4);
        lvwProduktGruppe.getItems().setAll(Controller.getStorage().getProduktgruppe());

        Label lblPrisliste = new Label("Prisliste");
        pane.add(lblPrisliste, 0, 5);
        pane.add(cbxPrisliste, 0, 6);
        cbxPrisliste.getItems().setAll(Controller.getStorage().getPrisliste());
        cbxPrisliste.setPromptText("Vælg prisliste");

        Label lblPris = new Label("Pris");
        pane.add(lblPris, 0, 7);
        pane.add(txfpris, 0, 8);

        Label lblPrisIKlip = new Label("Pris i klip");
        pane.add(lblPrisIKlip, 0, 9);
        pane.add(cbxPrisIKlip, 0, 10);
        cbxPrisIKlip.setPromptText("Vælg antal klip");
        for (int i = 1; i < 5; i++) {
            cbxPrisIKlip.getItems().addAll(i);
        }


        Button btnOpret = new Button("Opret");
        pane.add(btnOpret, 0, 11);
        btnOpret.setOnAction(event -> btnOpretProduktAction());
    }

    private void btnOpretProduktAction() {
        String navn = txfNavn.getText().trim();
        Produkt p1 = Controller.createProdukt(navn, lvwProduktGruppe.getSelectionModel().getSelectedItem());
        Controller.createPris(p1, cbxPrisliste.getSelectionModel().getSelectedItem(),
                Integer.parseInt(txfpris.getText()), cbxPrisIKlip.getSelectionModel().getSelectedItem());
        txfNavn.clear();
        txfpris.clear();
        close();

    }

    public void update() {
        lvwProduktGruppe.getItems().clear();
        lvwProduktGruppe.getItems().addAll(Controller.getStorage().getProduktgruppe());
    }


}
