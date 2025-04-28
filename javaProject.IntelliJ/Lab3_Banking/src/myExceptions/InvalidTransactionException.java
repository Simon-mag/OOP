package myExceptions;

public class InvalidTransactionException extends RuntimeException{
    private final String invalidInput;

    public InvalidTransactionException(){
        super();
        this.invalidInput = "";
    }
    public InvalidTransactionException(String text){
        super("Transaction error: " + text);
        this.invalidInput = text;
    }

    @Override
    public String getMessage(){
        return "Transaction error: " + invalidInput;
    }

}
