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
}
