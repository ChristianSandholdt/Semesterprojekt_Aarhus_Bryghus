package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OpretproduktgruppeWindow extends Stage {

    private String title;
    private Stage stage;

    public OpretproduktgruppeWindow(String title, Stage owner) {
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
    private final TextField txfType = new TextField();

    private void initContent(GridPane pane){
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNavn = new Label("Navn på produktgruppe");
        pane.add(lblNavn,0,0);
        pane.add(txfNavn,0,1);
        txfNavn.setEditable(true);

        Label lblType = new Label("Type på produktgruppe");
        pane.add(lblType,0,2);
        pane.add(txfType,0,3);
        txfType.setEditable(true);

        Button btnOpret = new Button("Opret");
        pane.add(btnOpret,0,4);
        btnOpret.setOnAction(event -> btnOpretAction());

    }

    private void btnOpretAction(){
        String navn = txfNavn.getText();
        String type = txfType.getText();
        Controller.createProduktGruppe(navn,type);
        txfNavn.clear();
        txfType.clear();
        close();

    }


}