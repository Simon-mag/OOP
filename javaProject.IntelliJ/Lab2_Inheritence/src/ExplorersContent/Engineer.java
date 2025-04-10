package ExplorersContent;
import DefaultPackage.Delay;


public class Engineer extends SpaceExplorer{

    private final String role = "Engineer";

    public Engineer(String name) {
        super(name,"Engineer");
    }

    public Engineer(String name, String mission){
        super(name, "Engineer", mission);
    }

    @Override
    public void reportStatus() {
        System.out.println("<> Accessing mission control <>");
        Delay.delay();
        if(getOnMission())
            System.out.printf("%s%s is doing %sing work",role,getName(),role);
        else
            System.out.printf("%s%s is free right now",role,getName());
    }


}

