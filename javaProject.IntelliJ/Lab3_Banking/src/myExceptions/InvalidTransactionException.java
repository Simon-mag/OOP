package myExceptions;

public class InvalidTransactionException extends Exception{

    public InvalidTransactionException(){
        super("Transaction is invalid");
    }
    public InvalidTransactionException(String text){super("Transaction error: " + text);}
}
