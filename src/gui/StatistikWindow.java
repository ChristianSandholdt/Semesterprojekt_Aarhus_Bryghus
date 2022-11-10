package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StatistikWindow extends Stage {

    private String title;
    private Stage stage;

    public StatistikWindow(String title, Stage owner) {
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

        dagensSalgStatistik = new DagensSalgStatistik("Statistik over dagens salg", stage);
        udlejningsStatistikWindow = new UdlejningsStatistikWindow(this);
        klipStatistikWindow = new KlipStatistikWindow("Statistik over klippekort", stage);
    }

    private DagensSalgStatistik dagensSalgStatistik;
    private UdlejningsStatistikWindow udlejningsStatistikWindow;
    private KlipStatistikWindow klipStatistikWindow;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        //Dagens salg
        Button btnDagensSalg = new Button("Dagens salg");
        pane.add(btnDagensSalg, 0, 0);
        btnDagensSalg.setPrefHeight(100);
        btnDagensSalg.setPrefWidth(120);
        btnDagensSalg.setOnAction(event -> this.btnDagensSalgAction());

        //Statistik for klip
        Button btnKlipStatistik = new Button("Statistik\nfor klip");
        pane.add(btnKlipStatistik, 0, 1);
        btnKlipStatistik.setPrefHeight(100);
        btnKlipStatistik.setPrefWidth(120);
        btnKlipStatistik.setOnAction(event -> this.btnStatistikForKlipAction());


        //Udlejning statistik
        Button btnUdlejning = new Button("Udlejnings\nstatistik");
        pane.add(btnUdlejning, 1, 0);
        btnUdlejning.setPrefHeight(100);
        btnUdlejning.setPrefWidth(120);
        btnUdlejning.setOnAction(event -> this.btnUdlejningStatistikAction());

    }

    private void btnDagensSalgAction() {
        dagensSalgStatistik.showAndWait();
    }

    private void btnStatistikForKlipAction() {
        klipStatistikWindow.showAndWait();
    }

    private void btnUdlejningStatistikAction() {
        udlejningsStatistikWindow.update();
        udlejningsStatistikWindow.showAndWait();
    }


}


