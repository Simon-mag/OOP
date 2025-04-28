package myExceptions;

import java.util.InputMismatchException;

public class UnknownTransactionTypeException extends InputMismatchException {
    private final String InvalidInput;

    public UnknownTransactionTypeException(){
        super();
        this.InvalidInput = "";
    }
    public UnknownTransactionTypeException(String text){
        super();
        this.InvalidInput = text;
    }

    @Override
    public String getMessage(){
        return "!INVALID TYPE! Invalid Transaction Type: " + InvalidInput;
    }

}
