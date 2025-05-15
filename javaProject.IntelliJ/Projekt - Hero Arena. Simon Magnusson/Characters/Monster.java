package Characters;

import Items.Armor;
import Items.Weapon;

public class Monster extends Character {

    public Monster(String name, int healthPoints, Armor armor, Weapon weapon){
        super(name,healthPoints,armor,weapon);
    }

    public void attack(Hero hero){
        System.out.printf("%s attacks %s with %s for %d damage...%n%d HP remaining for %s ",
                getName(),
                hero.getName(),
                getWeapon().getName(),
                getWeapon().getValue(),
                hero.getHealthPoints(),
                hero.getName()
        );
    }

}
