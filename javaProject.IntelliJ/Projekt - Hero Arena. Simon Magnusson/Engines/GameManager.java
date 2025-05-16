package Engines;

import Characters.Hero;
import Characters.Monster;
import Items.Armor;
import Items.Item;
import Items.Weapon;
import java.io.File;
import java.util.*;

public class GameManager {
    private final ItemManager weaponManager;
    private final ItemManager armorManager;
    private Hero hero;
    private final Monster monster;

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    private enum commands{
        start,
        menu,
        attack,
        view,
        equip,
        exit,
        gameOver
    }

    public GameManager()throws ExceptionInInitializerError{
        try {
            this.armorManager = new ItemManager(new File("Armors.txt"));
            this.weaponManager = new ItemManager(new File("Weapons.txt"));

            monster = new Monster(
                    "Skeleton",
                    30,
                    (Armor) armorManager.getNewItem(random),
                    (Weapon) weaponManager.getNewItem(random)
            );

        } catch (RuntimeException e) {
            System.out.println("Couldn't create a game!" + e.getMessage());
            throw new ExceptionInInitializerError("Terminating game from error");
        }
    }


    public void run(){
        int choice;

        printMenus(commands.start);
        createHero();
        printMonsterStats();

        do{

            // give hero new item (40% chance), Done //
            //Hero's Turn//
            tryGiveHeroNewItems();

            printMenus(commands.menu);
            try{
                choice = scanner.nextInt();
                if(choice >= 1 && choice <= 4){
                    commands selectedCommand = switch (choice){
                        case 1 -> commands.attack;
                        case 2 -> commands.view;
                        case 3 -> commands.equip;
                        case 4 -> commands.exit;
                        default -> commands.menu;
                    };

                    if(selectedCommand == commands.exit){
                        printMenus(selectedCommand);
                        break;
                    }
                    //execute choice, Done//
                    handleChoice(selectedCommand);

                    if(selectedCommand == commands.attack) {
                        //Monsters turn//
                        //Equip  items precent chance armor 20%, weapon 30%, Done//
                        monsterEquipItems();
                        monsterAttack();
                    }

                } else
                    System.out.println("Invalid option, choose from menu (1-4)\n");

            }catch (InputMismatchException e){
                System.out.println("Invalid input, choose from menu! (1-4)\n");
                scanner.nextLine();
            }

        }while(hero.getHealthPoints() > 0 && monster.getHealthPoints() > 0);

        //End screen, display who won//
        printMenus(commands.gameOver);
    }


    private void handleChoice(commands command){

        switch (command){
            case attack -> {
                int damage = hero.getWeapon().getValue() - monster.getArmor().getValue();
                monster.setHealthPoints( (monster.getHealthPoints() - damage) );
                hero.attack(monster);
            }
            case view -> printMenus(command);
            case equip -> {
                while(true) {
                    ArrayList<Item> heroInventory = hero.getItems();
                    printMenus(command);
                    try {
                        int item = scanner.nextInt();

                        if(item <= heroInventory.size() && item >= 1) {

                            Item newItem = heroInventory.get(item - 1);
                            if(newItem.getClass().equals(Armor.class)) {
                                hero.setArmor((Armor) newItem);
                            }
                            else {
                                hero.setWeapon((Weapon) newItem);
                            }
                            hero.printEquipItem(newItem);
                            break;
                        } else {
                            System.out.println("Please choose from inventory numbers!");
                        }
                    } catch (InputMismatchException e){
                        System.out.println("Invalid input, choose a number from list\n");
                        scanner.nextLine();
                    }catch (ClassCastException e){
                        System.out.println("Casting class went wrong" + e.getMessage());
                    }
                }
            }
        }
    }

    private void createHero(){
        System.out.print("Enter your hero's name: ");
        Armor armor = new Armor("Leather Armor","Armor", 2);
        Weapon weapon = new Weapon("Iron Shortsword", "Weapon", 5);
        hero = new Hero(scanner.nextLine(),
                30,
                armor,
                weapon
        );
        System.out.printf("%s starts with:%nWeapon: %s Damage: %d%nArmor: %s Value: %d",
                hero.getName(),
                weapon.getName(),
                weapon.getValue(),
                armor.getName(),
                armor.getValue()
        );
    }

