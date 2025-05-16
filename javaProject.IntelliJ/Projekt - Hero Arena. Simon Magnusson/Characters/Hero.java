package Characters;

import Items.Armor;
import Items.Item;
import Items.Weapon;

import java.util.ArrayList;

public class Hero extends Character {
    private final ArrayList<Item> items = new ArrayList<>();

    public Hero(String name, int healthPoints, Armor armor, Weapon weapon){
        super(name, healthPoints, armor,weapon);
    }

    public void attack(Monster monster){
        String monsterName = monster.getName();
        Weapon weapon = getWeapon();
        System.out.printf("%s attacks %s with %s for %d damage...%n%d HP remaining for %s",
                getName(),
                monsterName,
                weapon.getName(),
                weapon.getValue(),
                monster.getHealthPoints(),
                monsterName
        );
    }

//    public void printEquipWeapon(){
//        Weapon weapon = getWeapon();
//        System.out.printf("%s equips new weapon: %s (with %d damage)",
//                getName(),
//                weapon.getName(),
//                weapon.getValue()
//        );
//    }
//    public void printEquipArmor(){
//        Armor armor = getArmor();
//        System.out.printf("%s equips new Armor: %s (with %d armor)",
//                getName(),
//                armor.getName(),
//                armor.getValue()
//        );
//    }

    public void printGiveItem(Item item){
        if(item.getClass().equals(Armor.class))
            System.out.printf("%s has acquired a new %s: %s (Defence: %2d)!",
                    getName(),
                    Armor.class,
                    item.getName(),
                    item.getValue()
                    );
        else
            System.out.printf("%s has acquired a new %s: %s (Attack : %2d)!",
                    getName(),
                    Weapon.class,
                    item.getName(),
                    item.getValue()
            );
    }


    public void viewInventory(){
        for(Item item : items){
            int i = 1;
            String line = String.format("%2d: %s",i, item.toString());
            System.out.printf("║ %-40s ║\n",line);
            ++i;
        }
    }
    public ArrayList<Item> getItems(){ return items;}
}
