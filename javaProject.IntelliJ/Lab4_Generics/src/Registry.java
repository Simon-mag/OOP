import java.util.*;


// T extends Person meaning that T can be any kind of Person or object that extends Person //
public class Registry<T extends Person> {
    // also aplies to this T in the ArrayList //
    ArrayList<T> registry = new ArrayList<>();

    public void addItem(T item){
        registry.add(item);
    }

    public void removeItem(T item){
        registry.remove(item);
    }

    public void listItems(){
        for(T people : registry){
            System.out.printf(people.toString());
        }
        System.out.println();
    }

    public void sortItems (){
        Collections.sort(registry);
    }

    //The comparator is what kind of thing we are comparing, in this case the name in lowercase//
    public void sortItems(Comparator<T> comparator){
        registry.sort(comparator);
    }

    public void countByInitial(){
        Map<Character,Integer> initialCountList = new TreeMap<>();
        for(Person person : registry){
            char initial = Character.toUpperCase(person.getName().charAt(0));
            initialCountList.put(initial, initialCountList.getOrDefault(initial,0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : initialCountList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }
}
