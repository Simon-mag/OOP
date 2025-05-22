package Items;

import Characters.Character;

public class Weapon extends Item {

    public Weapon(String name, String type, int attackValue){
        super(name,type,attackValue);
    }

    @Override
    public String toString(){
        return getType() + ": " + getName() + " <Damage- " + getValue() + ">";
    }

    @Override
    public void printEquipItem(Item item, Character character) {
        System.out.printf("%s equips Weapon: %s (with %d damage)%n",
                character.getName(),
                getName(),
                getValue()
        );
    }
}
