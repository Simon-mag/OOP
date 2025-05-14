import java.io.*;

public class RandomAccessFileExample {

    public static void main(String[] args) {
        String filePath = "data.dat";

        // Step 1: Create the file with some initial content
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            // Write 100 bytes of 'A' characters for demo
            for (int i = 0; i < 100; i++) {
                fos.write('A');
            }
            System.out.println("Initial file created with 100 'A' characters.");
        } catch (IOException e) {
            System.err.println("Error during initial file creation: " + e.getMessage());
        }

        // Step 2: Modify the file at byte position 50 using RandomAccessFile
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            raf.seek(50); // Move to byte 50
            raf.writeBytes("inserted!"); // Overwrites starting from byte 50
            System.out.println("Data inserted at byte position 50.");
        } catch (IOException e) {
            System.err.println("Error during random access write: " + e.getMessage());
        }

        // Step 3: Read the result and print to console
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] content = fis.readAllBytes();
            String result = new String(content);
            System.out.println("Final file content:\n" + result);
        } catch (IOException e) {
            System.err.println("Error during file read: " + e.getMessage());
        }
    }
}
