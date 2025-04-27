package BankInteraction;

import myExceptions.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankUI {
    ArrayList<Throwable> errorHistory = new ArrayList<>();
    BankFunctions bankFunctions = new BankFunctions();

    public void run() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        double amount;
        boolean run = true;

        while (run) {

            bankFunctions.printMenu();
            try {
                choice = input.nextInt();
                input.nextLine();
                switch (choice) {

                    case 1 -> bankFunctions.deposit(handleAmountInput(input));
                    case 2 -> bankFunctions.withdraw(handleAmountInput(input));
                    case 3 -> bankFunctions.transferMoney(handleAmountInput(input));
                    case 4 -> bankFunctions.checkBalance();
                    case 5 -> run = false;
                    default -> throw new UnknownTransactionTypeException("Invalid menu choice!");
                }
            }catch (InvalidTransactionException e){
                InsertErrors(e);
                System.out.println("%s must be Positive!\n");
            }
            catch (UnknownTransactionTypeException e){
                InsertErrors(e);
                System.out.println("Invalid input, choose from menu!\n");
            } catch (InputMismatchException e){
                InsertErrors(e);
                input.nextLine();
                System.out.printf("Invalid type: %s!",e);
            } finally {
                System.out.println("--Logging action--\n\n");
            }
        }
        input.close();
    }

    private double handleAmountInput(Scanner input){
        System.out.print("Enter amount: ");
        String amount = "";
        double intAmount = 0;

        try {
            amount = input.nextLine().trim();
            intAmount = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            errorHistory.add(e);
            System.out.println("Invalid input! (must be a number)");
        }
        return (intAmount);
    }

    private void InsertErrors(Exception e){
        //e.printStackTrace();
        errorHistory.add(e);
    }
}

