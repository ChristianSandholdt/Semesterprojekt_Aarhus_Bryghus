package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Produkt;
import model.Produktgruppe;

public class Produktwindow extends Stage{


    private OpretproduktWindow opretproduktWindow;
    private OpretproduktgruppeWindow opretproduktgruppe;
    private String title;
    private Stage stage;


    public Produktwindow(String title, Stage owner) {
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
        this.setScene(scene);
        opretproduktgruppe = new OpretproduktgruppeWindow("Opret produktgruppe", stage);
        opretproduktWindow = new OpretproduktWindow("Opret produkt", stage);

    }
    private final ListView<Produktgruppe> lvwProduktGruppe = new ListView<>();
    private final ListView<Produkt> lvwProdukt = new ListView<>();
    private final Button btnFjernProduktGruppe = new Button();

    private void initContent(GridPane pane){
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblProduktGruppe = new Label("Produktgrupper");
        pane.add(lblProduktGruppe,0,0);

        Label lblProdukt = new Label("Produkter");
        pane.add(lblProdukt,1,0);

        pane.add(lvwProduktGruppe,0,1);
        //Lidt i tvivl om linjen herunder virker
        lvwProduktGruppe.getItems().setAll(Controller.getStorage().getProduktgruppe());

        pane.add(lvwProdukt,1,1);

        //Tilføj ny produktgruppe
        Button btnTilfoejProduktGruppe = new Button("Opret ny produktgruppe");
        pane.add(btnTilfoejProduktGruppe,0,2);
        btnTilfoejProduktGruppe.setOnAction(event -> this.btnOpretProduktGruppeAction());

        //Fjern produktgruppe
        Button btnFjernProduktGruppe = new Button("Fjern produktgruppe");
        pane.add(btnFjernProduktGruppe,0,3);
        btnFjernProduktGruppe.setOnAction(event -> btnFjernProduktGruppeAction());

        //Listener til produktgruppe
        ChangeListener<Produktgruppe> listener =
                (obs, o, n) -> this.selectedProduktGruppeChanged();
        lvwProduktGruppe.getSelectionModel().selectedItemProperty().addListener(listener);

        //Tilføj nyt produkt
        Button btnTilfoejProdukt = new Button("Tilføj nyt produkt");
        pane.add(btnTilfoejProdukt,1,2);
        btnTilfoejProdukt.setOnAction(event -> btnOpretProduktAction());

        //Fjern produkt
        Button btnFjernProdukt = new Button("Fjern produkt");
        pane.add(btnFjernProdukt,1,3);

        //Rediger produkt
        Button btnRedigerProdukt = new Button("Rediger produkt");
        pane.add(btnRedigerProdukt,1,4);
    }

    private void btnOpretProduktGruppeAction(){
        opretproduktgruppe.showAndWait();
        lvwProduktGruppe.getItems().setAll(Controller.getStorage().getProduktgruppe());
    }
    private void btnFjernProduktGruppeAction(){
        Produktgruppe produktgruppe = lvwProduktGruppe.getSelectionModel().getSelectedItem();
        if (produktgruppe == null){
            return;
        }
        for (Produktgruppe p : lvwProduktGruppe.getItems()){
            if (p.getProdukter().size() > 0){
                p.getProdukter().removeAll(p.getProdukter());
            }
        }
        Controller.deleteProduktGruppe(produktgruppe);
        btnFjernProduktGruppe.setDisable(true);
        lvwProduktGruppe.getItems().setAll(Controller.getStorage().getProduktgruppe());
    }

    private void btnOpretProduktAction(){
        opretproduktWindow.showAndWait();
        opretproduktWindow.update();
    }

    private void fillProduktList(Produktgruppe produktgruppe){
        lvwProdukt.getItems().clear();
        lvwProdukt.getItems().addAll(produktgruppe.getProdukter());
    }

    private void selectedProduktGruppeChanged(){
        Produktgruppe selectedItem = lvwProduktGruppe.getSelectionModel().getSelectedItem();
        if (selectedItem != null){
            this.fillProduktList(selectedItem);
        }
    }






}
