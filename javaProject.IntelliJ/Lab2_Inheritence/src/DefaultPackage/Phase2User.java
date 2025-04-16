package DefaultPackage;
import ExplorersContent.*;
import Missions.ExplorationMission;
import Missions.Mission;
import Vehicles.Rocket;
import Vehicles.SpaceVehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class Phase2User {
    private ArrayList<Commander> commanders;

    private void startPhase2(){
        Scanner input = new Scanner(System.in);

        printStartPhase2();

        createTeams(input);
        //commandCenter(input);


    }

    private void createTeams(Scanner input){
        SpaceVehicle rocket = new Rocket();
        for(int i = 1; i <= 2; ++i) {
            if(i == 1){
                Delay.slowOut("Team 1: [Discover new planet]\n");
                Mission explorationMission = new ExplorationMission(
                        "Saturn",
                        300,
                        "Discover new Planet",
                        rocket
                        );
                Delay.slowOutForInput("Enter name for Commander: ");
                String name = input.nextLine();
                Delay.slowOut("Nice! Commander " + name + " Needs some team members!\n");
                createCommanderTeam(input,explorationMission);
            }
            else {
                Delay.slowOut("Team 2: [Restoring Mars Base]\n");
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



    private void printStartPhase2(){
        Delay.slowOut("** You are tasked with completing 2 Missions **");
        Delay.delay();
        Delay.slowOut(": Mission 1 : Discover new planet :\n: Mission 2 : Restoring Mars Base :\n");
        Delay.delay();
        Delay.slowOut("You will need a team for each mission!");
        Delay.delay();
        Delay.slowOut("Time to create your teams!");
    }


}
