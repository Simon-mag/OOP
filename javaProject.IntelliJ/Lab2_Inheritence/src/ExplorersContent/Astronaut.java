package ExplorersContent;
import DefaultPackage.Delay;
import Missions.Mission;

public class Astronaut extends SpaceExplorer{

    private final String rank = "Astronaut";

    public Astronaut(String name) {
        super(name,"Astronaut");
    }

    public Astronaut(String name, Mission mission){
        super(name, "Astronaut", mission);
    }

    @Override
    public void reportStatus() {
        Delay.delay();
        if(getOnMission())
            System.out.printf("%s %s is exploring new grounds in space on mission %s%n", rank,getName(),getMission().getName());
        else
            System.out.printf("%s %s is free right now%n", rank,getName());
    }
}
