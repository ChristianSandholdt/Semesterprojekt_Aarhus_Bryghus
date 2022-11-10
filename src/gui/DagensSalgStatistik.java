package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Ordre;
import model.Ordrelinje;

import java.time.LocalDate;
import java.util.ArrayList;

public class DagensSalgStatistik extends Stage {
    private String title;

    public DagensSalgStatistik(String title, Stage owner) {
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
    }

    private final DatePicker datePicker = new DatePicker(LocalDate.now());
    private final TextField txfTotalSalg = new TextField();
    private final ListView<Ordre> lvwOrdre = new ListView<>();
    private final ListView<Ordrelinje> lvwOrdrelinje = new ListView<>();
    private final TextField txfTotalpris = new TextField();
    private final Label lblBetalingsform = new Label("Betalingsform: ");

    public void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        //Datepicker
        pane.add(datePicker, 0, 1);

        //Salg
        Label lblTotaltSalg = new Label("Totalt antal salg for den valgt dag:");
        pane.add(lblTotaltSalg, 1, 0);
        pane.add(txfTotalSalg, 1, 1);
        txfTotalSalg.setEditable(false);

        //Listview til ordrer
        pane.add(lvwOrdre, 1,2);
        lvwOrdre.setMaxHeight(160);

        //Listview til ordrelinjer
        pane.add(lvwOrdrelinje,1,3);
        lvwOrdrelinje.setMaxHeight(180);

        //Textfield til totaltpris
        pane.add(txfTotalpris, 1,4);

        //Label til betalingsform
        pane.add(lblBetalingsform, 0,4);


        //Listener til dato
        ChangeListener<LocalDate> listener = (obs, o, n) -> this.selectedDateChanged();
        datePicker.valueProperty().addListener(listener);

        //Listener til ordre
        ChangeListener<Ordre> listener1 = (obs, o, n) -> this.selectedOrdreChanged();
        lvwOrdre.getSelectionModel().selectedItemProperty().addListener(listener1);



    }

    private void selectedOrdreChanged(){
        Ordre selectedItem = lvwOrdre.getSelectionModel().getSelectedItem();
        if (selectedItem != null){
            this.fillLvwOrdrelinje(selectedItem);
            this.filltxfTotalpris();
            this.setLabelBetalingsform(selectedItem);
        }
    }

    private void fillLvwOrdrelinje(Ordre ordre){
        lvwOrdrelinje.getItems().clear();
        lvwOrdrelinje.getItems().addAll(ordre.getOrdrelinjer());
    }

    private void filltxfTotalpris() {
        Ordre ordre = lvwOrdre.getSelectionModel().getSelectedItem();
        txfTotalpris.setText(Controller.totalPris(ordre));
    }

    private void setLabelBetalingsform(Ordre ordre){
            lblBetalingsform.setText("Betalingsform: \n" + ordre.getBetalingsform());
    }


    private void selectedDateChanged() {
        LocalDate selectedItem = datePicker.getValue();
        if (selectedItem != null) {
            this.fillTxfSalg(selectedItem);
            this.fillLvwOrdre(selectedItem);
        }
    }
    void fillLvwOrdre(LocalDate localDate){
        lvwOrdre.getItems().clear();
        ArrayList<Ordre> ordrer = new ArrayList<>();
        for (Ordre o : Controller.getStorage().getOrdre()){
            if (o.getDato().equals(localDate)){
                ordrer.add(o);
            }
        }
        lvwOrdre.getItems().setAll(ordrer);
    }

    private void fillTxfSalg(LocalDate localDate) {
        txfTotalSalg.clear();
        ArrayList<Ordre> ordrer = new ArrayList<>();
        for (Ordre o : Controller.getStorage().getOrdre()) {
            if (o.getDato().equals(localDate)) {
                ordrer.add(o);
            }
        }
        String s = "" + ordrer.size();
        txfTotalSalg.setText(s);
    }
    void update(){
        fillLvwOrdre(LocalDate.now());
    }
}
