package myExceptions;

import java.util.InputMismatchException;

public class UnknownTransactionTypeException extends InputMismatchException {


    public UnknownTransactionTypeException(){
        super("Unknown transaction");

    }
    public UnknownTransactionTypeException(String text){
        super("Unknown Transaction: " + text);

    }

//    @Override
//    public String getMessage(){
//        return "!INVALID TYPE! Invalid Transaction Type: " + InvalidInput;
//    }

}
