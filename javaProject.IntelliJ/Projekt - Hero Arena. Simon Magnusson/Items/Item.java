package Items;

public abstract class Item {
    private final String name;
    private final String type;
    private final int value;

    public Item(String name,String type,int value){
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String getName(){return name;}
    public String getType(){return type;}
    public int getValue(){return value;}
}
