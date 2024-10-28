import java.util.Random;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ordre {

    public Ordre() {}


    private int ordreNr;
    private LocalDateTime bestillingsTid;
    private LocalDate bestillingsDato;
    private Pizza pizzaObject;
    private int antal;
    private boolean paid;

    private Random random = new Random();



    public Ordre(int oNummer, LocalDateTime bTid, LocalDate bDato, Pizza pObject)
    {
        this.ordreNr = oNummer;
        this.bestillingsTid = bTid;
        this.bestillingsDato = bDato;
        this.pizzaObject = pObject;
        this.paid = false;
    }

    public void markAsPaid() {
        this.paid = true;
    }

    public boolean isPaid() {
        return this.paid;
    }


    public int getOrdreNr(){
        return ordreNr;
    }

    public LocalDateTime getBestillingsTid() {
        return bestillingsTid;
    }
    public LocalDate bestillingsDato(){
        return bestillingsDato;
    }

    public Pizza getPizzaObject() {
        return pizzaObject;
    }


    public String toString() {
        return "ORDRE:\n" +
                " - Ordre Nr: " + ordreNr + "\n" +
                " - Bestillings Tidspunkt: " + bestillingsTid + "\n" +
                " - Bestillings Dato: " + bestillingsDato + "\n" +
                " - Pizza: " + pizzaObject + "\n";

    }
}