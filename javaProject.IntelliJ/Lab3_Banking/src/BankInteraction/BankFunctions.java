package BankInteraction;
import UserInformation.User;
import UserInformation.UserDataBase;
import myExceptions.*;
import java.io.IOException;

public class BankFunctions {

    private final UserDataBase userDataBase = new UserDataBase();
    private final String username;

    public BankFunctions(User user){
        this.username = user.getUsername();
    }


    public void deposit(double amount) throws InvalidTransactionException {

        if(amount < 0)
            throw new InvalidTransactionException("Amount less or equal to zero");
        userDataBase.updateBalance(username, userDataBase.getBalance(username) + amount);

    }

    public void withdraw(double amount) throws InvalidTransactionException{

        double balance = userDataBase.getBalance(username);
        if(amount <= 0) {
            throw new InvalidTransactionException("Must be a number higher than zero!");
        } else if(amount >balance) {
            throw new InvalidTransactionException("Not enough balance!");
        }else {
            userDataBase.updateBalance(username,balance - amount);
        }

    }

    public void transferMoney(double amount) throws InvalidTransactionException {

        double balance = userDataBase.getBalance(username);
        if(amount <= 0) {
            throw new InvalidTransactionException("Must be a positive number above zero");
        } else if(amount > userDataBase.getBalance(username)) {
            throw new InvalidTransactionException("Can't transfer, insufficient funds");
        } else{
            balance -= amount;
            userDataBase.updateBalance(username,balance);
        }

    }

    public double getBalance(){
        return userDataBase.getBalance(username);
    }

    public void processTransaction(String transactionType, Double amount) throws InvalidTransactionException, IOException {
        switch (transactionType) {
            case "Deposit": deposit(amount); break;
            case "Withdraw": withdraw(amount); break;
            case "Transfer": transferMoney(amount); break;
            default: throw new InvalidTransactionException(transactionType);
        }
        userDataBase.logTransaction(username,transactionType,amount);
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
