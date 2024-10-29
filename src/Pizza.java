public class Pizza {

    public Pizza() {}

    private String pizzaName;
    private int pizzaPrice;
    private int pizzaNumber;


    public Pizza(String pName, int pPrice, int pNumber) {
        pizzaName = pName;
        pizzaPrice = pPrice;
        pizzaNumber = pNumber;
    }


    public String getPizzaName() {
        return pizzaName;
    }

    public int getPizzaPrice() {
        return pizzaPrice;
    }

    public int getPizzaNumber() {
        return pizzaNumber;
    }

    @Override
    public String toString() {
        return  pizzaName + ", Price: " + pizzaPrice + ", Nr: " + pizzaNumber;
    }
}
