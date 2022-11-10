package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
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
import java.util.Objects;

public class KlipStatistikWindow extends Stage {

    public KlipStatistikWindow(String title, Stage owner){
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
    private final Label lblAntalSolgt = new Label("Tryk på vis solgte klip for at se de solgte klip for perioden");

    private final DatePicker dp1 = new DatePicker();
    private final DatePicker dp2 = new DatePicker();

    private final Label lblAntalBrugt = new Label("Tryk på vis brugte klip for at se antallet af brugte klip for perioden");

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


        Label lblViserPeriode = new Label("I perioden mellem datoerne er der foretaget nedenstående salg af klippekort");
        pane.add(lblViserPeriode,0,2,1,2);

        Button btnVisSolgteKlipIPerioden = new Button("Vis solgte klip");
        pane.add(btnVisSolgteKlipIPerioden,0,4);
        btnVisSolgteKlipIPerioden.setOnAction(event -> btnVisAntalSolgteKlippeKortAction());

        pane.add(lblAntalSolgt,0,5);



        Button btnAntalSolgt = new Button("Vis brugte klip");
        btnAntalSolgt.setOnAction(event -> btnVisBrugteKlipAction());
        pane.add(btnAntalSolgt,0,6);
        pane.add(lblAntalBrugt, 0,7);

    }

    private void btnVisAntalSolgteKlippeKortAction(){
        Controller.VisSolgteKlipIPerioden(dp1.getValue(),dp2.getValue(),lblAntalSolgt);
    }

    private void btnVisBrugteKlipAction(){
        Controller.VisAntalBrugteKlip(dp1.getValue(), dp2.getValue(), lblAntalBrugt);
    }


}
