package gui;


import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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
    }

    @Override
    public void stop() {
        ListStorage.saveStorage(Controller.getStorage());
    }
    //--------------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
    }
}
