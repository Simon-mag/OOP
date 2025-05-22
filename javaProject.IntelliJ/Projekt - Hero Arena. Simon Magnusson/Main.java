import Engines.HeroArena;

public class Main {
    public static void main(String[] args){
        try {
            HeroArena gameManager = new HeroArena();
            gameManager.run();

        } catch (ExceptionInInitializerError e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("unknown error " + e.getMessage());
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }
}
