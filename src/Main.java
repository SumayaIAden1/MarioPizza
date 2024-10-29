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

        Bestillingsliste bestillingsliste = new Bestillingsliste(); // Instantiate Bestillingsliste

        while (true) {
            System.out.println("Choose a pizza (or type 'exit' to finish, or 'remove' to remove an order)");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break; // Exit the loop if user types 'exit'
            } else if (input.equalsIgnoreCase("remove")) {
                System.out.println("Enter the order number to remove:");
                int ordreToRemove;

                try {
                    ordreToRemove = Integer.parseInt(scanner.nextLine());
                    bestillingsliste.removeOrdreByNumber(ordreToRemove); // Remove order
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid order number.");
                }
                continue; // Go to the next iteration of the loop
            }

            // Handle pizza selection
            try {
                int pizzaIndex = Integer.parseInt(input) - 1; // Parse the input as an integer

                if (pizzaIndex < 0 || pizzaIndex >= menukortInstans.getPizzaMenuList().size()) {
                    System.out.println("Invalid pizza number. Please choose a valid number.");
                    continue; // Skip to the next iteration
                }

                Pizza selectedPizza = menukortInstans.getPizzaMenuList().get(pizzaIndex);
                Ordre ordre = new Ordre(bestillingsliste.getOrdreNr(), LocalDateTime.now(), LocalDate.now(), selectedPizza);
                bestillingsliste.addOrdreToList(ordre); // Add order to Bestillingsliste

                System.out.println("Order added: " + ordre);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid pizza number or 'exit' to finish.");
            }
        }

        // Optionally, print all removed orders at the end
        bestillingsliste.printRemovedOrders();

        // After taking all orders, check for duplicates
        System.out.println("Checking for duplicate pizza orders:");
        bestillingsliste.findPizzaDuplicates();// Call method to check for duplicates

    }
}