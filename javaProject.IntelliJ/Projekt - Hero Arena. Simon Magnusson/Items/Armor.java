package Items;

import Characters.Character;

public class Armor extends Item {

    public Armor(String name,String type, int armorValue){
        super(name,type,armorValue);
    }

    @Override
    public String toString(){
        return getType() + ": " + getName() + " <Armor - " + getValue() + ">";
    }

    @Override
    public void printEquipItem(Item item, Character character) {
        System.out.printf("%s equips Armor: %s (with %d armor)%n",
                character.getName(),
                getName(),
                getValue()
        );
    }
}
