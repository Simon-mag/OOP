package myExceptions;

import java.util.InputMismatchException;

public class UnknownTransactionTypeException extends InputMismatchException {

    public UnknownTransactionTypeException(){super();}
    public UnknownTransactionTypeException(String text){
        super("!INVALID TYPE! Invalid transaction type: " + text);
    }

}
