package myExceptions;

import java.util.InputMismatchException;

public class UnknownTransactionTypeException extends InputMismatchException {

    public UnknownTransactionTypeException(){super();}
    public UnknownTransactionTypeException(String text){
        super("Invalid transaction type " + text);

    }
}
