package Engines;

import Characters.Hero;
import Characters.Monster;
import Items.Armor;
import Items.Item;
import Items.Weapon;

import java.io.File;
import java.util.Map;

public class GameManager {
    private final ItemManager weaponManager;
    private final ItemManager armorManager;
    private Hero hero;
    private Monster monster;


    public GameManager()throws ExceptionInInitializerError{
        try {
            this.armorManager = new ItemManager(new File("Armors.txt"));
            this.weaponManager = new ItemManager(new File("Weapons.txt"));

            monster = new Monster(
                    "Skeleton",
                    30,
                    (Armor) armorManager.getNewItem(),
                    (Weapon) weaponManager.getNewItem()
            );

        } catch (RuntimeException e) {
            System.out.println("Couldn't create a game!");
            throw new ExceptionInInitializerError("Terminating game from error");
        }
    }


    public void run(){

    }

    private void equipItem(){

    }




    private void printMenu(){
        System.out.println("╔════════════════════════╗");
        System.out.println("║     Choose Action!     ║");
        System.out.println("║                        ║");
        System.out.println("║   1-> Attack           ║");
        System.out.println("║   2-> View Inventory   ║");
        System.out.println("║   3-> Equip Item       ║");
        System.out.println("║                        ║");
        System.out.println("╚════════════════════════╝");
    }

    private void printInventory(){
        Map<Integer,Item> inventory = itemManager.getInventory();

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║             Inventory for Hero             ║");
        System.out.println("║            Choose item to equip            ║");
        for(Map.Entry<Integer,Item> entry : inventory.entrySet()) {
            int slot = entry.getKey();
            Item item = entry.getValue();
            String line = String.format("%2d: %s", slot,item.toString());
            System.out.printf("║ %-40s ║\n",line);
        }
        System.out.println("╚════════════════════════════════════════════╝");
    }
}
