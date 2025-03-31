public class testaPrintf {

    public void printPersonInfo(String name){

        char firstLetter = 'S';
        int age = 27;
        boolean student = true;
        double weight = 92.1;
        double height = 192;

        System.out.println("Now we are going to test and print out info with: \n % markings!\n");

        System.out.printf("%s is %d years old and is %.2f cm tall\n",name ,age, height);
        System.out.printf("%s is %.2f kilo and his name starts with a: %c\n\n",name, weight, firstLetter);
        System.out.printf("It is %b that %s is a student!\n\n",student, name);

        double x = 123456789.98765;
        double negativeX = -123456.9876;

        System.out.printf("+ sign: %+.1f\n" , x );
        System.out.printf("-20 sign: %-20.2f\n" , x );
        System.out.printf("20 sign: %20.2f\n" , x );
        System.out.printf("( sign: %(.3f\n" , negativeX );
        System.out.printf("space sign: % .4f and % .5f\n" , x ,negativeX);

        int z1 = 2;
        int z2 = 43;
        int z3 = 659;
        int z4 = 1234;

        System.out.println("\ntesting with moving around different length variables...\n");

        System.out.printf("%04d\n", z1);
        System.out.printf("%04d\n", z2);
        System.out.printf("%04d\n", z3);
        System.out.printf("%04d\n", z4);

        System.out.printf("%-4d\n", z1);
        System.out.printf("%-4d\n", z2);
        System.out.printf("%-4d\n", z3);
        System.out.printf("%-4d\n", z4);
    }
    /*
    %[Flags][Width][.Precision][what type of data]

    [width]
    positive number = right shift
    negative number = left shift
    0 = Zero padding (%04d with a 2 = 0002)

    [Flags]
    + = output positive or negative number
    ( = negative numbers are enclosed in ()
    space = display a minus if negative and + if positive

     */

}
