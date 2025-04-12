package ExplorersContent;

import DefaultPackage.Delay;

public class Commander extends SpaceExplorer{
    private final String rank = "Commander";

    public Commander(String name){super(name,"Commander");}
    public Commander(String name, String mission){super(name,"Commander",mission);}

    @Override
        public void reportStatus(){
        Delay.delay();
        if(getOnMission())
            System.out.printf("%s %s is doing %sing work (%s)%n",rank,getName(),rank,getMission());
        else
            System.out.printf("%s %s is free right now%n",rank,getName());
    }
}
