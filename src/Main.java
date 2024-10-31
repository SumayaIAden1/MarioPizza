import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main nonStaticMain = new Main();
        nonStaticMain.run();
    }

    private void run() {
        Menukort menukortInstans = new Menukort();
        menukortInstans.createMenuKort();
        menukortInstans.writePizzaMenuToFile();

        Bestillingsliste bestillingsliste = new Bestillingsliste(); // Instans

        while (true) {
            System.out.println("Choose a pizza (or type 'exit' to finish, or 'remove' to remove an order)");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("remove")) {
                System.out.println("Enter the order number to remove:");
                int ordreToRemove;

                try {
                    ordreToRemove = Integer.parseInt(scanner.nextLine());
                    bestillingsliste.removeOrdreByNumber(ordreToRemove); // Fjerner ordreren
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid order number.");
                }

            }

            // Håndterer pizza
            try {
                int pizzaIndex = Integer.parseInt(input) - 1; // Konventerer vores Integer til en String

                if (pizzaIndex < 0 || pizzaIndex >= menukortInstans.getPizzaMenuList().size()) {
                    System.out.println("Invalid pizza number. Please choose a valid number.");
                }

                Pizza selectedPizza = menukortInstans.getPizzaMenuList().get(pizzaIndex);
                Ordre ordre = new Ordre(bestillingsliste.getOrdreNr(), LocalDateTime.now(), LocalDate.now(), selectedPizza);
                bestillingsliste.addOrdreToList(ordre); // Tilføj ordrer til bestillingslisten

                System.out.println("Order added: " + ordre);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid pizza number or 'exit' to finish.");
            }
        }

        // Print alle de fjernede ordrer til sidst.
        bestillingsliste.printRemovedOrders();

        // Herefter så tjek efter duplicates på de fjernede ordrer. "Most popular Pizza"
        bestillingsliste.findPizzaDuplicates();// Call method to check for duplicates
    }
}