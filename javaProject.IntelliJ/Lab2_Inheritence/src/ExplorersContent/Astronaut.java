package ExplorersContent;

import DefaultPackage.Delay;

public class Astronaut extends SpaceExplorer{

    private final String rank = "Astronaut";

    public Astronaut(String name) {
        super(name,"Astronaut");
    }

    public Astronaut(String name, String mission){
        super(name, "Astronaut", mission);
    }

    @Override
    public void reportStatus() {
        Delay.delay();
        if(getOnMission())
            System.out.printf("%s %s is doing %s work (%s)%n", rank,getName(), rank,getMission());
        else
            System.out.printf("%s %s is free right now%n", rank,getName());
    }
}
