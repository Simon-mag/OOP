package ExplorersContent;
import DefaultPackage.Delay;
import Missions.Mission;


public class Engineer extends SpaceExplorer{

    public Engineer(String name, Mission mission){ super(name, "Engineer", mission); }

    @Override
    public void reportStatus() {
        String rank = "Engineer";
        Delay.delay();
        if(getOnMission())
            System.out.printf("%s %s is maintaining critical systems in base on mission %s%n",rank,getName(),getMission().getName());
        else
            System.out.printf("%s %s is free right now%n",rank,getName());
    }


}

