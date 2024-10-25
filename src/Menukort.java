import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Menukort {

    public Menukort() {
    }
    public ArrayList<Pizza> pizzaArrayList = new ArrayList<>();

    public void createMenuKort() {
        // ArrayList med pizzamenuer
        pizzaArrayList.add(new Pizza("Margherita", 60, 15));
        pizzaArrayList.add(new Pizza("Pepperoni", 70, 32));
        pizzaArrayList.add(new Pizza("Hawaiian", 75, 22));
        pizzaArrayList.add(new Pizza("BBQ Chicken", 85, 44));
        pizzaArrayList.add(new Pizza("Vegetarian", 65, 19));
        pizzaArrayList.add(new Pizza("Meat Lovers", 90, 37));
        pizzaArrayList.add(new Pizza("Four Cheese", 80, 28));
        pizzaArrayList.add(new Pizza("Buffalo Chicken", 95, 11));
        pizzaArrayList.add(new Pizza("Supreme", 100, 41));
        pizzaArrayList.add(new Pizza("Mexican", 85, 27));
        pizzaArrayList.add(new Pizza("Seafood Special", 110, 49));
        pizzaArrayList.add(new Pizza("Tuna and Sweetcorn", 95, 12));
        pizzaArrayList.add(new Pizza("Spicy Sausage", 80, 25));
        pizzaArrayList.add(new Pizza("Prosciutto and Rocket", 90, 33));
        pizzaArrayList.add(new Pizza("Mushroom and Truffle Oil", 120, 46));
        pizzaArrayList.add(new Pizza("Calzone", 85, 17));
        pizzaArrayList.add(new Pizza("Carbonara Pizza", 90, 31));
        pizzaArrayList.add(new Pizza("Pesto and Chicken", 95, 20));
        pizzaArrayList.add(new Pizza("Gorgonzola and Pear", 110, 35));
        pizzaArrayList.add(new Pizza("Salami and Olive", 80, 23));
        pizzaArrayList.add(new Pizza("Spinach and Ricotta", 70, 26));
        pizzaArrayList.add(new Pizza("Greek Pizza (Feta and Olives)", 75, 18));
        pizzaArrayList.add(new Pizza("Zucchini and Goat Cheese", 85, 38));
        pizzaArrayList.add(new Pizza("Egg and Bacon", 100, 42));
        pizzaArrayList.add(new Pizza("Shrimp and Pesto", 90, 21));
        pizzaArrayList.add(new Pizza("Tandoori Chicken", 110, 47));
        pizzaArrayList.add(new Pizza("Pastrami Pizza", 95, 30));
        pizzaArrayList.add(new Pizza("Bolognese Pizza", 85, 29));
        pizzaArrayList.add(new Pizza("Quattro Stagioni", 105, 40));
        pizzaArrayList.add(new Pizza("Lamb and Mint", 115, 36));

        for (int i = 0; i < pizzaArrayList.size(); i++) {
        System.out.println(pizzaArrayList.get(i));
        }
    }


        public void writePizzaMenuToFile(){
                File pizzaFile = new File("/Users/bruger/Desktop/UNI/1. semester/Programmering/IntelliJ/MarioPizza/src/pizzaMenu.txt");
                try (FileWriter writer = new FileWriter(pizzaFile, true)) {
                    for (int i = 0; i < pizzaArrayList.size(); i++) {
                        Pizza p = pizzaArrayList.get(i);

                        String pizzaName = p.getPizzaName();
                        int pizzaPrice = p.getPizzaPrice();
                        int pizzaNr = p.getPizzaNr();

                        writer.append(pizzaName + ", ");
                        writer.append((pizzaPrice) + ", ");
                        writer.append(Integer.toString(pizzaNr) + '\n');


                        System.out.println(p.getPizzaName() + ", " + p.getPizzaPrice() + ", " + p.getPizzaNr());
                    }

                }

                catch (IOException e)
                {
                    e.printStackTrace();
                }
        }

}




