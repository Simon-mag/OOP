package DefaultPackage;

public class Delay {

    public static void delay() {
        try {
        Thread.sleep(900);

        } catch(InterruptedException e) {
        throw new RuntimeException(e);
        }
    }

    public static void slowOut(String message){

        for(char c : message.toCharArray()){
            System.out.print(c);
            System.out.flush();
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
}
