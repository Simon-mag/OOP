package Examples;

import java.io.*;

public class FileIOExamples {
    public static void main(String[] args) {

        // 1. Write primitives to a file using DataOutputStream
        try (DataOutputStream dataOut = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("example.dat")))) {

            dataOut.writeInt(42);
            dataOut.writeDouble(3.14);
            dataOut.writeBoolean(true);
            dataOut.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Read primitives back from the file using DataInputStream
        try (DataInputStream dataIn = new DataInputStream(
                new BufferedInputStream(new FileInputStream("example.dat")))) {

            int num = dataIn.readInt();
            double pi = dataIn.readDouble();
            boolean flag = dataIn.readBoolean();

            System.out.println("Read from file:");
            System.out.println("Int: " + num + ", Double: " + pi + ", Boolean: " + flag);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. Write characters to a file using PrintWriter
        try (PrintWriter writer = new PrintWriter(
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream("text.txt"))))) {

            writer.println("Hello, world!");
            writer.println("This is character-based output.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4. Read characters from the file using BufferedReader
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream("text.txt")))) {

            String line;
            System.out.println("\nReading lines from text.txt:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5. Write to a memory-based byte array
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        try {
            byteOut.write("Data in memory".getBytes());
            byteOut.flush();
            System.out.println("\nByteArrayOutputStream: " + byteOut.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 6. Write to a memory-based character array
        CharArrayWriter charWriter = new CharArrayWriter();
        try {
            charWriter.write("CharArray in memory");
            System.out.println("CharArrayWriter: " + charWriter.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
