package DefaultPackage;
import java.util.Scanner;
import ExplorersContent.*;

public class Main {
    public static void main(String[] args) {
        Phase1 phase1 = new Phase1();

        Delay.slowOut("\n<><> Welcome to the space mission simulator <><>\n");
        phase1.startPhase1();


        Delay.delay();
    }
}