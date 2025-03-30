package Utils;

public class HelpFunctions {
    public static int[] reverseArray(int[] original){
        int length = original.length;
        int[] reversed = new int [length];

        for(int i=0; i<original.length; ++i){
            reversed[i] = original[length-1];
            --length;
        }

        return reversed;
    }

    public static void printArray(int[] array){
        int size = array.length;
        System.out.print("( ");
        for(int i=0; i<size; ++i) {
            if(i == size-1) {
                System.out.print(array[i] + " ");
                continue;
            }
            System.out.print(array[i] + ", ");

        }
        System.out.println(")");
    }
}
