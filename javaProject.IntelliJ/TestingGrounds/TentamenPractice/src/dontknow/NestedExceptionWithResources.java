package dontknow;

import java.io.*;
public class NestedExceptionWithResources {
    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println("Caught in main: " + e.getMessage());
        }
    }
    public static void methodA() throws Exception {
        try (BufferedReader br = new BufferedReader(new
                StringReader("test"))) {
            System.out.println("Resource opened in methodA");
            methodB();
        } catch (Exception e) {
            System.out.println("Caught in methodA: " + e.getMessage());
            throw new Exception("Exception from methodA");
        }
    }
    public static void methodB() throws Exception {
        try {
            methodC();
        } catch (Exception e) {
            System.out.println("Caught in methodB: " + e.getMessage());
            throw new Exception("Exception from methodB");
        } finally {
            System.out.println("Finally block in methodB");
        }
    }
    public static void methodC() throws Exception {
        try {
            throw new Exception("Exception from methodC");
        } finally {
            System.out.println("Finally block in methodC");
        }
    }
}
/*

1.Resource opened in methodA
2.Caught in methodB: Exception from methodC
3.Finally block in methodB
4.Caught in methodA:  Exception from methodB
5.Caught in main: Exception from methodA
 */