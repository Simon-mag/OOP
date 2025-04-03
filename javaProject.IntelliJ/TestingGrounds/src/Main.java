
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        Scanner x = new Scanner(System.in);
        testaPrintf print = new testaPrintf();
        Account myAccount = new Account("Simon", 321.4,true);
        Time1 myTime1 = new Time1();

        System.out.println("Hello and welcome too my crejsy java functions!");

        // print.printPersonInfo(Animal.iAmCat());
        // print.printPersonInfo(Animal.iAmDog());

      /*  System.out.printf("Initial name is: %s\n%n", myAccount.getName());
        System.out.printf("this Employee is hired?: %b\n", myAccount.isEmployed());
        System.out.printf("He has a balance of: %03.2f\n", myAccount.currentBalance());
        System.out.print("Lets add some balance, enter amount: ");

        if(x.hasNextDouble()){
           myAccount.addBalance(x.nextDouble());
           x.nextLine();
        }
        else{
           System.out.println("Invalid input, enter a number with the \",\" sign!");
           x.nextLine();
        }
        System.out.printf("\nNow he has a balance of: %.2f\n%n", myAccount.currentBalance());
        System.out.printf("Summary::\nName: %20s\nBalance: %+20.2f\nIs an Employee: %20b", myAccount.getName(),myAccount.currentBalance(),myAccount.isEmployed());
*/
        System.out.println("This is your 0:st time: " + myTime1.convertUniversal());

        myTime1.setTime(23,59,59);

        System.out.println("This is your 1:st time: " + myTime1.convertUniversal());
        try {
            myTime1.setTime(40, 23, 10);
        }
        catch (IllegalArgumentException e){
            System.out.printf("Exception: %s%n%n", e.getMessage());
        }
        
        System.out.println("This is your 2:nd time: " + myTime1.convertUniversal());




        x.close();
    }
}