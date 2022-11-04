package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import controller.Controller;
import javafx.util.Callback;
import model.Rundvisning;

import java.time.LocalDate;

public class RundvisningsWindow extends Stage {

    private String title;
    private LocalDate date;

    public RundvisningsWindow(String title, Stage owner) {
        this.title = title;
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(250);
        this.setMinWidth(250);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private final TextField txfNavn = new TextField();
    private final TextField txfEmail = new TextField();
    private final TextField txfTlf = new TextField();
    private final TextField txfAntalPersoner = new TextField();
    private final TextField txfDato = new TextField();
    private final TextField txfStartTid = new TextField();
    private final TextField txfSlutTid = new TextField();
    private final Button btnReserver = new Button("Reserver");
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(30));
        pane.setHgap(10);
        pane.setVgap(10);

        DatePicker datePicker = new DatePicker(LocalDate.now());
        datePicker.setEditable(false);
        HBox dateBox = new HBox(datePicker);
        pane.add(dateBox, 0, 0, 2, 1);
        dateBox.setAlignment(Pos.CENTER);

        datePicker.setDayCellFactory(new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(DatePicker param) {
                return new DateCell(){
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            for (Rundvisning r : Controller.getStorage().getRundvisning()){
                                if (item.equals(r.getDato())){
                                    this.setStyle("-fx-background-color: pink");
                                }
                            }
                        }
                    }
                };
            }
        });

        Label lblNavn = new Label("Navn");
        pane.add(lblNavn, 0,3);
        pane.add(txfNavn, 0, 4);

        Label lblEmail = new Label("Email");
        pane.add(lblEmail, 1, 3);
        pane.add(txfEmail, 1, 4);

        Label lblTlf = new Label("Telefon Nummer");
        HBox lblBox = new HBox(lblTlf);
        HBox tlfBox = new HBox(txfTlf);
        pane.add(lblBox, 0, 5, 2, 1);
        pane.add(tlfBox, 0, 6, 2, 1);
        lblBox.setAlignment(Pos.CENTER);
        tlfBox.setAlignment(Pos.CENTER);

        Label lblAntalPersoner = new Label("Antal Personer");
        pane.add(lblAntalPersoner, 0, 7);
        pane.add(txfAntalPersoner, 0, 8);

        Label lblDato = new Label("Dato");
        pane.add(lblDato, 1, 7);
        pane.add(txfDato, 1, 8);
        txfDato.setEditable(false);
        datePicker.valueProperty().addListener((ov, oldValue, newValue) -> {
            txfDato.setText("" + newValue);
            date = newValue;
            this.reservationsDatoValgt();
        });

        Label lblStartTid = new Label("Start Tid");
        pane.add(lblStartTid, 0, 9);
        pane.add(txfStartTid, 0, 10);

        Label lblSluttid = new Label("Slut Tid");
        pane.add(lblSluttid, 1, 9);
        pane.add(txfSlutTid, 1, 10);

        pane.add(btnReserver, 0, 11);
        btnReserver.setOnAction(event -> btnReserverAction());
    }

    private void btnReserverAction() {
        String navn = txfNavn.getText();
        String email = txfEmail.getText();
        int tlfNummer = Integer.parseInt(txfTlf.getText());
        int antalPersoner = Integer.parseInt(txfAntalPersoner.getText());
        String startTid = txfStartTid.getText();
        String slutTid = txfSlutTid.getText();
        Controller.createRundvisning(navn,email,tlfNummer,0,antalPersoner,date,startTid, slutTid);
    }

    private void reservationsDatoValgt() {
        txfNavn.clear();
        txfEmail.clear();
        txfTlf.clear();
        txfAntalPersoner.clear();
        txfStartTid.clear();
        txfSlutTid.clear();
        for (Rundvisning r : Controller.getStorage().getRundvisning()){
            if (date.equals(r.getDato())){
                txfNavn.setText(r.getNavn());
                txfEmail.setText(r.getEmail());
                txfTlf.setText(String.valueOf(r.getTlfNummer()));
                txfAntalPersoner.setText(String.valueOf(r.getAntalPersoner()));
                txfStartTid.setText(r.getStartTid());
                txfSlutTid.setText(r.getSlutTid());
            }
        }
    }
}
