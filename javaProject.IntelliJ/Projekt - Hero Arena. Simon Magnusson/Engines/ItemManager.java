package Engines;

import Items.Armor;
import Items.Item;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class ItemManager {
    private final Map<Integer,Item> inventory = new HashMap<>();


    public ItemManager(File inputInventory)throws RuntimeException {

        try(BufferedReader reader = new BufferedReader(new FileReader(inputInventory))){
            String line;
            while ((line = reader.readLine()) != null){
                int index = 1;
                String[] parts = line.trim().split("-");
                if(parts.length != 3){
                    System.out.println("Invalid Item format " + line);
                    continue;
                }

                String type = parts[0].trim();
                String name = parts[1].trim();
                int value = Integer.parseInt( parts[2].trim());

                if(validateItemInfo(type,name,value)){
                    if(type.equalsIgnoreCase("armour")){
                        Armor armor = new Armor(name, type, value);
                        inventory.put(index,armor);
                        ++index;
                    }
                }
            }
        } catch (NumberFormatException e){
            System.out.println("Item is in wrong format");
        } catch (RuntimeException e){
            System.out.print("Item did not have valid formated information in \"Armors.txt\": " + e.getMessage());
        } catch (IOException e){
            System.out.println("Failed to read File");
            throw new RuntimeException("Error while reading inventory files");
        }
    }


    private boolean validateItemInfo(String type,String name, int value){
        return type.matches("^[Aa][Rr][Mm][Oo][Uu][Rr]$") &&
                name.matches("^[A-Za-z]{1,15}") &&
                (value < 30 && value > 0);
    }


    public Item getNewItem(){
        Random randomGenerator = new Random();
        return inventory.get((randomGenerator.nextInt() % inventory.size()) + 1);
    }

    public Map<Integer, Item> getInventory() {return inventory;}
}
