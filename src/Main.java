public class Main {


    public static void main(String[] args) {
        Main nonStaticMain = new Main();
        nonStaticMain.run();
    }

    private void run(){
        Menukort menukortInstans = new Menukort();
        menukortInstans.createMenuKort();
        menukortInstans.writePizzaMenuToFile();
    }

}