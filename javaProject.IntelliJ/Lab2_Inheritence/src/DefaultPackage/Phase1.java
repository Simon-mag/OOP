package DefaultPackage;
import ExplorersContent.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Phase1 {

    private ArrayList<SpaceExplorer> explorers = new ArrayList<>();
    private ArrayList<String> completedMissions = new ArrayList<>();

    private enum commands{
        command,
        startMission,
        reportStatus,
        completeMission,
        exit;
    }

    public void startPhase1(){
        Scanner inputs = new Scanner(System.in);
        System.out.println("<><><><><><><><><><><><><><><>");
        System.out.println("Initiating Phase 1: Explorers");
        System.out.println("<><><><><><><><><><><><><><><>\n");
        Delay.delay();
        System.out.println("~~~~~~ Create your explorers ~~~~~~\n");
        Delay.delay();

        createExplorer(inputs);
        printListWithExplorers();

        missionControl(inputs);


        inputs.close();
    }

    public void createExplorer(Scanner input){
        System.out.print("Enter number of Explorers: ");
        int amount = input.nextInt();
        input.nextLine();

        for(int i = 1; i<=amount ; ++i){
            System.out.printf("Enter explorer number %d(s) name: ",i);
            String name = input.nextLine();
            System.out.printf("Enter %ss rank: ", name);
            String rank = input.nextLine().toLowerCase();
            System.out.printf("Enter %s %s(s) mission: ",rank,name);
            String mission = input.nextLine();

            switch (rank) {
                case "pilot" -> explorers.add(new Pilot(name, mission));
                case "engineer" -> explorers.add(new Engineer(name, mission));
                case "astronaut" -> explorers.add(new Astronaut(name, mission));

                default -> explorers.add(new SpaceExplorer(name,rank,mission));
            }
        }
    }

    void printListWithExplorers(){
        System.out.println("\n\n::Registry of explorers::");
        for (SpaceExplorer explorer : explorers) {
            Delay.delay();
            System.out.printf("-- ID: %d <> Rank: %-8s <> Name: %-6s <> Mission: %-10s --%n",
                    explorer.getId(), explorer.getRank(), explorer.getName(), explorer.getMission());
        }
    }

    public void missionControl(Scanner input){
        System.out.println("<> Welcome to mission control <>");
        Delay.delay();

        System.out.println("=====================");
        System.out.println("= 1: Start missions =");
        System.out.println("=====================");
        System.out.println("=================");
        System.out.println("=================");
        System.out.println("=====================");


    }


}
