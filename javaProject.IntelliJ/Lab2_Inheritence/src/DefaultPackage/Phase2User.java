package DefaultPackage;
import ExplorersContent.*;
import Missions.ExplorationMission;
import Missions.MaintenaceMission;
import Missions.Mission;
import Vehicles.Rocket;
import Vehicles.SpaceVehicle;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Phase2User {
    private ArrayList<Commander> commanders;
    private ArrayList<Mission> completedMissions;

    private enum commands{
        menu,
        startMission,
        reportStatus,
        completeMission,
        exit
    }

    public void startPhase2(){
        Scanner input = new Scanner(System.in);
        commanders = new ArrayList<>();
        completedMissions = new ArrayList<>();

        printStartPhase2();

        createTeams(input);
        printTeams();

        commandCenter(input);

        printSummary();
        input.close();
    }

    private void commandCenter(Scanner input){
        int choice;

        while(true){
            printMenus(commands.menu);

            try{
                choice = input.nextInt();
                if(choice >= 1 && choice <= 5){
                    commands selectedCommand = switch (choice){
                        case 1 ->commands.startMission;
                        case 2 ->commands.reportStatus;
                        case 3 ->commands.completeMission;
                        case 4 ->commands.exit;
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

    private void createTeams(Scanner input){
        for(int i = 1; i <= 2; ++i) {
            if(i == 1){
                SpaceVehicle explorationRocket = new Rocket();
                Delay.slowOut("\nTeam 1: [Discover new planet]\n");
                Mission explorationMission = new ExplorationMission(
                        "Saturn",
                        300,
                        "Discover new Planet",
                        explorationRocket
                );
                Delay.slowOutForInput("Enter name for Commander: ");
                String name = input.nextLine();
                Delay.slowOut("Nice! Commander " + name + " Needs some team members!\n");
                Commander exploreCommander = new Commander(
                        name,
                        explorationMission,
                        createCommanderTeam(input,explorationMission)
                );
                commanders.add(exploreCommander);
            }
            else {
                SpaceVehicle maintenanceRocket = new Rocket();
                Delay.slowOut("\nTeam 2: [Restoring Mars Base]\n");
                Mission maintenanceMission = new MaintenaceMission(
                        "Mars",
                        100,
                        "Restoring Mars Base",
                        maintenanceRocket
                );
                Delay.slowOutForInput("Enter name for Commander: ");
                String name = input.nextLine();
                Delay.slowOut("Splendid! Let's create Commander " + name + "'s team");
                Commander maintenaceCommander = new Commander(
                        name,
                        maintenanceMission,
                        createCommanderTeam(input,maintenanceMission)
                );
                commanders.add(maintenaceCommander);
            }
        }
    }

    private SpaceExplorer[] createCommanderTeam(Scanner input, Mission mission){
        SpaceExplorer[] crewMembers = new SpaceExplorer[3];
        for(int i = 0; i<3; ++i){

            switch (i){
                case 0 -> {
                    Delay.slowOutForInput("Enter your Astronaut's name: ");
                    String name = input.nextLine();
                    crewMembers[i] = new Astronaut(name, mission);
                }
                case 1 ->{
                    Delay.slowOutForInput("Enter your Pilot's name: ");
                    String name = input.nextLine();
                    crewMembers[i] = new Pilot(name,mission);
                }
                case 2 ->{
                    Delay.slowOutForInput("Enter your Engineer's name: ");
                    String name = input.nextLine();
                    crewMembers[i] = new Engineer(name,mission);
                }
                default -> {return crewMembers;}
            }
        }
        return crewMembers;
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

            case startMission -> {
                Delay.slowOut("<> Accessing mission control <>");
                int selectedTeam = teamSelector();
                if (selectedTeam == 1)
                    commanders.getFirst().startMission();
                if(selectedTeam == 2)
                    commanders.get(1).startMission();
            }

            case reportStatus ->{
                Delay.slowOut("<> Accessing mission control <>");
                int selectedTeam = teamSelector();
                if (selectedTeam == 1)
                    commanders.getFirst().reportStatus();
                if(selectedTeam == 2)
                    commanders.get(1).reportStatus();
            }
            case completeMission ->{
                Delay.slowOut("<> Accessing mission control <>");
                int selectedTeam = teamSelector();
                Commander selectedCommander;
                if (selectedTeam == 1)
                    selectedCommander = commanders.getFirst();
                else
                    selectedCommander = commanders.get(1);

                selectedCommander.completeMission();
                if(!selectedCommander.getOnMission())
                    completedMissions.add(selectedCommander.getMission());
            }

        }
        Delay.delay();
    }

    private int teamSelector(){
        Scanner input = new Scanner(System.in);
        while(true) {
            Delay.slowOut("<> Choose team <>");
            if(commanders.getFirst().getOnMission())
                Delay.slowOut("1. " + commanders.getFirst().getMission().getName() + " [Active]");
            else
                Delay.slowOut("1. " + commanders.getFirst().getMission().getName() + " [Inactive]");
            if (commanders.get(1).getOnMission())
               Delay.slowOut("2. " + commanders.get(1).getMission().getName() + " [Active]");
            else
                Delay.slowOut("2. " + commanders.get(1).getMission().getName() + " [Inactive]");

            Delay.slowOutForInput("Enter: ");
            try {
                int selectedTeam = input.nextInt();
                if(selectedTeam == 1 || selectedTeam == 2)
                    return selectedTeam;
                else
                    Delay.slowOut("Invalid input, Choose from team menu!\n");
            }catch (InputMismatchException e){
                Delay.slowOut("Invalid input, choose from team menu!\n");
                input.nextLine();
            }
        }
    }


    private void printStartPhase2(){
        Delay.slowOut("<><> You are tasked with completing 2 Missions <><>");
        Delay.delay();
        Delay.slowOut("<> Mission 1 <> Discover new planet <>\n<> Mission 2 <> Restoring Mars Base <>\n");
        Delay.delay();
        Delay.slowOut("You will need a team for each mission!");
        Delay.delay();
        Delay.slowOut("Time to create your teams!\n");
    }

    private void printTeams(){
        Delay.slowOut("\n   :::::: Your teams ::::::");
        for(Commander commander : commanders){
            System.out.printf("%n%s Team is led by %s %s ID: %d%n",
                    commander.getMission().getDestination(),
                    commander.getProfession(),
                    commander.getName(),
                    commander.getId()
            );
            Delay.slowOut("\n     :: With crew ::");
            for(SpaceExplorer teamMember : commander.getTeam())
                System.out.printf("-- ID: %d <> Rank: %-9s <> Name: %-6s <> Mission: %-10s --%n",
                        teamMember.getId(),
                        teamMember.getProfession(),
                        teamMember.getName(),
                        teamMember.getMission().getName()
                );
        }
    }
    private void printSummary(){
        Delay.slowOut("<><> Completed Missions <><>\n");
        for(Mission complete : completedMissions){
           Delay.slowOut("** " + complete.getName());
        }
        Delay.slowOut("\nThanks for playing!");
    }

}
