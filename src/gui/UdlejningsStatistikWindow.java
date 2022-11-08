package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UdlejningsStatistikWindow extends Stage {

    private StatistikWindow statistikWindow;
    private UdlejningsStatistikWindow udlejningsStatistikWindow;

    public UdlejningsStatistikWindow(StatistikWindow statistikWindow) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);
        this.statistikWindow = statistikWindow;


        this.setTitle("Oversigt over udlejninger");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }
    // --------------------------------------------------------------------

    private final ListView lvwUdlejninger = new ListView<>();
    private final ListView lvwOrdre = new ListView<>();
    private final TextField txfFustage = new TextField();
    private final TextField txfKulsyre = new TextField();
    private final TextField txfSum = new TextField();

    public void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        // Oversigt over udlejninger
        Label lblUdlejninger = new Label("Udlejninger:");
        pane.add(lblUdlejninger, 0, 0);
        pane.add(lvwUdlejninger, 0, 1,1,6);


        // Oversigt over den valgte udlejning
        Label lblOrdre = new Label("Ordre:");
        pane.add(lblOrdre, 1, 0);
        pane.add(lvwOrdre, 1, 1,1,6);

        // Udbetal pant
        Label lblPantRetur = new Label("Pant retur:");
        pane.add(lblPantRetur, 2, 0);
        Label lblFustager = new Label("Fustager:");
        Label lblKulsyre = new Label("Kulsyre:   ");
        Label lblSum = new Label("Sum:         ");
        HBox hBoxFustager = new HBox(10,lblFustager,txfFustage);
        pane.add(hBoxFustager, 2, 1);
        HBox hBoxKulsyre = new HBox(10,lblKulsyre,txfKulsyre);
        txfKulsyre.setAlignment(Pos.CENTER_RIGHT);
        pane.add(hBoxKulsyre, 2, 2);
        HBox hBoxSum = new HBox(10,lblSum,txfSum);
        txfSum.setAlignment(Pos.CENTER_RIGHT);
        pane.add(hBoxSum, 2, 3);

        // Button Udbetal - Button Annuller
        Button btnUdbetal = new Button("Udbetal");
        Button btnAnnuller = new Button("Annuller");
        pane.add(btnUdbetal, 2, 4);
        btnUdbetal.setMaxWidth(300);
        pane.add(btnAnnuller, 2, 5);
        btnAnnuller.setMaxWidth(300);
        btnAnnuller.setOnAction(event -> btnAnnullerAction());
        btnUdbetal.setOnAction(event -> btnUdbetalAction());

        // --------------------------------------------------------------------
    }

    private void btnUdbetalAction() {

    }

    private void btnAnnullerAction() {
        udlejningsStatistikWindow.close();
        statistikWindow.close();
    }
}
