import java.util.*;

public class Registry<T extends Person> {

    ArrayList<T> registry = new ArrayList<>();

    public void addItem(T item){
        registry.add(item);
    }
    public void removeItem(T item){
        registry.remove(item);
    }
    public void listItems(){
        for(T people : registry){
            System.out.printf("%s - %d: %s", people.getRole(), people.getID(), people.getName());
        }
    }
    public static <T extends Comparable<T>> T sortItems (){

    }




    public void sortItems(Comparator<T> comparator){
        Collections.sort();
    }


    public void countByInitial(){
        Map<Character,Integer> initialCountList = new TreeMap<>();
        for(Person person : registry){
            char initial = Character.toUpperCase(person.getName().charAt(0));
            initialCountList.put(initial, initialCountList.getOrDefault(initial,0) + 1);
        }
    }



}
