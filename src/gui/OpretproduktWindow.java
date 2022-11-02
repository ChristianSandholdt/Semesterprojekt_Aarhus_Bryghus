package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
        this.setScene(scene);
    }

    private final TextField txfNavn = new TextField();

    private final TextField txfBeskrivelse = new TextField();

    private final ListView<Produktgruppe> lvwProduktGruppe = new ListView<>();
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNavn = new Label("Navn");
        pane.add(lblNavn,0,0);
        pane.add(txfNavn,0,1);
        txfNavn.setEditable(true);

        Label lblBeskrivelse = new Label("Beskrivelse");
        pane.add(lblBeskrivelse,0,2);
        pane.add(txfBeskrivelse,0,3);
        txfBeskrivelse.setEditable(true);

        ListView<Produktgruppe> lvwProduktGruppe = new ListView<>();
        pane.add(lvwProduktGruppe,0,4);
        lvwProduktGruppe.getItems().setAll(Controller.getStorage().getProduktgruppe());


        Button btnOpret = new Button("Opret");
        pane.add(btnOpret,0,5);
        btnOpret.setOnAction(event -> btnOpretProduktAction());

    }

    private void btnOpretProduktAction(){
        String navn = txfNavn.getText().trim();
        String beskrivelse = txfBeskrivelse.getText().trim();
        if (lvwProduktGruppe.getSelectionModel().getSelectedItem() == null){
            return;
        }
        Controller.createProdukt(navn,beskrivelse, lvwProduktGruppe.getSelectionModel().getSelectedItem());
        close();
    }

    public void update(){
        lvwProduktGruppe.getItems().setAll(Controller.getStorage().getProduktgruppe());
    }


}
