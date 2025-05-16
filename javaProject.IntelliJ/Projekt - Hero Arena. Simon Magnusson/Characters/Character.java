package Characters;

import Items.Armor;
import Items.Item;
import Items.Weapon;

public abstract class Character {

    private Armor armor;
    private Weapon weapon;
    private int healthPoints;
    private final String name;

    public Character(String name, int healthPoints, Armor armor, Weapon weapon){
        this.name = name;
        this.armor = armor;
        this.weapon = weapon;
        this.healthPoints = healthPoints;
    }

    public String getName() {return name;}
    public Armor getArmor() {return armor;}
    public Weapon getWeapon() {return weapon;}
    public int getHealthPoints() {return healthPoints;}

    public void setHealthPoints(int newHealth){
        this.healthPoints = newHealth;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void printEquipItem(Item item){
        if(item.getClass().equals(Armor.class)){
            System.out.printf("%s equips new Armor: %s (with %d armor)",
                    getName(),
                    item.getName(),
                    item.getValue()
            );
        } else{
            System.out.printf("%s equips new weapon: %s (with %d damage)",
                    getName(),
                    item.getName(),
                    item.getValue()
            );
        }
    }
}
