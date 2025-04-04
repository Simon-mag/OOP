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
        if(size > 0)
            beverages[0] = cola;
        if(size > 1)
            beverages[1] = fanta;
        if(size > 2)
            beverages[2] = fantaExotic;
        if(size > 3)
            beverages[3] = capriSonne;
        if(size > 4)
            beverages[4] = vatten;

        return beverages;
    }


}
