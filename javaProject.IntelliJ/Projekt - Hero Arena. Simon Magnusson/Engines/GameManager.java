package Engines;

import Characters.Hero;
import Characters.Monster;
import Items.Armor;
import Items.Item;
import Items.Weapon;
import java.io.File;
import java.util.*;
import static Engines.Utils.pause;

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
        emptyInventory,
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


    public void runHeroArena(){

        printMenus(commands.start);
        createHero();
        printMonsterStats();

        int choice;
        do{
            printMenus(commands.menu);

            try{
                choice = scanner.nextInt();

                if(choice >= 1 && choice <= 4){
                    commands selectedCommand = switch (choice){
                        case 1 -> commands.attack;
                        case 2 -> commands.view;
                        case 3 -> commands.equip;
                        case 4 -> commands.exit;
                        default -> commands.gameOver;

                    };

                    if(selectedCommand == commands.exit){
                        printMenus(selectedCommand);
                        return;
                    }
                    //execute choice//
                    handleChoice(selectedCommand);

                    if(selectedCommand == commands.attack && monster.getHealthPoints() > 0) {
                        //Monsters turn//
                        //Equip  items precent chance armor 20%, weapon 30%//
                        monsterEquipItems();
                        monsterAttack();
                        tryGiveHeroNewItems();
                    }

                } else
                    System.out.println("Invalid option, choose from menu (1-4)\n");

            } catch (InputMismatchException e){
                System.out.println("Invalid input, choose from menu! (1-4)\n");
                scanner.nextLine();
            }

        } while(hero.getHealthPoints() >= 0 && monster.getHealthPoints() >= 0);

        printMenus(commands.gameOver);
    }


    private void handleChoice(commands command){

        switch (command){
            case attack -> {
                int damage = hero.getWeapon().getValue() - monster.getArmor().getValue();
                if(damage <= 0) damage = 0;

                monster.setHealthPoints( (monster.getHealthPoints() - damage) );
                hero.attack(monster,damage);
            }
            case view -> printMenus(command);
            case equip -> {
                ArrayList<Item> heroInventory = hero.getItems();
                while(true) {

                    if(heroInventory.isEmpty()){
                        printMenus(commands.emptyInventory);
                        break;
                    }

                    printMenus(command);
                    try {
                        int chosenItem = scanner.nextInt();

                        if(chosenItem <= heroInventory.size() && chosenItem >= 1) {
                            Item newItem = heroInventory.get(chosenItem - 1);

                            if(newItem.getClass().equals(Armor.class))
                                hero.setArmor((Armor) newItem);
                            else hero.setWeapon((Weapon) newItem);

                            hero.printEquipItem(newItem);
                            break;
                        } else {
                            System.out.println("Please choose from inventory numbers!");
                        }
                    } catch (InputMismatchException e){
                        System.out.println("Invalid input, choose a number from list\n");
                        scanner.nextLine();
                    } catch (ClassCastException e){
                        System.out.println("Casting class went wrong" + e.getMessage());
                    }
                }
            }
        }
    }

    private void createHero(){
        System.out.print("Enter your hero's name: ");
        Armor armor =  (Armor) armorManager.getSpecificItem(10);
        Weapon weapon =  (Weapon) weaponManager.getSpecificItem(10);
        hero = new Hero(scanner.nextLine(),
                30,
                armor,
                weapon
        );
        System.out.printf("%n%s starts with:%nWeapon: %s Damage: (%d)%nArmor: %s Value: (%d)%n",
                hero.getName(),
                weapon.getName(),
                weapon.getValue(),
                armor.getName(),
                armor.getValue()
        );
        hero.getItems().add(armor);
        hero.getItems().add(weapon);
    }

    private void tryGiveHeroNewItems(){

        if(Utils.chance(40)){
            if(Utils.chance(50)){
                Armor newArmor = (Armor) armorManager.getNewItem(random);
                hero.getItems().add(newArmor);
                hero.printGiveItem(newArmor);
            } else {
                Weapon newWeapon = (Weapon) weaponManager.getNewItem(random);
                hero.getItems().add(newWeapon);
                hero.printGiveItem(newWeapon);
            }
        }
    }

    private void monsterAttack(){
        int damage = monster.getWeapon().getValue() - hero.getArmor().getValue();
        if(damage <= 0) damage = 0;

        hero.setHealthPoints(hero.getHealthPoints() - damage);
        monster.attack(hero,damage);
    }

    private void monsterEquipItems(){

        if(Utils.chance(30)){
            Weapon weapon = (Weapon) weaponManager.getNewItem(random);
            monster.setWeapon(weapon);
            monster.printEquipItem(weapon);
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
        System.out.printf("%nYou encounter a %s - Time for battle!%n",name);
        System.out.printf("The %s is equipped with a %s (%d) and %s (%d)!%n%n",
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
                System.out.println("\n╔═════════════════════════════════════════════╗");
                System.out.println("║              Inventory for Hero             ║");
                System.out.println("║                                             ║");
                hero.viewInventory();
                System.out.println("╚═════════════════════════════════════════════╝");
                pause();
            }
            case equip -> {
                System.out.println("\n╔═════════════════════════════════════════════╗");
                System.out.println("║             Choose item to equip            ║");
                System.out.println("║                                             ║");
                hero.viewInventory();
                System.out.println("╚═════════════════════════════════════════════╝");
                System.out.print("Enter item number: ");
            }
            case emptyInventory -> {
                System.out.println("\n╔═════════════════════════════════════════════╗");
                System.out.println("║             Choose item to equip            ║");
                System.out.println("║                                             ║");
                hero.viewInventory();
                System.out.println("╚═════════════════════════════════════════════╝");
                pause();
            }
            case exit -> System.out.println("\nExiting game, thanks for playing!\n");
            case gameOver -> {
                if (hero.getHealthPoints() <= 0){
                    System.out.printf("The %s has defeated you!", monster.getName());
                    printMenus(commands.exit);
                } else {
                    System.out.printf("You have defeated the %s. Congratulations!%n", monster.getName());
                    printMenus(commands.exit);
                }
            }
        }
    }

}
