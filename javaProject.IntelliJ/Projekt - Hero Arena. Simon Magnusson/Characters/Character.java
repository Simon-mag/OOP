package Characters;
import Items.Armor;
import Items.Item;
import Items.Weapon;


public abstract class Character {

    private Armor armor;
    private Weapon weapon;
    private int healthPoints;
    private final String name;

    public Character(String name, int healthPoints, Armor armor, Weapon weapon){
        this.name = name;
        this.armor = armor;
        this.weapon = weapon;
        this.healthPoints = healthPoints;
    }

    public void printEquipItem(Item item){
        if(item.getClass().equals(Armor.class))
            System.out.printf("%s equips Armor: %s (with %d armor)%n",
                    getName(),
                    item.getName(),
                    item.getValue()
            );
        else
            System.out.printf("%s equips weapon: %s (with %d damage)%n",
                    getName(),
                    item.getName(),
                    item.getValue()
            );
    }

    public abstract void printAttack(Character character, int damage);

    public String getName() {return name;}
    public Armor getArmor() {return armor;}
    public Weapon getWeapon() {return weapon;}
    public int getHealthPoints() {return healthPoints;}

    public void setArmor(Armor armor) {this.armor = armor;}
    public void setWeapon(Weapon weapon) {this.weapon = weapon;}
    public void setHealthPoints(int newHealth){this.healthPoints = newHealth;}

}
