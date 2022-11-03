package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class BetalingsWindow extends Stage {

    public BetalingsWindow(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(true);


        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

    }

    // -------------------------------------------------------------------------
    private final TextField txfKortnummer = new TextField();
    private final TextField txfMåned = new TextField();
    private final TextField txfDato = new TextField();
    private final TextField txfCVV = new TextField();


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Kortnummer
        Label lblKortnr = new Label("Kortnummer: ");
        pane.add(lblKortnr, 0, 0);
        pane.add(txfKortnummer, 0, 1,2,1);
        txfKortnummer.setMaxWidth(400);


        // Udløbsdato
        Label lblUdløbsdato = new Label("Udløbsdato: ");
        pane.add(lblUdløbsdato, 0, 2);
        HBox hbox1 = new HBox(5,txfMåned,txfDato);
        hbox1.setAlignment(Pos.BASELINE_LEFT);
        hbox1.setMaxWidth(75);
        pane.add(hbox1, 0, 3);

        // CVV
        Label lblCVV = new Label("CVV:");
        pane.add(lblCVV, 1, 2);
        pane.add(txfCVV, 1, 3);


        // Checkbox
        Label lblStuderende = new Label("Studerende: ");
        //pane.add(lblStuderende, 1,0);
        CheckBox cbStuderende = new CheckBox();
        //pane.add(cbStuderende, 1, 0);
        //cbStuderende.setAlignment(Pos.CENTER)
        HBox hbox2 = new HBox(5,lblStuderende,cbStuderende);
        pane.add(hbox2, 1, 0);

        // Betalingsknap
        Button btnBetal = new Button("Betal");
        pane.add(btnBetal, 0, 4);

        // klippekort?
        Label lblKlippekort = new Label("Klippekort");
        CheckBox cbKlippekort = new CheckBox();
        HBox hbox3 = new HBox(5,lblKlippekort,cbKlippekort);
        pane.add(hbox3,   1, 4);



        // -------------------------------------------------------------------------

        // Button actions

    }
}
