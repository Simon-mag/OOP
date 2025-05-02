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
        int choice;

        System.out.println("Welcome to Your Personal Bank App!\n");
        while (true) {
            bankFunctions.printMenu();

            try {
                choice = handleTransaction(input);
                if(choice == 5){ break; }
                handleChoice(choice,input);
            }
            catch (InvalidTransactionException | InputMismatchException | NumberFormatException e){
                errorHistory.add(e);
                System.out.println(e.getMessage());
            }catch (Exception e){
                errorHistory.add(e);
                System.out.println("Unexpected error occurred: " + e.getMessage());
            }
            finally {
                System.out.println("--Logging action--\n\n");
            }
        }
        printErrors();
        input.close();
        System.out.println("Exiting Bank...");
    }


    private int handleTransaction(Scanner input) throws UnknownTransactionTypeException{
        System.out.print("Choose Transaction: ");
        String choice = "";
        int transaction;
        try {
            choice = input.nextLine();
            transaction = Integer.parseInt(choice);
        }catch (NumberFormatException e){
            throw new UnknownTransactionTypeException(choice);
        }
        return transaction;
    }


    private void handleChoice(int choice, Scanner input){
        switch (choice) {
            case 1 -> bankFunctions.deposit(handleAmountInput(input));
            case 2 -> bankFunctions.withdraw(handleAmountInput(input));
            case 3 -> bankFunctions.transferMoney(handleAmountInput(input));
            case 4 -> bankFunctions.checkBalance();
            default -> {
                System.out.println("Choose From Menu!\n");
                throw new UnknownTransactionTypeException(choice + "");
            }
        }
    }

    private double handleAmountInput(Scanner input) throws NumberFormatException{
        System.out.print("Enter amount: ");
        String amount;
        double amountValue;
        try {
            amount = input.nextLine().trim();
            amountValue = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid input! (must be a number)\n");

        }
        return (amountValue);
    }
    
    private void printErrors(){
        System.out.println("--- Tracing of Caught Errors during session ---");
        for (Throwable error : errorHistory) {
            System.out.println("\n<><><><><><><><><><><><><><><><><><><><><><><><><>");
            error.printStackTrace(System.out);
        }
    }

}

