package gui;

import controller.Controller;
import controller.Storage;
import javafx.application.Application;
import storage.ListStorage;

public class App {

    public static void main(String[] args) {
        ListStorage storage = ListStorage.loadStorage();
        if (storage == null){
            storage = new ListStorage();
            System.out.println("Empty liststorage created");
        }
        Controller.setStorage(storage);

        Application.launch(Gui.class);
    }
}