    private void tryGiveHeroNewItems(){

        if(Utils.chance(40)){
            if(Utils.chance(50)){
                Armor newArmor = (Armor) armorManager.getNewItem(random);
                hero.getItems().add(armorManager.getNewItem(random));
                hero.printGiveItem(newArmor);
            } else {
                Weapon newWeapon = (Weapon) weaponManager.getNewItem(random);
                hero.getItems().add(weaponManager.getNewItem(random));
                hero.printGiveItem(newWeapon);
            }
        }
    }

    private void monsterAttack(){
        int damage = monster.getWeapon().getValue() - hero.getArmor().getValue();
        monster.setHealthPoints(monster.getHealthPoints() - damage);
        monster.attack(hero);
    }

    private void monsterEquipItems(){

        if(Utils.chance(30)){
            Weapon weapon = (Weapon) weaponManager.getNewItem(random);
            monster.setWeapon(weapon);
            monster.printEquipItem(weapon);
            // return;
        }
        if (Utils.chance(20)){
            Armor armor = (Armor) armorManager.getNewItem(random);
            monster.setArmor(armor);
            monster.printEquipItem(armor);
        }

    }

    private void printMonsterStats(){
        String name = monster.getName();
        Weapon weapon = monster.getWeapon();
        Armor armor = monster.getArmor();
        System.out.printf("\n You encounter a %s - Time for battle!",name);
        System.out.printf("The %s is equipped with a %s (%2d) and %s (%2d)!",
                name,
                weapon.getName(),
                weapon.getValue(),
                armor.getName(),
                armor.getValue()
        );
    }

    private void printMenus(commands command){
        switch (command) {
            case start -> System.out.println("╔═  WELCOME TO HERO ARENA  ═╗\n" +
                        "╚═ Please create your hero ═╝ ");

            case menu -> {
                System.out.println("╔════════════════════════╗");
                System.out.println("║     Choose Action!     ║");
                System.out.println("║                        ║");
                System.out.println("║   1-> Attack           ║");
                System.out.println("║   2-> View Inventory   ║");
                System.out.println("║   3-> Equip Item       ║");
                System.out.println("║                        ║");
                System.out.println("║   4-> Exit game        ║");
                System.out.println("╚════════════════════════╝");
                System.out.print("Enter Destiny: ");
            }
            case view -> {
                Map<Integer,Item> armors = armorManager.getInventory();
                Map<Integer,Item> weapons = weaponManager.getInventory();
                System.out.println("╔════════════════════════════════════════════╗");
                System.out.println("║             Inventory for Hero             ║");
                System.out.println("║                                            ║");
                hero.viewInventory();
                System.out.println("╚════════════════════════════════════════════╝");
            }
            case equip -> {
                Map<Integer,Item> armors = armorManager.getInventory();
                Map<Integer,Item> weapons = weaponManager.getInventory();
                System.out.println("╔════════════════════════════════════════════╗");
                System.out.println("║            Choose item to equip            ║");
                System.out.println("║                                            ║");
                hero.viewInventory();
                System.out.println("╚════════════════════════════════════════════╝");
                System.out.print("Enter item number: ");

            }
            case exit -> System.out.println("Exiting game, thanks for playing!");
            case gameOver -> {
                if (hero.getHealthPoints() <= 0){
                    System.out.printf("The %s has defeated you!", monster.getName());
                    printMenus(commands.exit);
                } else {
                    System.out.printf("You have defeated the %s. Congratulations!", monster.getName());
                    printMenus(commands.exit);
                }
            }
        }
    }

//    private void printSpecificInventory(Map<Integer,Item> input){
//        for(Map.Entry<Integer,Item> entry : input.entrySet()) {
//            int slot = entry.getKey();
//            Item item = entry.getValue();
//            String line = String.format("%2d: %s", slot,item.toString());
//            System.out.printf("║ %-40s ║\n",line);
//        }
//    }

}
