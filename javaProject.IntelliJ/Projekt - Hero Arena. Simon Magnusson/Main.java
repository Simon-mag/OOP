import Engines.GameManager;

public class Main {
    public static void main(String[] args){
        boolean canStart = true;
        try {
            GameManager gameManager = new GameManager();
            gameManager.run();

        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }


    }
}
