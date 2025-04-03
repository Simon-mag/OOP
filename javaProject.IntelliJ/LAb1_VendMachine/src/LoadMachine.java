import java.util.Random;

public class LoadMachine {

    public static Beverage[] fill(int size){
        Random random = new Random();
        Beverage[] beverages = new Beverage[size];

        Beverage cola = new Beverage("Cola",25,random.nextInt(20)+1);
        Beverage fanta = new Beverage("Fanta",20,random.nextInt(20)+1);
        Beverage capriSonne = new Beverage("Capri-Sonne",10,random.nextInt(20)+1);
        Beverage vatten = new Beverage("Vatten",10,random.nextInt(20)+1);
        Beverage fantaExotic = new Beverage("Fanta Exotic",50,random.nextInt(20)+1);

        beverages[0] = cola;
        beverages[1] = fanta;
        beverages[2] = fantaExotic;
        beverages[3] = capriSonne;
        beverages[4] = vatten;

        return beverages;
    }


}
