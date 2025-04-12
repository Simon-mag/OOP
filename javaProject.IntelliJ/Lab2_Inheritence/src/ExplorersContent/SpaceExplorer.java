package ExplorersContent;
import DefaultPackage.Delay;

public class SpaceExplorer {

    private final int id;
    private static int nextId = 1;
    private String name;
    private String mission;
    protected String profession;
    private boolean onMission = false;


    public SpaceExplorer(String name, String profession){
        this.name = name;
        this.profession = profession;
        id = nextId;
        ++nextId;
    }

    public SpaceExplorer(String name, String profession, String mission){
        this.name = name;
        this.profession = profession;
        this.mission = mission;
        id = nextId;
        ++nextId;
    }

    public void startMission(){
        Delay.delay();
        if(!onMission) {
            System.out.printf("%s is starting their mission: %s%n", name, mission);
            onMission = true;
        } else
            System.out.printf("%s is already on a mission! Mission: %s%n",name,mission);
    }
    public void completeMission(){
        Delay.delay();
        if(onMission) {
            System.out.printf("%s has completed their mission: %s%n", name, mission);
            onMission = false;
        }else
            System.out.printf("%s is not currently on a mission...%n", name);
    }
    public void reportStatus(){
        Delay.delay();
        if(onMission)
            System.out.printf("%s is currently busy!%n",name);
        else
            System.out.printf("%s is ready for deployment!%n",name);
    }


    public void setName(String name){this.name = name;}
    public void setMission(String mission){this.mission = mission;}
    public void setProfession(String profession){this.profession = profession;}

    public int getId(){return id;}
    public String getName(){return name;}
    public String getProfession(){return profession;}
    public String getMission(){return mission;}
    public boolean getOnMission(){return onMission;}

}
