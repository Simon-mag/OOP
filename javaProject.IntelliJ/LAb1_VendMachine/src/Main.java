
public class Main {
    public static void main(String[] args) {

        Beverage[] beverages = LoadMachine.fill(8); // Max 5
        VendingMachine myMachine = new VendingMachine(beverages);
        myMachine.run();
    }
}