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

    @Override
    public void attack(Character character, int damage){
        String monsterName = character.getName();
        Weapon weapon = getWeapon();
        System.out.printf("%n%s attacks %s with %s for %d damage...%n%d HP remaining for %s%n",
                getName(),
                monsterName,
                weapon.getName(),
                damage,
                character.getHealthPoints(),
                monsterName
        );
    }

    public void printGiveItem(Item item){
        String currentItemClass;
        if(item.getClass().equals(Armor.class))
            currentItemClass = "Armor";
        else currentItemClass = "Weapon";

        System.out.printf("%s has acquired a new %s: %s (%s: %2d)! %n%n",
                getName(),
                currentItemClass,
                item.getName(),
                item.getClass().getSimpleName(),
                item.getValue()
        );
    }

    public void viewInventory(){
        int i = 1;
        for(Item item : items){

            String line = String.format("%2d: %s",i, item.toString());
            System.out.printf("║ %-43s ║%n",line);
            ++i;
        }
        if(i == 1){
            System.out.printf("║ %-43s ║%n","No items found yet!");
        }
    }
    public ArrayList<Item> getItems(){ return items;}
}
