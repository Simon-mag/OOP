package Characters;

import Items.Armor;
import Items.Weapon;

public class Monster extends Character {

    public Monster(String name, int healthPoints, Armor armor, Weapon weapon){
        super(name,healthPoints,armor,weapon);
    }

    public void attack(Hero hero, int damage){
        System.out.printf("%n%s attacks %s with %s for %d damage...%n%d HP remaining for %s%n%n",
                getName(),
                hero.getName(),
                getWeapon().getName(),
                damage,
                hero.getHealthPoints(),
                hero.getName()
        );
    }

}
