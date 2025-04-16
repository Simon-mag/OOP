package ExplorersContent;
import DefaultPackage.Delay;
import Missions.Mission;

public class Pilot extends SpaceExplorer{

    public Pilot(String name) {
        super(name,"Pilot");
    }

    public Pilot(String name, Mission mission){
        super(name, "Pilot", mission);
    }

    @Override
    public void reportStatus() {
        String rank = "Pilot";
        Delay.delay();
        if(getOnMission())
            System.out.printf("%s %s have flown around the moon on mission %s%n", rank,getName(),getMission().getName());
        else
            System.out.printf("%s %s is free right now%n", rank,getName());
    }
}
