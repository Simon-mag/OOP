package DefaultPackage;

public class Delay {

    public static void delay() {
     try {
        Thread.sleep(1000);
    }
     catch(InterruptedException e)
     {
        throw new RuntimeException(e);
     }
}
}
