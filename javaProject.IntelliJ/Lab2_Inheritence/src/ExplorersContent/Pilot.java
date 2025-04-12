package ExplorersContent;

import DefaultPackage.Delay;

public class Pilot extends SpaceExplorer{

    private final String role = "Pilot";

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
            System.out.printf("%s %s is doing %sing work (%s)%n",role,getName(),role,getMission());
        else
            System.out.printf("%s %s is free right now%n",role,getName());
    }
}
