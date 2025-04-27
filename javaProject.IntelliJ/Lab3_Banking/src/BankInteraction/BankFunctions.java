package BankInteraction;
import myExceptions.*;

public class BankFunctions {

    private double balance;

    public BankFunctions(){}
    public BankFunctions(double balance){this.balance = balance;}


    public void deposit(double amount) throws UnknownTransactionTypeException {
        //assert (amount > 0) : "amount less or equal to zero";

        if(amount > 0)
            balance += amount;
        else
            throw new UnknownTransactionTypeException("amount less or equal to zero");
    }

    public void withdraw(double amount) throws UnknownTransactionTypeException{
        //assert ( amount > 0 && (balance-amount > 0) ) : "not enough balance!";

        if( amount > 0 && (balance-amount > 0) )
            balance -= amount;
        else
            throw new UnknownTransactionTypeException("not enough balance");
    }
    public void transferMoney(double amount) throws InvalidTransactionException {
        try {
            withdraw(amount);
        }catch (Exception e){
            e.printStackTrace();
            throw new InvalidTransactionException("Can't transfer, insufficient funds");
        }
    }

    public void checkBalance(){System.out.printf("You have %.2f kr left in your account%n", balance);}

    public void printMenu(){
        System.out.println("---- Your Bank Menu ----\n");
        System.out.println("------------------------");
        System.out.println("--- 1: Deposit       ---");
        System.out.println("--- 2: withdraw      ---");
        System.out.println("--- 3: Transfer      ---");
        System.out.println("--- 4: check balance ---");
        System.out.println("--- 5: Exit          ---");
        System.out.println("------------------------");
        System.out.print("Choose Transaction: ");
    }


}
