package OOPEXAMSTYLE12;

public class Main {
    public static void main(String[] args) {

        Speakable[] speakables ={
            new Dog(),
            new Robot()
        };

       for (Speakable speakable : speakables) {
           speakable.speak();
       }
    }
}
