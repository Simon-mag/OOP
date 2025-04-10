package DefaultPackage;

import ExplorersContent.Engineer;
import ExplorersContent.SpaceExplorer;

public class Main {
    public static void main(String[] args) {

        SpaceExplorer explorer = new SpaceExplorer("Axel", "Asian");

        explorer.setMission("Excavation");
        System.out.println(explorer.getMission());
        explorer.startMission();
        explorer.reportStatus();
        explorer.completeMission();
        System.out.println("ID: " + explorer.getId());

        Engineer engineer = new Engineer("Elias");

        engineer.setMission("fix");
        System.out.println(engineer.getMission());
        engineer.startMission();
        engineer.completeMission();
        engineer.reportStatus();
        System.out.println("ID: " + engineer.getId());







    }
}