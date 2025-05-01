package BankInteraction;
import myExceptions.*;

public class BankFunctions {

    private double balance = 1000.0;

    public BankFunctions(){}
    public BankFunctions(double balance){this.balance = balance;}


    public void deposit(double amount) throws InvalidTransactionException {
        //assert (amount > 0) : "amount less or equal to zero";

        if(amount > 0)
            balance += amount;
        else
            throw new InvalidTransactionException("Amount less or equal to zero");
    }

    public void withdraw(double amount) throws InvalidTransactionException{
        //assert ( amount > 0 && (balance-amount > 0) ) : "not enough balance!";

        if( amount > 0 && (balance-amount >= 0) ) {
            balance -= amount;
            System.out.printf("Withdrew: %.2f kr %n",amount);
        }
        else {
            if(amount <= 0)
                throw new InvalidTransactionException("Must be a number higher than zero!");
            throw new InvalidTransactionException("Not enough balance!");
        }
    }

    public void transferMoney(double amount) throws InvalidTransactionException {
        //assert ( amount > 0 && (balance-amount > 0) ) : "not enough balance!";

        if(amount > 0 && balance-amount >= 0) {
            balance -= amount;
            System.out.printf("Transferred: %.2f kr %n",amount);
        }
        else{
            if (amount <= 0)
                throw new InvalidTransactionException("Must be a positive number above zero");
            throw new InvalidTransactionException("Can't transfer, insufficient funds");
        }
    }

    public void checkBalance(){System.out.printf("You have %.2f kr left in your account%n", balance);}

    public double getBalance(){return balance;}


    public void processTransaction(String transactionType, int amount){
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
        System.out.println("--- 1: Deposit       ---");
        System.out.println("--- 2: withdraw      ---");
        System.out.println("--- 3: Transfer      ---");
        System.out.println("--- 4: check balance ---");
        System.out.println("--- 5: Exit          ---");
        System.out.println("------------------------");
    }


}
