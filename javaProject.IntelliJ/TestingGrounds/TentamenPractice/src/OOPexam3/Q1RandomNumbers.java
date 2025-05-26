package OOPexam3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Q1RandomNumbers {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        int size = 5;

        do {
            int randomNumber = rand.nextInt(11);

            if(!list.contains(randomNumber)){
                list.add(randomNumber);
            }
        } while (list.size() < size);

        Collections.sort(list);

        for(int i : list){
            System.out.println(i);
        }
    }



}
