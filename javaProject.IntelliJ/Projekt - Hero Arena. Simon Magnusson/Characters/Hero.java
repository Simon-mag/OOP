package Characters;

import Items.Armor;
import Items.Item;
import Items.Weapon;

import java.util.ArrayList;

public class Hero extends Character {
    ArrayList<Item> items = new ArrayList<>();

    public Hero(String name, int healthPoints, Armor armor, Weapon weapon){
        super(name, healthPoints, armor,weapon);
    }

    public void attack(Monster monster){
        System.out.printf("%s attacks %s with %s for %d damage...%n%d HP remaining for %s",
                getName(),
                monster.getName(),
                getWeapon().getName(),
                getWeapon().getValue(),
                monster.getHealthPoints(),
                monster.getName()
        );
    }

    public void equipItem(){
        Weapon current = getWeapon();
        System.out.printf("%s equips new weapon: %s (with %d damage)",
                getName(),
                current.getName(),
                current.getValue()
        );
    }

    public void viewInventory(){
        for(Item item : items){
            System.out.printf(item.toString());
        }
    }
}
