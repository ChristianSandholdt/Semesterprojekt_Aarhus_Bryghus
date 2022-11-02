package storage;

import controller.Storage;
import model.Ordre;
import model.Ordrelinje;
import model.Produkt;
import model.Produktgruppe;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListStorage implements Storage, Serializable {

    private List<Produkt> produkter = new ArrayList<>();
    private List<Produktgruppe> produktgrupper = new ArrayList<>();

    private List<Ordre> ordre = new ArrayList<>();
    private List<Ordrelinje> ordrelinjer = new ArrayList<>();


    @Override
    public List<Ordre> getOrdre(){
        return new ArrayList<>(ordre);
    }

    @Override
    public void storeOrdre(Ordre ordre){
        ordre.addOrdre(ordre);
    }
    @Override
    public void deleteOrdre(Ordre ordre) {
        ordre.removeOrdre(ordre);
    }

    @Override
    public List<Ordrelinje> getOrdrelinjer(){
        return new ArrayList<>(ordrelinjer);
    }
    @Override
    public void storeOrdrelinje(Ordrelinje ordrelinje){
        ordrelinjer.add(ordrelinje);
    }
    @Override
    public void deleteOrdreLinje(Ordrelinje ordrelinje){
        ordrelinjer.remove(ordrelinje);
    }

    @Override
    public List<Produktgruppe> getProduktgruppe() {
        return new ArrayList<>(produktgrupper);
    }
    @Override
    public void storeProduktgruppe(Produktgruppe produktgruppe) {
        produktgrupper.add(produktgruppe);
    }
    @Override
    public void deleteProduktgruppe(Produktgruppe produktgruppe) {
        produktgrupper.remove(produktgruppe);
    }
    @Override
    public List<Produkt> getProdukt() {
        return new ArrayList<>(produkter);
    }

    @Override
    public void storeProdukt(Produkt produkt) {
        produkter.add(produkt);
    }

    @Override
    public void deleteProdukt(Produkt produkt) {
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
