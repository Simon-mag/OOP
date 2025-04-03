import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Lab0 test0 = new Lab0();

       // LAB0 TESTERS
        test0.factorial(scanner);
        test0.CompareValues(scanner);
        String division = Lab0.fractionAdd(2,3,5,6);
        System.out.println(division);
        test0.arrayReversing();


        scanner.close();
    }
}