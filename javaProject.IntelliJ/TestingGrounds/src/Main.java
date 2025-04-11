
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        Scanner x = new Scanner(System.in);
        testaPrintf print = new testaPrintf();

        System.out.println("Hello and welcome too my crejsy java functions!");

         print.printPersonInfo(Animal.iAmCat());
         print.printPersonInfo(Animal.iAmDog());


    }


}