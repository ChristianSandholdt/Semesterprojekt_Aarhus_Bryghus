package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Ordre;

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


    public void initContent(GridPane pane){
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        //Datepicker
        pane.add(datePicker,0,0);

        //Salg
        Label lblTotaltSalg = new Label("Totalt antal salg for den valgt dag:");
        pane.add(lblTotaltSalg,1,0);
        pane.add(txfTotalSalg,1,1);
        txfTotalSalg.setEditable(false);

        //Listener til dato
        ChangeListener<LocalDate> listener = (obs,o,n) -> this.selectedDateChanged();
        datePicker.valueProperty().addListener(listener);

    }

        private void selectedDateChanged(){
            LocalDate selectedItem = datePicker.getValue();
            if (selectedItem != null){
                this.fillTxfSalg(selectedItem);
                System.out.println(selectedItem);
            }
        }

        private void fillTxfSalg(LocalDate localDate){
        txfTotalSalg.clear();
            ArrayList<Ordre> ordrer = new ArrayList<>();
            for (Ordre o : Controller.getStorage().getOrdre()){
                System.out.println(o.getDato());
                if (o.getDato().equals(localDate)){
                    ordrer.add(o);
                }
            }
            String s = "" + ordrer.size();
        txfTotalSalg.setText(s);
        }
}
