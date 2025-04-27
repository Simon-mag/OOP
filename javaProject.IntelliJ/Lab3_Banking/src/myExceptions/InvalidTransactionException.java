package myExceptions;

public class InvalidTransactionException extends RuntimeException{

    public InvalidTransactionException(){super();}
    public InvalidTransactionException(String text){
        super("Invalid Transaction Type: " + text);
    }

}
