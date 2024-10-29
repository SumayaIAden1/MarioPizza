import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class Bestillingsliste {
    private ArrayList<Ordre> ordreList = new ArrayList<>();
    private ArrayList<Ordre> removedOrdersList = new ArrayList<>();
    private int currentOrderNr = 1;

    public void addOrdreToList(Ordre ordre) {
        ordreList.add(ordre);
        currentOrderNr++;
        writeBestillingsliste(); // Write to file when adding
    }

    public int getOrdreNr() {
        return currentOrderNr; // Return the current order number
    }

    public void removeOrdreByNumber(int ordreNumber) {
        for (int i = 0; i < ordreList.size(); i++) {
            Ordre o = ordreList.get(i);
            if (o.getOrdreNr() == ordreNumber) {
                removedOrdersList.add(o); // Add to removed orders list
                ordreList.remove(i); // Remove from current orders
                writeBestillingsliste(); // Update the orders file
                writeRemovedOrdersToFile(); // Write all removed orders to the file
                System.out.println("Order number " + ordreNumber + " has been removed.");
                break; // Exit loop after finding and removing the order
            }
        }
    }

    public void writeBestillingsliste() {
        File bestillingsListe = new File("/Users/bruger/Desktop/UNI/1. semester/Programmering/IntelliJ/MarioPizza/src/Bestillingsliste.txt");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH.mm");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yy");

        try (FileWriter writer = new FileWriter(bestillingsListe, false)) {
            for (Ordre o : ordreList) {
                Pizza pizza = o.getPizzaObject();
                writer.append(String.format("ORDRE:\n" +
                                " - ordre Number: %d\n" +
                                " - bestillings Tid: %s\n" +
                                " - bestillings Dato: %s\n" +
                                " - Pizza: %s, Price: %d, Nr: %d\n",
                        o.getOrdreNr(),
                        o.getBestillingsTid().format(timeFormatter),
                        o.bestillingsDato().format(dateFormatter),
                        pizza.getPizzaName(),
                        pizza.getPizzaPrice(),
                        pizza.getPizzaNumber()));
                writer.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeRemovedOrdersToFile() {
        File removedOrdersFile = new File("/Users/bruger/Desktop/UNI/1. semester/Programmering/IntelliJ/MarioPizza/src/OrdrerHistorik.txt");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH.mm");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yy");

        try (FileWriter writer = new FileWriter(removedOrdersFile, false)) {
            for (Ordre o : removedOrdersList) {
                Pizza pizza = o.getPizzaObject();
                writer.append(String.format("REMOVED ORDER:\n" +
                                " - ordre Number: %d\n" +
                                " - bestillings Tid: %s\n" +
                                " - bestillings Dato: %s\n" +
                                " - Pizza: %s, Price: %d, Nr: %d\n",
                        o.getOrdreNr(),
                        o.getBestillingsTid().format(timeFormatter),
                        o.bestillingsDato().format(dateFormatter),
                        pizza.getPizzaName(),
                        pizza.getPizzaPrice(),
                        pizza.getPizzaNumber()));
                writer.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printRemovedOrders() {
        System.out.println("Removed Orders:");
        for (int i = 0; i < removedOrdersList.size(); i++) {
            Ordre ordre = removedOrdersList.get(i);
            System.out.println(ordre);
        }
    }
}
