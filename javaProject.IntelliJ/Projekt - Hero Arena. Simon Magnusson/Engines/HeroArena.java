package Engines;
import Characters.Character;
import Characters.Hero;
import Characters.Monster;
import Items.Armor;
import Items.Item;
import Items.Weapon;
import java.io.File;
import java.util.*;
import static Engines.Utils.pause;


public class HeroArena {
    private final ItemManager weaponManager;
    private final ItemManager armorManager;
    private final int startHealth = 40;
    private final Monster monster;
    private Hero hero;

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

    public HeroArena()throws ExceptionInInitializerError{
        try {
            this.armorManager = new ItemManager(new File("Armors.txt"));
            this.weaponManager = new ItemManager(new File("Weapons.txt"));

            monster = new Monster(
                    "Skeleton",
                    startHealth,
                    (Armor) armorManager.getNewItem(random),
                    (Weapon) weaponManager.getNewItem(random)
            );

        } catch (RuntimeException e){
            System.out.println("Couldn't create a game!" + e.getMessage());
            throw new ExceptionInInitializerError("Terminating game from error");
        }
    }


    public void run(){

        printMenus(commands.start);
        createHero();
        printMonsterStats();
        tryGiveHeroNewItem();

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
                        attack(monster,hero);
                        if(hero.getHealthPoints() <= 0)
                            break;
                        tryGiveHeroNewItem();
                    }

                } else System.out.println("Invalid option, choose from menu (1-4)\n");

            } catch (InputMismatchException e){
                System.out.println("Invalid input, choose from menu! (1-4)\n");
                scanner.nextLine();
            }

        } while(hero.getHealthPoints() > 0 && monster.getHealthPoints() > 0);

        printMenus(commands.gameOver);
    }


    private void handleChoice(commands command){

        switch (command){
            case attack -> attack(hero,monster);
            case view -> printMenus(command);
            case equip -> {
                ArrayList<Item> heroInventory = hero.getItems();
                while(true) {

                    printMenus(command);
                    try {
                        int chosenItem = scanner.nextInt();

                        if(chosenItem <= heroInventory.size() && chosenItem >= 1) {
                            Item newItem = heroInventory.get(chosenItem - 1);

                            if(newItem.getClass().equals(Armor.class))
                                hero.setArmor(newItem);
                            else hero.setWeapon( newItem);

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
        Weapon weapon =  (Weapon) weaponManager.getSpecificItem(10);
        Armor armor =  (Armor) armorManager.getSpecificItem(10);
        System.out.print("Enter your hero's name: ");

        hero = new Hero(scanner.nextLine(),
                startHealth,
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

    private void tryGiveHeroNewItem(){

        if(Utils.chance(45)){
            Item newItem;
            if(Utils.chance(50))
                newItem = armorManager.getNewItem(random);
            else
                newItem = weaponManager.getNewItem(random);

            hero.getItems().add(newItem);
            newItem.printReceiveItem(newItem,hero);
        }
   }

    private void attack(Character attacker, Character defender) {
        int damage = attacker.getWeapon().getValue() - defender.getArmor().getValue();
        if (damage < 0) damage = 0;

        defender.setHealthPoints(defender.getHealthPoints() - damage);
        attacker.printAttack(defender, damage);
    }

    private void monsterEquipItems(){

        if(Utils.chance(30)){
            Item weapon =  weaponManager.getNewItem(random);
            monster.setWeapon(weapon);
            weapon.printEquipItem(weapon,monster);
        }
        if (Utils.chance(20)){
            Armor armor = (Armor) armorManager.getNewItem(random);
            monster.setArmor(armor);
            armor.printEquipItem(armor,monster);
        }
    }

    private void printMonsterStats(){
        Item weapon = monster.getWeapon();
        Item armor = monster.getArmor();
        String name = monster.getName();

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
            case start -> System.out.println("""
                    
                    
                    ╔═  WELCOME TO HERO ARENA  ═╗
                    ╚═ Please create your hero ═╝\s""");

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
                scanner.nextLine();
            }
            case equip -> {
                System.out.println("\n╔═════════════════════════════════════════════╗");
                System.out.println("║             Choose item to equip            ║");
                System.out.println("║                                             ║");
                hero.viewInventory();
                System.out.println("╚═════════════════════════════════════════════╝");
                System.out.print("Enter item number: ");
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
