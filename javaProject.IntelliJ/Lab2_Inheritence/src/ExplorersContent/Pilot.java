package ExplorersContent;

import DefaultPackage.Delay;

public class Pilot extends SpaceExplorer{

    private final String rank = "Pilot";

    public Pilot(String name) {
        super(name,"Pilot");
    }

    public Pilot(String name, String mission){
        super(name, "Pilot", mission);
    }

    @Override
    public void reportStatus() {
        Delay.delay();
        if(getOnMission())
            System.out.printf("%s %s have flown around the moon%n", rank,getName());
        else
            System.out.printf("%s %s is free right now%n", rank,getName());
    }
}
