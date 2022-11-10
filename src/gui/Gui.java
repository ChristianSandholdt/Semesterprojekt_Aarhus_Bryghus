package gui;


import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.ListStorage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Aarhus Bryghus Kassesystem");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        scene.getRoot().setStyle("-fx-font-family: monospace");
        stage.setScene(scene);
        stage.show();

        produktWindow = new Produktwindow("Produkter", stage);
        ordreWindow = new NyOrdreWindow();
        rundvisningsWindow = new RundvisningsWindow("Rundvisnings Window", stage);
        statistikWindow = new StatistikWindow("Statistik", stage);
    }

    @Override
    public void stop() {
        ListStorage.saveStorage(Controller.getStorage());
    }
    //--------------------------------------------------------------------------------

    private Produktwindow produktWindow;
    private NyOrdreWindow ordreWindow;
    private RundvisningsWindow rundvisningsWindow;
    private StatistikWindow statistikWindow;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        //Produkt
        Button btnProdukt = new Button("Produkter");
        btnProdukt.setMinHeight(100);
        btnProdukt.setMinWidth(120);
        pane.add(btnProdukt, 0, 0);
        btnProdukt.setOnAction(event -> this.btnProduktAction());

        //Ordre
        Button btnOrdre = new Button("Ny Ordre");
        btnOrdre.setMinHeight(100);
        btnOrdre.setMinWidth(120);
        pane.add(btnOrdre, 1, 0);
        btnOrdre.setOnAction(event -> this.btnNyOrdreAction());

        //Statistik
        Button btnStatistik = new Button("Statistik");
        btnStatistik.setMinHeight(100);
        btnStatistik.setMinWidth(120);
        pane.add(btnStatistik, 0, 1);
        btnStatistik.setOnAction(event -> this.btnStatistiskAction());

        //Rundvisning
        Button btnRundvisning = new Button("   Book \nRundvisning");
        btnRundvisning.setMinHeight(100);
        btnRundvisning.setMinWidth(120);
        pane.add(btnRundvisning, 1, 1);
        btnRundvisning.setOnAction(event -> this.btnRundvisningAction());
    }

    private void btnProduktAction() {
        produktWindow.show();
    }

    private void btnNyOrdreAction() {
        ordreWindow.show();
    }

    private void btnRundvisningAction() {
        rundvisningsWindow.show();
    }

    private void btnStatistiskAction() {
        statistikWindow.show();
    }
}
