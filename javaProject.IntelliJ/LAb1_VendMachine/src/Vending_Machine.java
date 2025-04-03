import java.util.Scanner;

public class Vending_Machine {

    private final Beverage[] beverages;
    private double totalPrice;
    private int totalPurchases;

    public void run(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            displayMenu();
            int choice = scanner.nextInt();

            if(choice == beverages.length+1)
                break;

            if(choice > beverages.length+1 || choice < 1){
                System.out.println("\nInvalid choice, please enter number from the menu!\n");
                continue;
            }

            if(beverages[choice-1].getStock() == 0) {
                System.out.println("\nThis item is out of stock!\n");
                continue;
            }

            dispenceChoice(choice);
        }
        printSummary();
        scanner.close();
    }

    public Vending_Machine(Beverage[] list){
        this.beverages = list;
    }

    private void displayMenu(){

        System.out.println("Vending Menu:");
        int i = 1;
        for(Beverage temp : beverages){
            System.out.printf("%d. %-15s [%.1f] || Stock left: %d%n",i,temp.getName(),temp.getPrice(),temp.getStock());
            ++i;
        }
        System.out.printf("%d Exit the machine \nEnter Choice: ",i);
    }

    private void dispenceChoice(int choice){
        --choice;
        System.out.printf("Fetching %s >> Dispensed!%n%n", beverages[choice].getName());

        totalPrice += beverages[choice].getPrice();
        beverages[choice].increaseTimesSelected();
        beverages[choice].decreaseStock();
        ++totalPurchases;
    }

    private void printSummary(){

        System.out.printf("\n\nYou purchased %d items for a total of %.2f kr\n",totalPurchases, totalPrice);
        System.out.print("List of your choices:\n\n");
        for(Beverage temp : beverages) {
            System.out.printf("<> %-12s | %d time(s) <>\n",temp.getName(),temp.getTimesSelected());
        }
    }
}
