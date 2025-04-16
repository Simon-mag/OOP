package ExplorersContent;

import DefaultPackage.Delay;
import Missions.Mission;
import Vehicles.SpaceVehicle;

public class Commander extends SpaceExplorer{
    private final String rank = "Commander";
    private SpaceExplorer[] team;

    public Commander(String name){super(name,"Commander");}
    public Commander(String name, Mission mission){super(name,"Commander",mission);}
    public Commander(String name, Mission mission, SpaceExplorer[] team){super(name,"Commander",mission); this.team = team;}

    public void performDuty(){
        Mission currentMission = getMission();
        SpaceVehicle currentRocket = getMission().getRocket();

        if(currentMission.getName() == null || currentRocket == null){
            Delay.slowOut("insufficient data, either mission or currentRocket is missing!");
            return;
        }
        Delay.slowOut("Commander " + getName() + " Initializing their role on mission " + getMission().getName() + "\n");
        setOnMission(true);
        currentRocket.transportCrew();
        currentRocket.launch();
        currentMission.performMission();
        System.out.println("\n");

        for(SpaceExplorer explorer : team)
            explorer.startMission();
        System.out.println("\n");

        for(SpaceExplorer explorer : team)
            explorer.reportStatus();
        System.out.println("\n");

        for(SpaceExplorer explorer : team)
            explorer.completeMission();
        System.out.println("\n");

        currentRocket.land();
        setOnMission(false);
        Delay.slowOut(rank + " " + getName() + " has completed their mission\n");
    }
    @Override
    public SpaceExplorer[] getTeam(){return team;}

    @Override
     public void startMission(){
        if(!getOnMission()) {
            Mission currentMission = getMission();
            SpaceVehicle currentRocket = getMission().getRocket();

            if (currentMission.getName() == null || currentRocket == null) {
                Delay.slowOut("insufficient data, either mission or currentRocket is missing!");
                return;
            }
            Delay.slowOut("\nCommander " + getName() + " Initializing their role on mission " + getMission().getName() + "\n");
            currentRocket.transportCrew();
            currentRocket.launch();
            currentMission.performMission();
            System.out.println();
            setOnMission(true);
            for (SpaceExplorer explorer : team)
                explorer.startMission();
            System.out.println();
        }else
            Delay.slowOut("Commander and crew is already on a mission (" + getMission().getName() + ")");
    }

    @Override
    public void reportStatus(){
        Delay.delay();
        Delay.slowOut("");
        if(getOnMission())
            System.out.printf("%s %s is managing the crew%n",rank,getName());
        else
            System.out.printf("%s %s is awaiting your command!%n",rank,getName());
        for(SpaceExplorer explorer : team)
            explorer.reportStatus();
        System.out.println("\n");
    }

    @Override
    public void completeMission(){
        if(getOnMission()) {
            for (SpaceExplorer explorer : team)
                explorer.completeMission();
            System.out.println("\n");

            getMission().getRocket().land();
            setOnMission(false);
            Delay.slowOut(rank + " " + getName() + " has completed their mission\n");
        }else
            Delay.slowOut("Commander and crew is not on a mission!");
    }
}
