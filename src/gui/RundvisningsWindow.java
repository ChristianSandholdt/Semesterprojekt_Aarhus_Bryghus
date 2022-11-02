package gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.DatePickerSkin;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;

public class RundvisningsWindow extends Stage {

    private String title;

    public RundvisningsWindow(String title, Stage owner) {
        this.title = title;
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(500);
        this.setMinWidth(500);
        this.setResizable(true);

        this.setTitle(title);
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private final TextField txfReservation = new TextField();
    private final Button btnReserver = new Button("Reserver");
    private void initContent(BorderPane pane) {
        pane.setPadding(new Insets(40));

        DatePicker datePicker = new DatePicker(LocalDate.now());
        DatePickerSkin datePickerSkin = new DatePickerSkin(new DatePicker(LocalDate.now()));
        Node popupContent = datePickerSkin.getPopupContent();

        pane.setTop(popupContent);

        Label lblDatoValgt = new Label("Reservation");
        pane.setLeft(lblDatoValgt);

        pane.setCenter(txfReservation);
        txfReservation.setPrefWidth(500);
        datePicker.valueProperty().addListener(
                (observable, oldValue, newValue) ->
                        System.out.println("" + oldValue + newValue));

        pane.setRight(btnReserver);
    }
}
