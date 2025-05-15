package Items;

public class Armor extends Item{
    private final int armorValue;

    public Armor(String name,String type, int armorValue){
        super(name,type,armorValue);
        this.armorValue = armorValue;
    }
    @Override
    public int getValue() { return armorValue; }

    @Override
    public String toString(){
        return getType() + ": " + getName() + " <Armor - " + getValue() + ">";
    }
}
