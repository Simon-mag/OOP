package Characters;
import Items.Armor;
import Items.Weapon;


public class Monster extends Character {

    public Monster(String name, int healthPoints, Armor armor, Weapon weapon){
        super(name,healthPoints,armor,weapon);
    }
    @Override
    public void attack(Character character, int damage){
        String name = character.getName();
        System.out.printf("%n%s attacks %s with %s for %d damage...%n%d HP remaining for %s%n%n",
                getName(),
                name,
                getWeapon().getName(),
                damage,
                character.getHealthPoints(),
                name
        );
    }

}
