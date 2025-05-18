package Engines;
import Items.Armor;
import Items.Item;
import Items.Weapon;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class ItemManager {
    private final Map<Integer,Item> inventory = new HashMap<>();

    public ItemManager(File inputInventory)throws RuntimeException {

        try(BufferedReader reader = new BufferedReader(new FileReader(inputInventory))){
            String line;
            int index = 1;
            while ((line = reader.readLine()) != null){

                String[] parts = line.trim().split("-");

                if(parts.length != 3){
                    System.out.println("Invalid Item format " + line);
                    continue;
                }

                String type = parts[0].trim();
                String name = parts[1].trim();
                int value = Integer.parseInt(parts[2].trim());

                if(validateItemInfo(name,value)){
                    Item item;
                    if(type.equalsIgnoreCase("armor"))
                        item = new Armor(name, type, value);
                    else
                        item = new Weapon(name, type, value);

                    inventory.put(index,item);
                    ++index;
                }
            }
        } catch (NumberFormatException e){
            System.out.println("Item is in wrong format");
        } catch (RuntimeException e){
            System.out.print("Item did not have valid formated information in text file: " + e.getMessage());
        } catch (IOException e){
            System.out.println("Failed to read File");
            throw new RuntimeException("Error while reading inventory files");
        }
    }

    private boolean validateItemInfo(String name, int value){
        return name.matches("^[A-Za-z ]{1,20}$") &&
                (value < 60 && value > 0);
    }

    public Item getNewItem(Random random){
        if(inventory.isEmpty())
            return null;

        Object[] keys = inventory.keySet().toArray();
        return inventory.get((Integer) keys[random.nextInt(keys.length)]);
    }

    public Item getSpecificItem(int key){
        return inventory.get(key);
    }
}
