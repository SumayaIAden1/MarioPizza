import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        Main nonStaticMain = new Main();
        nonStaticMain.run();
    }

    private void run(){
        MenuKort menukortInstans = new MenuKort();
        menukortInstans.createMenuKort();
        menukortInstans.writePizzaMenuToFile();
    }

}