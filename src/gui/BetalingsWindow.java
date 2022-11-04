package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
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
    private final TextField txfSiu = new TextField();
    private final TextField txfPris = new TextField();
    private final TextField txfRabat = new TextField();


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Siu
      //  Label lblTitel = new Label("Siu");
       // pane.add(lblTitel, 0, 0);



        // ComboBox
        ComboBox comboBox = new ComboBox<>();
       // pane.add(comboBox, 1, 0);
     //   comboBox.setMaxWidth(200);
        HBox hboxtest = new HBox(5,comboBox);
        pane.add(comboBox, 1, 0);
        hboxtest.setMaxWidth(200);


        // Total pris
        Label lblPris = new Label("Pris:     ");
        txfPris.setMaxWidth(50);
        HBox hbox = new HBox(5,lblPris,txfPris);
        hbox.setMaxWidth(200);
        pane.add(hbox, 0, 0);


        // Rabat
        Label lblRabat = new Label("Rabat:");
        txfRabat.setMaxWidth(50);
        HBox hbox2 = new HBox(5,lblRabat,txfRabat);
        hbox2.setMaxWidth(200);
        pane.add(hbox2, 0, 1);










        // -------------------------------------------------------------------------

        // Button actions

    }
}
