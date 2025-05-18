import Engines.GameManager;

public class Main {
    public static void main(String[] args){
        try {
            GameManager gameManager = new GameManager();
            gameManager.runHeroArena();

        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("unknown error " + e.getMessage());
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }
}
