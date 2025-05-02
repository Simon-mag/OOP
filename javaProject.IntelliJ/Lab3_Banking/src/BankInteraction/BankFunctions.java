package BankInteraction;
import myExceptions.*;

public class BankFunctions {

    private double balance = 1000.0;

    public BankFunctions(){}
    public BankFunctions(double balance){this.balance = balance;}


    public void deposit(double amount) throws InvalidTransactionException {
        //assert (amount > 0) : "amount less or equal to zero";

        if(amount < 0)
            throw new InvalidTransactionException("Amount less or equal to zero");
        balance += amount;
    }

    public void withdraw(double amount) throws InvalidTransactionException{
       //assert ( amount > 0 && (balance-amount > 0) ) : "assert not enough balance!";

        if(amount <= 0) {
            throw new InvalidTransactionException("Must be a number higher than zero!");
        } else if(amount > balance) {
            throw new InvalidTransactionException("Not enough balance!");
        }else {
            balance -= amount;
            System.out.printf("Withdrew: %.2f kr %n", amount);
        }

    }

    public void transferMoney(double amount) throws InvalidTransactionException {
        //assert ( amount > 0 && (balance-amount > 0) ) : "not enough balance!";

        if(amount <= 0) {
            throw new InvalidTransactionException("Must be a positive number above zero");
        } else if(amount > balance) {
            throw new InvalidTransactionException("Can't transfer, insufficient funds");
        } else{
            balance -= amount;
            System.out.printf("Transferred: %.2f kr %n", amount);
        }

    }

    public void checkBalance(){System.out.printf("You have %.2f kr left in your account%n", balance);}

    public double getBalance(){return balance;}


    public void processTransaction(String transactionType, int amount) throws InvalidTransactionException {
        switch (transactionType) {
            case "Deposit": deposit(amount); break;
            case "Withdraw": withdraw(amount); break;
            case "Transfer": transferMoney(amount); break;
            default: throw new InvalidTransactionException(transactionType);
        }
    }

    public void printMenu(){
        System.out.println("---- Your Bank Menu ----\n");
        System.out.println("------------------------");
        System.out.println("---    Deposit       ---");
        System.out.println("---    Withdraw      ---");
        System.out.println("---    Transfer      ---");
        System.out.println("---    Balance       ---");
        System.out.println("---    Exit          ---");
        System.out.println("------------------------");
    }


}
