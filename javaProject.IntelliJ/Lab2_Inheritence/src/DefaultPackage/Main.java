package DefaultPackage;
import java.util.Scanner;
import ExplorersContent.*;

public class Main {
    public static void main(String[] args) {
        Phase1 phase1 = new Phase1();
        Phase2 phase2 = new Phase2();

        Delay.slowOut("\n<><> Welcome to the Space Mission Simulator <><>\n");
        //phase1.startPhase1();
        phase2.startPhase2();


        Delay.delay();
    }
}