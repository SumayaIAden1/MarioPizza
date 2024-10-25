import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Ordre {

    private int ordreNr;
    private int bestillingsTid;
    private int bestillingsDato;
    private Pizza pizzaObjekt;
    private int antal;
    private Random random = new Random();

    private String[] fornavn = {"Anders", "Sofie", "Peter", "Emma", "Mads", "Ida", "Lars", "Marie", "Thomas", "Clara", "Frederik", "Victoria", "Oliver", "Freja", "Mikkel", "Louise", "Simon", "Astrid", "Christian", "Isabella"}
    private String[] efternavn = "Nielsen", "Jensen","Hansen","Pedersen","Andersen","Christensen","Larsen","Sørensen","Rasmussen","Jørgensen","Petersen","Madsen","Kristensen","Olsen","Thomsen","Christiansen","Poulsen","Møller","Mortensen","Eriksen"

    {
    }

    public Ordre(int oNummer, int bTid, Pizza pObjekt) {
        ordreNr = oNummer;
        bestillingsTid = bTid;
        bestillingsDato = bDato;
        pizzaObjekt = pObjekt;
    }

    public int getOrdreNr() {
        return ordreNr;
    }

    public int getBestillingsTid() {
        return bestillingsTid;
    }

    public int getBestillingsDato() {
        return bestillingsDato;
    }

    public Pizza getPizzaObjekt() {
        return pizzaObjekt;
    }

    public int getAntal() {
        return antal;
    }
}
 public void generereForbruger(int antal)
    {
        Random random = new Random();

        for (int i = 0; i < antal; i++)
            {    String navn = "";
            int maalerNr = 0;

            int x = random.nextInt(2);
            if (x == 0)
                navn += drenge[random.nextInt(drenge.length)];
            else
                navn += piger[random.nextInt(piger.length)];
            navn += " "+ efternavn[random.nextInt(efternavn.length)];

            while(true)
            {
                maalerNr = random.nextInt(999)+1;
                if (!findesMaalerNr(maalerNr))
                    break;
            }

            Forbruger f = new Forbruger(navn,maalerNr,1000);
            addForbruger(f);
        }
    }
    