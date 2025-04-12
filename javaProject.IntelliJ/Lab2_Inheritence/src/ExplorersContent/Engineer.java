package ExplorersContent;
import DefaultPackage.Delay;


public class Engineer extends SpaceExplorer{

    private final String role = "Engineer";

    public Engineer(String name){ super(name,"Engineer"); }

    public Engineer(String name, String mission){ super(name, "Engineer", mission); }

    @Override
    public void reportStatus() {
        Delay.delay();
        if(getOnMission())
            System.out.printf("%s %s is doing %sing work (%s)%n",role,getName(),role,getMission());
        else
            System.out.printf("%s %s is free right now%n",role,getName());
    }


}

