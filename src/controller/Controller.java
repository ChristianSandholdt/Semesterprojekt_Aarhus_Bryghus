package controller;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {

    private static Storage storage;

    public static Storage getStorage(){
        return storage;
    }
    public static void setStorage(Storage storage) {
        Controller.storage = storage;
    }

    //------------------------------------------------------------------------


    /**
     * It creates an Ordre and stores it in the database
     * @return The method returns an object of the class Ordre.
     */
    public static Ordre createOrdre(boolean betalt, double ordreID,LocalDate localDate,String betalingsform){
        Ordre ordre = new Ordre(betalt,ordreID,localDate,betalingsform);
        storage.storeOrdre(ordre);
        return ordre;
    }

    /**
     * Creates an Ordrelinje, store it, and return it.
     * Pre: Produkt already exist
     * @param produkt The Produkt that the Ordrelinje is for.
     * @return An object of type Ordrelinje
     */
    public static Ordrelinje createOrdrelinje(int antal, Produkt produkt, Pris pris){
        Ordrelinje ordrelinje = new Ordrelinje(antal,produkt,pris);
        storage.storeOrdrelinje(ordrelinje);
        return ordrelinje;
    }

    /**
     * "Deletes an Ordrelinje from an Ordre."
     * The function is called with two parameters, an Ordrelinje and an Ordre. The Ordrelinje is removed from the Ordre,
     * and then the Ordrelinje is deleted from the database
     * Pre: Ordrelinje already exist
     */
    public static void deleteOrdrelinje(Ordrelinje ordrelinje, Ordre ordre){
        ordre.removeOrdrelinje(ordrelinje);
        storage.deleteOrdreLinje(ordrelinje);
    }

    /**
     * It creates a new Produkt and stores it in the database
     * Pre: Produktgruppe already exist
     * @param produktgruppe The Produktgruppe the Produkt belongs to.
     * @return A new Produkt object is being returned.
     */
    public static Produkt createProdukt(String name, Produktgruppe produktgruppe){
        Produkt produkt = new Produkt(name, produktgruppe);
        storage.storeProdukt(produkt);
        return produkt;
    }


    /**
     * Deletes a Produkt from the database and remove it from the Produktgruppe.
     * Pre: Selected Produkt exists
     */
    public static void deleteProdukt(Produkt produkt, Produktgruppe produktgruppe){
        produktgruppe.fjernProdukt(produkt);
        storage.deleteProdukt(produkt);
    }

    /**
     * It updates a Produkt
     * Pre: Produkt already exists
     */
    public static void updateProdukt(Produkt produkt, String name, Produktgruppe produktgruppe){
        produkt.setNavn(name);
        if (produkt.getProduktgruppe() != null){
            produkt.fjernProduktgruppe(produkt.getProduktgruppe());
        }
        produkt.setProduktgruppe(produktgruppe);

    }

    //---------------------------------------------------------------------------

    /**
     * It creates a new Produktgruppe and stores it in the storage
     * @return A new Produktgruppe object is being returned.
     */
    public static Produktgruppe createProduktGruppe(String name, boolean udlejning){
        Produktgruppe produktgruppe = new Produktgruppe(name,udlejning);
        storage.storeProduktgruppe(produktgruppe);
        return produktgruppe;
    }


    /**
     * This function deletes a Produktgruppe from the database
     * Pre: A Produktgruppe exists in the database
     */
    public static void deleteProduktGruppe(Produktgruppe produktgruppe){
        storage.deleteProduktgruppe(produktgruppe);
    }

    //---------------------------------------------------------------------------

    /**
     * It creates a new Rundvisning object and stores it in the database
     * Pre: startTid must be set before slutTid
     * @return A Rundvisning object
     */
    public static Rundvisning createRundvisning(String navn, String email, int tlfNummer, double pris, int antalPersoner,
                                                LocalDate dato, String startTid, String slutTid){
        if (antalPersoner < 1){
            throw new RuntimeException("Kan ikke oprettes med 0 personer");
        }
        Rundvisning rundvisning = new Rundvisning(navn, email, tlfNummer, pris, antalPersoner, dato, startTid, slutTid);
        storage.storeRundvisning(rundvisning);
        return rundvisning;
    }

    /**
     * It deletes a given rundvisning from the storage
     * Pre: Requires there to be an existing Rundvisning
     */
    public static void deleteRundvisning(Rundvisning rundvisning) {
        storage.deleteRundvisning(rundvisning);
    }


    /**
     * It takes in the needed parameters to create a new Rundvisning object, and then deletes the old Rundvisning object and
     * replaces it with the new one
     * Pre: There already exists a Rundvisning object
     */
    public static void updateRundvisning(String navn, String email, int tlfNummer, double pris, int antalPersoner,
                                         LocalDate dato, String startTid, String slutTid){
        Rundvisning rundvisning = new Rundvisning(navn, email, tlfNummer, pris, antalPersoner,
                dato, startTid, slutTid);
        for (Rundvisning r : Controller.getStorage().getRundvisning()){
            if (r.getDato() == rundvisning.getDato()){
                Controller.getStorage().deleteRundvisning(r);
            }
        }
        storage.storeRundvisning(rundvisning);
    }
    //---------------------------------------------------------------------------

    /**
     * It creates a new Prisliste with the given name, stores it in the database, and returns it
     * @return A new Prisliste object is being returned.
     */
    public static Prisliste createPrisliste(String navn){
        Prisliste prisliste = new Prisliste(navn);
        storage.storePrisliste(prisliste);
        return prisliste;
    }


    /**
     * It creates a Pris for a Produkt in a Prisliste
     * Pre: Parameters below already exist as objects
     * @param produkt The Produkt that the price is for.
     * @param prisliste The Prisliste that the price is to be added to.
     * @return A Pris object
     */
    public static Pris createPris(Produkt produkt, Prisliste prisliste,double pris,double prisIKlip){
        Pris p = new Pris(pris,prisIKlip);
        prisliste.addPris(p);
        produkt.addPris(p);
        p.setProdukt(produkt);
        produkt.getProduktgruppe().addPrisliste(prisliste);
        prisliste.addProduktgruppe(produkt.getProduktgruppe());
        storage.storePris(p);
        return p;
    }

    /**
     * Get the Pris of a Produkt in a Prisliste.
     * Pre: Parameters exist
     * @param pl Prisliste
     * @param pr The Produkt you want to get the price of.
     * @return A Pris object
     */
    public static Pris getPris(Prisliste pl, Produkt pr){
        Pris pris = null;
        for (Pris p : storage.getPris()){
            if (pr.getPriser().contains(p) && pl.getPriser().contains(p)){
                pris = p;
            }
        }
        return pris;
    }
    /**
     * The function takes an Ordre and returns the total price of the Ordre
     * Pre: Order exist beforehand
     * @param ordre The Ordre object
     * @return The total price as a string
     */
    public static String totalPris(Ordre ordre){
        double pris = 0;
        for(Ordrelinje o : ordre.getOrdrelinjer()){
            pris = pris + o.getPrisOrdreLinje().getPris() * o.getAntal();
        }
        return pris + "";
    }

    /**
     * This function resets the totalPrice by creating a new Pris object with the values 0 and 0,
     * and returns the string representation of that object.
     * Pre: toString method exists in Pris
     * @return The toString() method of the Pris class.
     */
    public static String resetPris() {
        Pris pris = null;
        pris = new Pris(0, 0);
        return pris + "";
    }

    /**
     * It takes two dates and a label as parameters, and returns the number of klippekort sold between the two dates. If a
     * label is provided, it will also set the text of the label to a string containing the number of klippekort sold and
     * the number of klip sold
     * Pre: An Ordre with any amount of sold Klippekort exist
     * @return The number of sold cards in the period
     */
    public static int VisSolgteKlipIPerioden(LocalDate dato1, LocalDate dato2, Label label){
        int antal = 0;
        if (dato1.isAfter(dato2)){
            throw new RuntimeException("Første dato skal være før anden dato");
        }

        for (Ordre o : getStorage().getOrdre()){
            if (o.getDato().isAfter(dato1) && o.getDato().isBefore(dato2)){
                for (Ordrelinje ol : o.getOrdrelinjer()){
                    if (ol.getProdukt().getNavn().equals("Klippekort")){
                        antal += ol.getAntal();
                    }
                }
            }
        }
        if (label != null){
            label.setText("I perioden er der solgt " + antal + " klippekort, svarende til " + antal*4 + " klip");
        }
        return antal;
    }

    /**
     * It takes two dates and a label as parameters, and then it loops through all the orders, and if the order is between
     * the two dates, and if the order is paid with a klippekort, it loops through all the orderlines, and then through all
     * the prices of the products in the orderlines, and then it adds the price in klip of the Produkt to the variable
     * antal. Then it sets the text of the label to "Antallet af brugte klip i perioden er " + antal
     *
     * Pre: An Ordre with a Klippekort sold exist
     */
    public static void VisAntalBrugteKlip(LocalDate dato1, LocalDate dato2,Label label){
        double antal = 0;
        for (Ordre o : getStorage().getOrdre()){
            if (o.getDato().isAfter(dato1) && o.getDato().isBefore(dato2)){
                if (o.getBetalingsform().equals("Klippekort")){
                    for (Ordrelinje ol : o.getOrdrelinjer()){
                        for (Pris p : ol.getProdukt().getPriser()){
                            antal += p.getPrisIKlip();
                        }
                    }
                }
            }
        }
        label.setText("Antallet af brugte klip i perioden er " + antal);
    }

    /**
     * It sets the order to paid and sets the payment method to the one selected in the combobox
     * Pre: An Ordre and comboBox must exist beforehand
     * @param ordre The Ordre that is being paid
     * @param comboBox The combobox that contains the payment methods.
     */
    public static void betalOrdre(Ordre ordre, ComboBox comboBox){
        ordre.setBetalt(true);
        ordre.setBetalingsform(comboBox.getSelectionModel().getSelectedItem().toString());
    }


    /**
     * It returns an ArrayList of all orders that contain a product that is a rental product
     * Pre: Ordre with Udlejning exists
     * @return An ArrayList of all the orders that contain a product that is a rental.
     */
    public static ArrayList<Ordre> visUdlejninger(){
        ArrayList<Ordre> arrayList = new ArrayList<>();
        for (Ordre o : getStorage().getOrdre())
            for (Ordrelinje ol : o.getOrdrelinjer()){
                if (ol.getProdukt().getProduktgruppe().getUdlejning()){
                    if (!arrayList.contains(o)){
                        arrayList.add(o);
                    }
                }
            }
        return arrayList;
    }

    /**
     * It takes an Ordre and returns an arraylist of strings containing the Ordrelinjer of the Ordre
     * Pre: An Ordre already exists
     * @param ordre The Ordre you want to view the statistics for.
     * @return An ArrayList of Strings.
     */
    public static ArrayList<String> visUdlejningStatistik(Ordre ordre) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (Ordrelinje ol : ordre.getOrdrelinjer()) {
            arrayList.add(ol.toString());
        }

        return arrayList;
    }
}
