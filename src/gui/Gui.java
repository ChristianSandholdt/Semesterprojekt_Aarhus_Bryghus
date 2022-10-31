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
        stage.setScene(scene);
        stage.show();

        produktWindow = new Produktwindow("Produkter", stage);
    }

    @Override
    public void stop() {
        ListStorage.saveStorage(Controller.getStorage());
    }
    //--------------------------------------------------------------------------------

    private Produktwindow produktWindow;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        //Produkt
        Button btnProdukt = new Button("Produkter");
        btnProdukt.setMinHeight(100);
        btnProdukt.setMinWidth(120);
        pane.add(btnProdukt,0,0);

        //Ordre
        Button btnOrdre = new Button("Ny Ordre");
        btnOrdre.setMinHeight(100);
        btnOrdre.setMinWidth(120);
        pane.add(btnOrdre,1,0);

        //Statistik
        Button btnStatistik = new Button("Statistik");
        btnStatistik.setMinHeight(100);
        btnStatistik.setMinWidth(120);
        pane.add(btnStatistik,1,1);

        //Rundvisning
        Button btnRundvisning = new Button("Book Rundvisning");
        btnRundvisning.setMinHeight(100);
        btnRundvisning.setMinWidth(120);
        pane.add(btnRundvisning,0,1);
    }

    private void btnProduktAction(){
        produktWindow.showAndWait();
    }


}
