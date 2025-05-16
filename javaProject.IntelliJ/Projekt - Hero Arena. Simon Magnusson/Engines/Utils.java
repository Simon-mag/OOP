package Engines;
import java.util.Random;

public class Utils {
    private static final Random random = new Random();


    // Returns true with the given percentage chance
    public static boolean chance(int percent) {
        if (percent < 0) return false;
        if (percent >= 100) return true;
        return random.nextInt(100) < percent;
    }
}