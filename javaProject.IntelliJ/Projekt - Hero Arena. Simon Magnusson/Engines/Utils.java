package Engines;
import java.util.Random;
import java.util.Scanner;

public class Utils {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    // Returns true with the given percentage chance //
    public static boolean chance(int percent) {
        if (percent < 0) return false;
        if (percent >= 100) return true;
        return random.nextInt(100) < percent;
    }
    // Pause the game and wait for Enter input //
    public static void pause(){
        System.out.print("Press Enter to continue ->");
        scanner.nextLine();
    }
}