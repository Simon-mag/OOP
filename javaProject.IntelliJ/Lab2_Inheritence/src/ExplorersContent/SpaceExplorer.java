package ExplorersContent;
import DefaultPackage.Delay;
import Missions.Mission;

public abstract class SpaceExplorer {

    private final int id;
    private static int nextId = 1;
    private String name;
    private Mission mission;
    protected String profession;
    private boolean onMission = false;


    public SpaceExplorer(String name, String profession){
        this.name = name;
        this.profession = profession;
        id = nextId;
        ++nextId;
    }
    public SpaceExplorer(String name, String profession, Mission mission){
        this.name = name;
        this.profession = profession;
        this.mission = mission;
        id = nextId;
        ++nextId;
    }

    public void startMission(){
        Delay.delay();
        if(!onMission) {
            System.out.printf("%s is starting their mission: %s%n", name, mission.getName());
            onMission = true;
        } else
            System.out.printf("%s is already on a mission! Mission: %s%n",name,mission.getName());
    }
    public void completeMission(){
        Delay.delay();
        if(onMission) {
            System.out.printf("%s has completed their mission: %s%n", name, mission.getName());
            onMission = false;
        }else
            System.out.printf("%s is not currently on a mission...%n", name);
    }
    public void reportStatus(){}

    public void setName(String name){this.name = name;}
    public void setMission(Mission mission){this.mission = mission;}
    public void setOnMission(boolean onMission){this.onMission = onMission;}

    public int getId(){return id;}
    public String getName(){return name;}
    public String getProfession(){return profession;}
    public Mission getMission(){return mission;}
    public boolean getOnMission(){return onMission;}

    public SpaceExplorer[] getTeam() {return null;}
    public void performDuty() {}
}
