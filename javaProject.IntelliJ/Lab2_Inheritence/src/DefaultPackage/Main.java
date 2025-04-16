package DefaultPackage;

public class Main {
    public static void main(String[] args) {
        Phase1 phase1 = new Phase1();
        Phase2 phase2 = new Phase2();
        Phase2User phase2User = new Phase2User();

        Delay.slowOut("\n<><> Welcome to the Space Mission Simulator <><>\n");
        phase1.startPhase1();
        phase2.startPhase2();
        phase2User.startPhase2();

        Delay.delay();
    }
}