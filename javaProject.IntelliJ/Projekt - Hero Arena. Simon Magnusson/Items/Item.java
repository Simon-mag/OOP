package Items;

public abstract class Item implements Comparable<Item> {
    private final String name;
    private final String type;
    private final int value;

    public Item(String name,String type,int value){
        this.name = name;
        this.type = type;
        this.value = value;
    }

    @Override
    public int compareTo(Item o) {
        return this.name.toLowerCase().compareTo(o.name.toLowerCase());
    }

    public String getName(){return name;}
    public String getType(){return type;}
    public int getValue()  {return value;}
}
