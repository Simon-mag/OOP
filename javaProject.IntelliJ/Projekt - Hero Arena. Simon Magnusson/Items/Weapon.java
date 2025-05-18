package Items;

public class Weapon extends Item{

    public Weapon(String name, String type, int attackValue){
        super(name,type,attackValue);
    }

    @Override
    public String toString(){
        return getType() + ": " + getName() + " <Damage- " + getValue() + ">";
    }
}
