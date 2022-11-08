package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Ordre;
import model.Ordrelinje;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class KlipStatistikWindow extends Stage {

    private String title;
    public KlipStatistikWindow(String title, Stage owner){
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
        this.setScene(scene);
    }
    private final Label lblAntalSolgt = new Label();

    private final DatePicker dp1 = new DatePicker();
    private final DatePicker dp2 = new DatePicker();

    public void initContent(GridPane pane){
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        //Datepicker til startdato
        Label lblVælgDato1 = new Label("Vælg startdatoen for perioden");
        pane.add(lblVælgDato1,0,0);
        pane.add(dp1,0,1);

        //Datepicker til slutdato
        Label lblVælgDato2 = new Label("Vælg slutdatoen for perioden");
        pane.add(lblVælgDato2,1,0);
        pane.add(dp2,1,1);

        Label lblViserPeriode = new Label("I perioden er der foretaget nedenstående salg af klippekort");
        pane.add(lblViserPeriode,0,2);

        Button btnVisSolgteKlipIPerioden = new Button("Vis solgte klip");
        pane.add(btnVisSolgteKlipIPerioden,0,3);
        btnVisSolgteKlipIPerioden.setOnAction(event -> btnVisSolgteKlipIPeriodenAction());

        pane.add(lblAntalSolgt,0,3);

    }

    private void btnVisSolgteKlipIPeriodenAction(){
        int antal = 0;
        LocalDate localDate1 = dp1.getValue();
        LocalDate localDate2 = dp2.getValue();

        for (Ordre o : Controller.getStorage().getOrdre()) {
            if (o.getDato().isAfter(localDate1) && o.getDato().isBefore(localDate2)){
                for (Ordrelinje ol : o.getOrdrelinjer()) {
                    if (Objects.equals(ol.getProdukt().getNavn(), "Klippekort")){
                        antal += ol.getAntal();
                        lblAntalSolgt.setText("I perioden er der solgt " + antal + " klippekort, svarende til " + antal*4 + " klip");

                    }

                }
            }
            else lblAntalSolgt.setText("Ingen klippekort købt i den valgte periode");
        }
    }

}
