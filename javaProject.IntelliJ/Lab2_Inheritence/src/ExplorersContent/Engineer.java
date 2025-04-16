package ExplorersContent;
import DefaultPackage.Delay;
import Missions.Mission;


public class Engineer extends SpaceExplorer{

    private final String rank = "Engineer";

    public Engineer(String name){ super(name,"Engineer"); }

    public Engineer(String name, Mission mission){ super(name, "Engineer", mission); }

    @Override
    public void reportStatus() {
        Delay.delay();
        if(getOnMission())
            System.out.printf("%s %s is maintaining critical systems in base on mission %s%n",rank,getName(),getMission().getName());
        else
            System.out.printf("%s %s is free right now%n",rank,getName());
    }


}

