package DefaultPackage;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Delay {

    public static void delay() {
        try {
        Thread.sleep(900);

        } catch(InterruptedException e) {
        throw new RuntimeException(e);
        }
    }

//    private static void slowOutNoEndline(String message, int delay) {
//        playSound();
//        for(int i = 0; i < message.length(); ++i){
//            char c = message.charAt(i);
//            System.out.print(c);
//            System.out.flush();
//
//            try {
//                Thread.sleep(delay); //40
//            }catch (InterruptedException e){
//                Thread.currentThread().interrupt();
//            }
//        }
//    }

    public static void slowOut(String message){
        playSound();
        for(int i = 0; i < message.length(); ++i){
            char c = message.charAt(i);
            System.out.print(c);
            System.out.flush();

            try {
                Thread.sleep(40); //40
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
    public static void slowOutForInput(String message){
        playSound();
        for(char c : message.toCharArray()){
            System.out.print(c);
            System.out.flush();

            try {
                Thread.sleep(50); //50
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void playSound() {
        try {
            Random choice = new Random();
            int pick = (choice.nextInt() % 2) + 1;
            File soundFile = new File("src/DefaultPackage/sounds/key_presses.Wav");
            switch (pick){
                case 1 -> soundFile = new File("src/DefaultPackage/sounds/key_presses2.Wav");
                case 2 -> soundFile = new File("src/DefaultPackage/sounds/key_presses3.Wav");
                default -> soundFile = new File("src/DefaultPackage/sounds/key_presses.Wav");
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Could not play sound: " + e.getMessage());
        }
    }

}
