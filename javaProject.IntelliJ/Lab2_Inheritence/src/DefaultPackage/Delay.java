package DefaultPackage;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Delay {

    public static void delay() {
        try {
        Thread.sleep(900);

        } catch(InterruptedException e) {
        throw new RuntimeException(e);
        }
    }

    public static void slowOut(String message){
        int interval = 6;
        for(int i = 0; i < message.length(); ++i){
            char c = message.charAt(i);
            System.out.print(c);
            System.out.flush();
            if(i % interval == 0)
                playSound();

            try {
                Thread.sleep(30);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
    public static void slowOutForInput(String message){

        for(char c : message.toCharArray()){
            System.out.print(c);
            System.out.flush();


            try {
                Thread.sleep(30);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void playSound() {
        try {
            File soundFile = new File("src/DefaultPackage/sounds/keyboard_sound.Wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Could not play sound: " + e.getMessage());
        }
    }

}
