package BankInteraction;

import myExceptions.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankUI {
    ArrayList<Throwable> errorHistory = new ArrayList<>();
    BankFunctions bankFunctions = new BankFunctions(100);

    public void run() {
        Scanner input = new Scanner(System.in);
        String choice;

        System.out.println("Welcome to Your Personal Bank App!\n");
        while (true) {
            bankFunctions.printMenu();

            try {
                choice = handleTransaction(input);
                if(choice.equals("exit")){ break; }
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


    private String handleTransaction(Scanner input) throws UnknownTransactionTypeException{
        System.out.print("Choose Transaction: ");
        String choice = "";

        try {
            choice = input.nextLine().trim();
        }catch (NumberFormatException e){
            throw new UnknownTransactionTypeException(choice);
        }
        return choice.toLowerCase();
    }


    private void handleChoice(String choice, Scanner input){
        switch (choice) {
            case "deposit" -> bankFunctions.deposit(handleAmountInput(input));
            case "withdraw" -> bankFunctions.withdraw(handleAmountInput(input));
            case "transfer" -> bankFunctions.transferMoney(handleAmountInput(input));
            case "balance" -> bankFunctions.checkBalance();
            default -> {
                System.out.println("Choose From Menu!\n");
                throw new UnknownTransactionTypeException(choice);
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

