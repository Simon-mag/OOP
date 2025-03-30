import Utils.HelpFunctions;
import java.util.Scanner;
import java.util.Random;



public class Lab0 {
    public void CompareValues(Scanner amount) {

        System.out.print("please enter the amount of numbers:");
        int size = amount.nextInt();
        int[] values = new int[size];

        for(int i = 0;i<size; ++i){
            System.out.print("Enter number " + (i + 1) + ": ");
            values[i] = amount.nextInt();
        }

        int max = values[0];
        int min = values[0];

        for(int j = 0; j<size; ++j){
            if (values[j] < min)
                min = values[j];
            if (values[j] > max)
                max = values[j];
        }

        System.out.println("The biggest value was: "+max);
        System.out.println("The smallest value was: "+min);
    }


    public void factorial(Scanner input){

        System.out.print("Enter a number you want to factorialise: ");
        int facValue = input.nextInt();
        if(facValue < 0) {
            System.out.println("invalid input: " + facValue);
            return;
        }
        int value = facValue;
        long sum = 1;

        for(;facValue != 0; --facValue)
            sum *= facValue;

        System.out.println("the factorial value of " + value + " is: " + sum);
    }

    public void divisionBy5 (Scanner input){

        System.out.println("Enter 2 numbers, then we check if they can be evenly divided by 5!");
        System.out.print("Number 1:"); int x = input.nextInt();
        System.out.print("Number 2:"); int y = input.nextInt();

        if((x*y) % 5 == 0)
            System.out.println("1");
        else
            System.out.println("0");
    }

    public static String fractionAdd(int n1, int d1, int n2, int d2){

        n1 = n1 * d2;
        n2 = n2 * d1;
        d1 = d1 * d2;
        int sumNominators = n1 + n2;
        double result = sumNominators / (double)d1;

        return sumNominators + " / " + d1 + " = " + result;
    }

    public void arrayReversing(){

        Random rand = new Random(System.currentTimeMillis());
        int size = 5;
        int[] numbers = new int[size];

        for(int i=0; i<size; ++i)
            numbers[i] = rand.nextInt(100);

        HelpFunctions.printArray(numbers);
        numbers = HelpFunctions.reverseArray(numbers);
        HelpFunctions.printArray(numbers);
    }


}
