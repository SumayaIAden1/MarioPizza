import java.util.ArrayList;

public class Pizza {

    private String pizzaName;
    private int pizzaPrice;
    private int pizzaNr;

   //public ArrayList<Pizza> pizzaMenu

    public Pizza() //Default constructor
    {}

    public Pizza(String pName, int pPrice, int pNumber) {
        pizzaName = pName;
        pizzaPrice = pPrice;
        pizzaNr = pNumber;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public int getPizzaPrice() {
        return pizzaPrice;
    }

    public int getPizzaNr() {
        return pizzaNr;
    }

    public String toString() {
        return "Pizza: " + pizzaName + ", Price: " + pizzaPrice + ", Number: " + pizzaNr;
    }

}
