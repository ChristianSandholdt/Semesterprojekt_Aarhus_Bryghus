package storage;

import controller.Storage;
import model.Ordre;
import model.Produkt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListStorage implements Storage, Serializable {

    private List<Produkt> produkter = new ArrayList<>();

    private List<Produkt> getProdukter(){
        return new ArrayList<Produkt>(produkter);
    }

    public void storeProdukt(Produkt produkt){
        produkter.add(produkt);
    }

    public void removeProdukt(Produkt produkt){
        produkter.remove(produkt);
    }


    public static void saveStorage(Storage storage){
        String fileName = "src/test/storage.ser";
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objOut = new ObjectOutputStream(fileOut)
        ) {
            objOut.writeObject(storage);
            System.out.println("Storage saved in file " + fileName);
        } catch (IOException ex) {
            System.out.println("Error writing file");
            System.out.println(ex);
            throw new RuntimeException();
        }
    }


    public static ListStorage loadStorage(){
        String fileName = "src/test/storage.ser";
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objIn = new ObjectInputStream(fileIn)
        ) {
            Object obj = objIn.readObject();
            ListStorage storage = (ListStorage) obj;
            System.out.println("Storage loaded from file " + fileName);
            return storage;
        } catch (ClassCastException ex) {
            System.out.println("Class of serialized object changed");
            System.out.println(ex);
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Class of serialized object not found");
            System.out.println(ex);
            return null;
        } catch (IOException ex) {
            System.out.println("Error reading file");
            System.out.println(ex);
            return null;
        }
    }
}
