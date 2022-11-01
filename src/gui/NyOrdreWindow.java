package gui;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class NyOrdreWindow extends Stage {


    public NyOrdreWindow() {
        setTitle("Opret ordre");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
        setHeight(800);
        setWidth(500);
        //stage.show();
    }

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabOpretOrdre = new Tab("Opret ordre");
        Tab tabOpretUdlejning = new Tab("Opret udlejning");


        NyOrdreTab nyOrdreTab = new NyOrdreTab();
        tabOpretOrdre.setContent(nyOrdreTab);

        UdlejningTab udlejningTab = new UdlejningTab();
      tabOpretUdlejning.setContent(udlejningTab);

        tabPane.getTabs().add(tabOpretOrdre);
        tabPane.getTabs().add(tabOpretUdlejning);

        tabOpretOrdre.setOnSelectionChanged(event -> nyOrdreTab.updateControls());
        tabOpretUdlejning.setOnSelectionChanged(event -> udlejningTab.updateControls());
    }

}
