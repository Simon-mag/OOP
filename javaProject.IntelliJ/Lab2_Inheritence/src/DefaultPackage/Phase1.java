package DefaultPackage;
import ExplorersContent.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Phase1 {

    private ArrayList<SpaceExplorer> explorers = new ArrayList<>();
    private ArrayList<String> completedMissions = new ArrayList<>();

    private enum commands{
        menu,
        startMission,
        reportStatus,
        completeMission,
        exit;
    }

    public void startPhase1(){
        Scanner inputs = new Scanner(System.in);

        printStartPhase1();
        createExplorer(inputs);
        printListWithExplorers();

        missionControl(inputs);

        printMissionSummary();
        inputs.close();
    }

    public void createExplorer(Scanner input){
        Delay.slowOutForInput("Enter number of Explorers: ");
        int amount = input.nextInt();
        input.nextLine();

        for(int i = 1; i<=amount ; ++i){
            System.out.printf("Enter explorer number %d(s) name: ",i);
            String name = input.nextLine();
            System.out.printf("Enter %ss profession: ", name);
            String rank = input.nextLine().toLowerCase();
            System.out.printf("Enter %s %s(s) mission: ",rank,name);
            String mission = input.nextLine();
            System.out.println();
            Delay.delay();

            switch (rank) {
                case "pilot" -> explorers.add(new Pilot(name, mission));
                case "engineer" -> explorers.add(new Engineer(name, mission));
                case "astronaut" -> explorers.add(new Astronaut(name, mission));

                default -> explorers.add(new SpaceExplorer(name,rank,mission));
            }
        }
    }

    void printListWithExplorers(){
        Delay.slowOut("\n::Registry of explorers::");
        for (SpaceExplorer explorer : explorers) {
            Delay.delay();
            System.out.printf("-- ID: %d <> Rank: %-8s <> Name: %-6s <> Mission: %-10s --%n",
                    explorer.getId(), explorer.getProfession(), explorer.getName(), explorer.getMission());
        }
        System.out.println();
    }

    public void missionControl(Scanner input){

        int choice;

        while(true){
            printMenus(commands.menu);

            try{
                choice = input.nextInt();
                if(choice >= 1 && choice <=4) {
                    commands selectedCommand = switch (choice) {
                        case 1 -> commands.startMission;
                        case 2 -> commands.reportStatus;
                        case 3 -> commands.completeMission;
                        case 4 -> commands.exit;
                        default -> commands.menu;
                    };
                    printMenus(selectedCommand);
                    if(selectedCommand == commands.exit){
                        Delay.slowOut("<> Exiting Base Command Center <>\n");
                        break;
                    }
                }
                else
                    Delay.slowOut("Invalid option, choose from menu! (1-4)\n");
            }catch (InputMismatchException e){
                Delay.slowOut("Invalid input, choose from menu! (1-4)\n");
                input.nextLine();
            }
        }
    }

    private void printMenus(commands command) {

        switch(command){
            case menu -> {
                System.out.println();
                Delay.slowOut("<><   Base Command Center   ><>");
                Delay.delay();
                System.out.println("\n   =========================");
                System.out.println("   = 1: Start missions     =");
                System.out.println("   = 2: Mission status     =");
                System.out.println("   = 3: Complete missions  =");
                System.out.println("   = 4: Exit               =");
                System.out.println("   =========================");
                Delay.slowOutForInput("   Choose option (1-4):");
            }
            case startMission ->{
                Delay.slowOut("<> Accessing mission control <>");
                for(SpaceExplorer explorer : explorers)
                   explorer.startMission();
            }
            case reportStatus ->{
                Delay.slowOut("<> Accessing mission control <>");
                for(SpaceExplorer explorer : explorers)
                    explorer.reportStatus();
            }
            case completeMission ->{
                Delay.slowOut("<> Accessing mission control <>");
                for(SpaceExplorer explorer : explorers) {
                    completedMissions.add(explorer.getMission());
                    explorer.completeMission();
                }
            }
        }
        Delay.delay();
    }
    public void printStartPhase1(){
        Delay.slowOut("<><><><><><><><><><><><><><><>");
        Delay.slowOut("Initiating Phase 1: Explorers");
        Delay.slowOut("<><><><><><><><><><><><><><><>\n");
        Delay.slowOut("~~~~~~ Create your explorers ~~~~~~\n");
        Delay.delay();
    }

    void printMissionSummary(){
        Delay.slowOut("<><> Missions Completed <><>\n");
        for(String mission : completedMissions){
            Delay.slowOut("** " + mission + " \n");
        }
    }

}
