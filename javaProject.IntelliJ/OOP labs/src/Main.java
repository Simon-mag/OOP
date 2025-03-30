import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Lab0 test = new Lab0();

        test.factorial(scanner);
        test.CompareValues(scanner);

        String division = Lab0.fractionAdd(2,3,5,6);
        System.out.println(division);

        test.arrayReversing();

        scanner.close();
    }
}