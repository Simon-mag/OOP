
public class Main {
    public static void main(String[] args) {

        Beverage[] beverages = LoadMachine.fill(5);
        Vending_Machine myMachine = new Vending_Machine(beverages);
        myMachine.run();
    }
}