import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

//PRECONDITION: ITEMS ARE ONLY REMOVED WHEN PAID FOR.

public class Bestillingsliste {
    private ArrayList<Ordre> bestillingsListeArray = new ArrayList<>();
    private ArrayList<Ordre> ordrerHistorikArray = new ArrayList<>();
    private int currentOrderNr = 1;

    public void addOrdreToList(Ordre ordre) {
        bestillingsListeArray.add(ordre);
        currentOrderNr++;
        writeBestillingsliste(); // Write to file when adding
    }

    public int getOrdreNr() {
        return currentOrderNr; // Return the current order number
    }

    public void removeOrdreByNumber(int ordreNumber) {
        for (int i = 0; i < bestillingsListeArray.size(); i++) {
            Ordre o = bestillingsListeArray.get(i);
            if (o.getOrdreNr() == ordreNumber) {
                ordrerHistorikArray.add(o); // Add to removed orders list
                bestillingsListeArray.remove(i); // Remove from current orders
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
            if (bestillingsListe.length() == 0) {
                writer.write("ACTIVE ORDERS / BESTILLINGSLISTE \n\n");
            }
            for (int i = 0; i < this.bestillingsListeArray.size(); i++) {
                Ordre o = this.bestillingsListeArray.get(i);
                Pizza pizza = o.getPizzaObject(); // Get

                //UDSKRIVER TEKSTEN PÅ EN BESTEMT MÅDE. LINJERNE PASSER SAMMEN.


                writer.append(String.format(
                        "ORDRE:\n" +
                                " - Ordre Number: %d\n" +
                                " - Bestillings Tid: %s\n" +
                                " - Bestillings Dato: %s\n" +

                                " - Pizza: %s, Price: %d, Nr: %d\n",

                        o.getOrdreNr(),
                        o.getBestillingsTid().format(timeFormatter),
                        o.bestillingsDato().format(dateFormatter),

                        pizza.getPizzaName(), pizza.getPizzaPrice(), pizza.getPizzaNumber()));

                writer.append(System.lineSeparator());

                //System.out.println(o.getPizzaObject() + ", " + o.getBestillingsTid() + ", " + o.getOrdreNr());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeRemovedOrdersToFile() {
        File removedOrdersFile = new File("/Users/bruger/Desktop/UNI/1. semester/Programmering/IntelliJ/MarioPizza/src/OrdrerHistorik.txt");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH.mm");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yy");
        int totalPrice = 0;

        try (FileWriter writer = new FileWriter(removedOrdersFile, false)) {
            if (removedOrdersFile.length() == 0) {
                writer.write("FINISHED / PAID FOR \n \n");
            }
            for (int i = 0; i < ordrerHistorikArray.size(); i++) {
                Ordre o = ordrerHistorikArray.get(i);
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

                totalPrice += pizza.getPizzaPrice();
            }

            writer.append("TOTAL INCOME FOR TODAY; \n");
            writer.append(String.format("%d DKK\n", totalPrice));
            writer.append(System.lineSeparator());

            // Now append the duplicate checks results
            writer.append("Checking for duplicate pizzas in removed orders...\n");
            writer.append(findPizzaDuplicates()); // Append the results of duplicate checks

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printRemovedOrders() {
        System.out.println("Paid and closed Orders:");
        for (int i = 0; i < ordrerHistorikArray.size(); i++) {
            Ordre ordre = ordrerHistorikArray.get(i);
            System.out.println(ordre);
        }
    }

    public String findPizzaDuplicates() {
        StringBuilder duplicatesInfo = new StringBuilder();
        boolean duplicatesFound = false;

        // Iterate through the removed orders
        for (int i = 0; i < ordrerHistorikArray.size(); i++) {
            Ordre ordre1 = ordrerHistorikArray.get(i);
            Pizza pizza1 = ordre1.getPizzaObject();

            // Compare with subsequent orders to find duplicates
            for (int j = i + 1; j < ordrerHistorikArray.size(); j++) {
                Ordre ordre2 = ordrerHistorikArray.get(j);
                Pizza pizza2 = ordre2.getPizzaObject();

                // Manually check if the pizza names (and possibly other attributes) are the same
                if (pizza1.getPizzaName().equals(pizza2.getPizzaName()) &&
                        pizza1.getPizzaPrice() == pizza2.getPizzaPrice()) {
                    duplicatesInfo.append(String.format("Duplicate Pizza Order: %s in orders %d and %d%n",
                            pizza1.getPizzaName(),
                            ordre1.getOrdreNr(),
                            ordre2.getOrdreNr()));
                    duplicatesFound = true;
                }
            }
        }

        if (!duplicatesFound) {
            duplicatesInfo.append("No duplicate pizzas found.\n");
        }

        return duplicatesInfo.toString(); // Return the results as a string
    }
}