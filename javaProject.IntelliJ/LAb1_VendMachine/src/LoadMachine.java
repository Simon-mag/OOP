import java.util.Random;

public class LoadMachine {

    public static Beverage[] fill(int size){
        Random random = new Random();
        Beverage[] template = {
                new Beverage("Cola",25,random.nextInt(20)+1),
                new Beverage("Fanta",20,random.nextInt(20)+1),
                new Beverage("Capri-Sonne",10,random.nextInt(20)+1),
                new Beverage("Vatten",10,random.nextInt(20)+1),
                new Beverage("Fanta Exotic",50,random.nextInt(20)+1)
        };
        Beverage[] beverages = new Beverage[size];

        for(int i = 0 ; i < size ; i++){
            Beverage temp = template[i % template.length];
            temp.setStock(random.nextInt(20)+1);
            beverages[i] = temp;
        }
        return beverages;
    }
}
