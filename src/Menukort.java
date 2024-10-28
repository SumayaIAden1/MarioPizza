import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Menukort {

    public Menukort()
    {
    }


    public ArrayList<Pizza> pizzaMenuList = new ArrayList<>();

    public void createMenuKort() {

        pizzaMenuList.add(new Pizza("Margherita", 60, 1)); //
        pizzaMenuList.add(new Pizza("Pepperoni", 70, 2));
        pizzaMenuList.add(new Pizza("Hawaiian", 75, 3));
        pizzaMenuList.add(new Pizza("BBQ Chicken", 85, 4));
        pizzaMenuList.add(new Pizza("Vegetarian", 65, 5));
        pizzaMenuList.add(new Pizza("Meat Lovers", 90, 6));
        pizzaMenuList.add(new Pizza("Four Cheese", 80, 7));
        pizzaMenuList.add(new Pizza("Buffalo Chicken", 95, 8));
        pizzaMenuList.add(new Pizza("Supreme", 100, 9));
        pizzaMenuList.add(new Pizza("Mexican", 85, 10));
        pizzaMenuList.add(new Pizza("Seafood Special", 110, 11));
        pizzaMenuList.add(new Pizza("Tuna and Sweetcorn", 95, 12));
        pizzaMenuList.add(new Pizza("Spicy Sausage", 80, 13));
        pizzaMenuList.add(new Pizza("Prosciutto and Rocket", 90, 14));
        pizzaMenuList.add(new Pizza("Mushroom and Truffle Oil", 120, 15));
        pizzaMenuList.add(new Pizza("Calzone", 85, 16));
        pizzaMenuList.add(new Pizza("Carbonara Pizza", 90, 17));
        pizzaMenuList.add(new Pizza("Pesto and Chicken", 95, 18));
        pizzaMenuList.add(new Pizza("Gorgonzola and Pear", 110, 19));
        pizzaMenuList.add(new Pizza("Salami and Olive", 80, 20));
        pizzaMenuList.add(new Pizza("Spinach and Ricotta", 70, 21));
        pizzaMenuList.add(new Pizza("Greek Pizza (Feta and Olives)", 75, 22));
        pizzaMenuList.add(new Pizza("Zucchini and Goat Cheese", 85, 23));
        pizzaMenuList.add(new Pizza("Egg and Bacon", 100, 24));
        pizzaMenuList.add(new Pizza("Shrimp and Pesto", 90, 25));
        pizzaMenuList.add(new Pizza("Tandoori Chicken", 110, 26));
        pizzaMenuList.add(new Pizza("Pastrami Pizza", 95, 27));
        pizzaMenuList.add(new Pizza("Bolognese Pizza", 85, 28));
        pizzaMenuList.add(new Pizza("Quattro Stagioni", 105, 29));
        pizzaMenuList.add(new Pizza("Lamb and Mint", 115, 30));

        for(int i = 0; i < pizzaMenuList.size(); i++) {
            System.out.println(pizzaMenuList.get(i));
        }
    }


    public void writePizzaMenuToFile()
    {
        File pizzaFile = new File("/Users/bruger/Desktop/UNI/1. semester/Programmering/IntelliJ/MarioPizza/src");
        try (FileWriter writer = new FileWriter(pizzaFile, true)) {
            for (int i = 0; i < pizzaMenuList.size(); i++) {
                Pizza p = pizzaMenuList.get(i);

                String pizzaName = p.getPizzaName();
                int pizzaPrice = p.getPizzaPrice();
                int pizzaNr = p.getPizzaNumber();

                writer.append(pizzaName + ", ");
                writer.append(Integer.toString(pizzaPrice) + ", ");
                writer.append(Integer.toString(pizzaNr) + '\n');

                System.out.println(p.getPizzaName() + ", " + p.getPizzaPrice() + ", " + p.getPizzaNumber());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Pizza> getPizzaMenuList() {
        return pizzaMenuList;
    }

    private Pizza randomPizza() {
        Random random = new Random();
        int randomIndex = random.nextInt(pizzaMenuList.size());
        return pizzaMenuList.get(randomIndex);
    }

    public Pizza getRandomPizza() {
        return randomPizza();
    }
}





