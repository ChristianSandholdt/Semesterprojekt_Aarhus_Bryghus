package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.rmi.server.RemoteServer;
import java.time.LocalDate;

public class RundvisningsWindow extends Stage {

    private ReserveWindow reserveWindow;
    private String title;
    private Stage stage;

    public RundvisningsWindow(String title, Stage owner) {
        this.title = title;
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(500);
        this.setMinWidth(500);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

        reserveWindow = new ReserveWindow("Rerserver Rundvisning", stage);
    }

    private final TextField txfReservation = new TextField();
    private final Button btnReserver = new Button("Reserver");
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));

        DatePicker datePicker = new DatePicker(LocalDate.now());
        datePicker.setEditable(false);
        pane.add(datePicker, 0, 0);

        Label lblDatoValgt = new Label("Reservation");
        pane.add(lblDatoValgt, 0, 1);

        pane.add(txfReservation, 0, 2);
        txfReservation.setPrefWidth(250);
        txfReservation.setEditable(false);

        pane.add(btnReserver, 2, 2);
        btnReserver.setOnAction(event -> this.btnAction());
    }

    private void btnAction() {
        reserveWindow.update();
        reserveWindow.showAndWait();
    }
}
