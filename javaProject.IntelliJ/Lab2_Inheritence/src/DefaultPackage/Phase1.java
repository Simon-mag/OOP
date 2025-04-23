package DefaultPackage;
import ExplorersContent.*;
import Missions.Mission;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Phase1 {

    ArrayList<SpaceExplorer> explorers = new ArrayList<>();
    private final ArrayList<Mission> completedMissions = new ArrayList<>();

    private enum commands{
        menu,
        create,
        startMission,
        reportStatus,
        completeMission,
        exit
    }

    public void startPhase1(){
        Scanner inputs = new Scanner(System.in);

        printStartPhase1();
        createExplorer(inputs);
        missionControl(inputs);
        printMissionSummary(completedMissions);

        inputs.close();
    }



    private void createExplorer(Scanner input){
        Delay.slowOutForInput("Enter number of Explorers: ");
        int amount = input.nextInt();
        input.nextLine();


        for(int i = 1; i<=amount ; ++i){
            System.out.printf("Enter explorer number %d(s) name: ",i);
            String name = input.nextLine();
            System.out.printf("Enter %ss profession: ", name);
            String rank = input.nextLine().toLowerCase();
            System.out.printf("Enter %s %s(s) mission: ",rank,name);
            String missionName = input.nextLine();
            System.out.println();
            Delay.delay();
            Mission mission = new Mission(missionName);

            switch (rank) {
                case "pilot" -> explorers.add(new Pilot(name, mission));
                case "engineer" -> explorers.add(new Engineer(name, mission));
                case "astronaut" -> explorers.add(new Astronaut(name, mission));
                case "commander" -> explorers.add(new Commander(name,mission));

                default -> {
                    return;
                }
            }
        }
        printListWithExplorers();
    }

    private void printListWithExplorers(){
        Delay.slowOut("\n::Registry of explorers::");
        for (SpaceExplorer explorer : explorers) {
            Delay.delay();
            System.out.printf("-- ID: %d <> Rank: %-8s <> Name: %-6s <> Mission: %-10s --%n",
                    explorer.getId(), explorer.getProfession(), explorer.getName(), explorer.getMission().getName());
        }
        Delay.delay();
        System.out.println();
    }

    private void missionControl(Scanner input){
        int choice;

        while(true){
            printMenus(commands.menu,input);

            try{
                choice = input.nextInt();
                if(choice >= 1 && choice <=5) {
                    commands selectedCommand = switch (choice) {
                        case 1 -> commands.create;
                        case 2 -> commands.startMission;
                        case 3 -> commands.reportStatus;
                        case 4 -> commands.completeMission;
                        case 5 -> commands.exit;
                        default -> commands.menu;
                    };
                    printMenus(selectedCommand, input);
                    if(selectedCommand == commands.exit){
                        Delay.slowOut("<> Exiting Base Command Center <>\n");
                        break;
                    }
                }
                else
                    Delay.slowOut("Invalid option, choose from menu! (1-5)\n");
            }catch (InputMismatchException e){
                Delay.slowOut("Invalid input, choose from menu! (1-5)\n");
                input.nextLine();
            }
        }
    }

    private void printMenus(commands command,Scanner input) {

        switch(command){
            case menu -> {
                System.out.println();
                Delay.slowOut("<><   Base Command Center   ><>");
                Delay.delay();
                System.out.println("\n   =========================");
                System.out.println("   = 1: Create explorers   =");
                System.out.println("   = 2: Start missions     =");
                System.out.println("   = 3: Mission status     =");
                System.out.println("   = 4: Complete missions  =");
                System.out.println("   = 5: Exit               =");
                System.out.println("   =========================");
                Delay.slowOutForInput("   Choose option (1-5):");
            }
            case create -> createExplorer(input);

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
                    if(explorer.getOnMission())
                        completedMissions.add(explorer.getMission());
                    explorer.completeMission();
                }
            }
        }
        Delay.delay();
    }
    private void printStartPhase1(){
        Delay.slowOut("<><><><><><><><><><><><><><><>");
        Delay.slowOut("Initiating Phase 1: Explorers");
        Delay.slowOut("<><><><><><><><><><><><><><><>\n");
        Delay.slowOut("~~~~~~ Create your explorers ~~~~~~\n");
        Delay.delay();
    }

    public void printMissionSummary(ArrayList<Mission> completedMissions){
        Delay.slowOut("<><> Missions Completed <><>\n");
        for(Mission mission : completedMissions){
            Delay.slowOut("** " + mission.getName() + " \n");
        }
    }
}
