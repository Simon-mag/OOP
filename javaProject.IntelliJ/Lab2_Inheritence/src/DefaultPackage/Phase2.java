package DefaultPackage;

import ExplorersContent.*;
import Missions.*;
import Vehicles.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Phase2 {
    Phase1 phase1 = new Phase1();
    private final ArrayList<Mission> completedMissions = new ArrayList<>();


    public void startPhase2(){
        Scanner input = new Scanner(System.in);
        SpaceVehicle explorationRocket = new Rocket();
        SpaceVehicle MaintenanceRocket = new Rocket();

        Mission explorationMission = new ExplorationMission(
                "Pluto",
                900,
                "Discovering Pluto",
                explorationRocket
        );
        Mission maintenanceMission = new MaintenaceMission(
                "Mars",
                100,
                "Restoring Mars Base",
                MaintenanceRocket
        );

        printStartPhase2(explorationMission,maintenanceMission);
        SpaceExplorer explorationCommander = createCommander(explorationMission, input);
        SpaceExplorer maintenanceCommander = createCommander(maintenanceMission, input);

        printTeamInfo(explorationCommander);
        printTeamInfo(maintenanceCommander);


        Delay.slowOut(":: Team 1 <> Executing mission " + explorationMission.getName());
        printStartMission(explorationCommander);
        Delay.slowOut(":: Team 2 <> Executing mission " + maintenanceMission.getName());
        printStartMission(maintenanceCommander);

        phase1.printMissionSummary(completedMissions);
    }


    private void printStartMission(SpaceExplorer commander){
        commander.performDuty();
        completedMissions.add(commander.getMission());
    }

    private Commander createCommander(Mission mission, Scanner input){
        Delay.slowOutForInput("Enter name for the " + mission.getName() + "s Commander: ");
        String name = input.nextLine();

        Delay.slowOut("Now we need 3 crew members for Commander " + name + " >");
        SpaceExplorer[] crew = createCommanderTeam(input, mission);
        System.out.println();

        return new Commander(name,mission,crew);
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

    private void printTeamInfo(SpaceExplorer commander){
        Mission teamMission = commander.getMission();

        Delay.slowOut(teamMission.getDestination() + " Team is led by " + commander.getProfession() + " " + commander.getName() + "  ID: " + commander.getId());
        Delay.slowOut("Team members ::");
        for (SpaceExplorer ex : commander.getTeam()){
            System.out.printf("-- ID: %d <> Rank: %-9s <> Name: %-6s <> Mission: %-10s --%n",
                    ex.getId(),
                    ex.getProfession(),
                    ex.getName(),
                    ex.getMission().getName()
            );
        }
        System.out.println();
    }

    private void printStartPhase2(Mission explorationMission, Mission maintenanceMission){
        Delay.slowOut("<> Hello Captain, You are tasked with completing 2 missions <>\n");
        Delay.slowOut("-- Exploration: " + explorationMission.getName() + "  --");
        Delay.slowOut("-- Maintenance: " + maintenanceMission.getName() + "  --");
        Delay.slowOut("\nTime to create your teams!");
    }
}
