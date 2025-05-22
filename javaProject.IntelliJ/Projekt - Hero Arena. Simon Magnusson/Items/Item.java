package Items;

import Characters.Character;

public abstract class Item {
    private final String name;
    private final String type;
    private final int value;

    public Item(String name,String type,int value){
        this.name = name;
        this.type = type;
        this.value = value;
    }
    @Override
    public String toString() {
        return name + " " + type + " " + value;
    }

    public void printEquipItem(Item item, Character character) {
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
        System.out.printf("%s equips Item: %s (with value :%d)%n",
                character.getName(),
                name,
                value
        );
    }

    public void printReceiveItem(Item item, Character character) {
        System.out.println( character.getName() + " found a new " + item.toString());
    }

    public String getName(){return name;}
    public String getType(){return type;}
    public int getValue(){return value;}
}
