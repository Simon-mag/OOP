package ExplorersContent;
import DefaultPackage.Delay;

public class SpaceExplorer {

    private final int id;
    private static int nextId = 1;
    private String name;
    private String mission;
    protected String rank;
    private boolean onMission = false;


    public SpaceExplorer(String name, String rank){
        this.name = name;
        this.rank = rank;
        id = nextId;
        ++nextId;
    }

    public SpaceExplorer(String name, String rank, String mission){
        this.name = name;
        this.rank = rank;
        this.mission = mission;
        id = nextId;
        ++nextId;
    }

    public void startMission(){
        System.out.println("<> Accessing mission control <>");
        Delay.delay();
        if(!onMission) {
            System.out.printf("%s is starting his mission: %s%n", name, mission);
            onMission = true;
        } else
            System.out.printf("%s is already on a mission %nMission: %s%n",name,mission);

    }
    public void completeMission(){
        System.out.println("<> Accessing mission control <>");
        Delay.delay();
        if(onMission) {
            System.out.printf("%s has completed their mission: %s%n", name, mission);
            onMission = false;
        }else
            System.out.printf("%s is not currently on a mission...", name);
    }
    public void reportStatus(){
        System.out.println("<> Accessing mission control <>");
        Delay.delay();
        if(onMission)
            System.out.printf("%s is currently busy!%n",name);
        else
            System.out.printf("%s is ready for deployment!%n",name);
    }


    public void setName(String name){this.name = name;}
    public void setMission(String mission){this.mission = mission;}
    public void setRank(String rank){this.rank = rank;}

    public int getId(){return id;}
    public String getName(){return name;}
    public String getRank(){return rank;}
    public String getMission(){return mission;}
    public boolean getOnMission(){return onMission;}

}
