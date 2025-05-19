package Items;

public class Armor extends Item {

    public Armor(String name,String type, int armorValue){
        super(name,type,armorValue);
    }

    @Override
    public String toString(){
        return getType() + ": " + getName() + " <Armor - " + getValue() + ">";
    }
}
