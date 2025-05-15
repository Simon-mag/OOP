package Items;

public class Weapon extends Item{
    private final int attackValue;

    public Weapon(String name, String type, int attackValue){
        super(name,type,attackValue);
        this.attackValue= attackValue;
    }
    @Override
    public int getValue() { return attackValue; }

    @Override
    public String toString(){
        return getType() + ": " + getName() + " <Damage- " + getValue() + ">";
    }
}
