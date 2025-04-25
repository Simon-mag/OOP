package BankInteraction;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankUI {
    ArrayList<Throwable> errorHistory = new ArrayList<>();
    BankFunctions bankFunctions = new BankFunctions();

    public void Run() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        double amount;


        while (true) {

            bankFunctions.printMenu();
            try {
                choice = input.nextInt();
                amount = handleAmountInput(input);
                switch (choice) {

                    case 1 -> bankFunctions.deposit(amount);
                    case 2 -> bankFunctions.withdraw(amount);
                    case 3 -> bankFunctions.transferMoney(amount);
                    case 4 -> bankFunctions.checkBalance();
                    case 5 -> break;
                    default -> throw Exception;
                }
            }

//            } catch (InputMismatchException e){
//                System.out.println("Invalid input, choose from menu!\n");
//                continue;
//            } catch (Exception e) {
//                errorHistory.add(e);
//                throw new RuntimeException(e);
//            } finally {
//                System.out.println("--Logging action--");
//            }


        }
    }

    private double handleAmountInput(Scanner input){
        System.out.println("Enter amount: ");
        String amount = "";
        double intAmount = 0;

        try {
            amount = input.nextLine().trim();
            intAmount = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! (must be a number)");
        }
        return (intAmount);
    }
}

