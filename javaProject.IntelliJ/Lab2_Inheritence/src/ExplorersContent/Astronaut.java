package ExplorersContent;

import DefaultPackage.Delay;

public class Astronaut extends SpaceExplorer{

    private final String role = "Astronaut";

    public Astronaut(String name) {
        super(name,"Astronaut");
    }

    public Astronaut(String name, String mission){
        super(name, "Astronaut", mission);
    }

    @Override
    public void reportStatus() {
        System.out.println("<> Accessing mission control <>");
        Delay.delay();
        if(getOnMission())
            System.out.printf("%s%s is doing %s work",role,getName(),role);
        else
            System.out.printf("%s%s is free right now",role,getName());
    }
}
