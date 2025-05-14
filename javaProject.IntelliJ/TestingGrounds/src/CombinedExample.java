import java.io.*;
import java.util.Formatter;

public class CombinedExample {

    public static void main(String[] args) {
        String filePath = "example.txt";

        // === WRITING TO FILE ===

        // 1. Write using FileWriter (no buffering or formatting)
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write("1. Written using FileWriter\n");
        } catch (IOException e) {
            System.err.println("Error writing with FileWriter: " + e.getMessage());
        }

        // 2. Write using BufferedWriter for better performance
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write("2. Written using BufferedWriter");
            bw.newLine(); // Adds newline
        } catch (IOException e) {
            System.err.println("Error writing with BufferedWriter: " + e.getMessage());
        }

        // 3. Write using Formatter with BufferedWriter and FileWriter
        try (
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            Formatter formatter = new Formatter(bw)
        ) {
            String item = "apple";
            double price = 1.25;
            formatter.format("3. Formatted line: Item=%s, Price=%.2f%n", item, price);
        } catch (IOException e) {
            System.err.println("Error writing with Formatter: " + e.getMessage());
        }

        // === READING THE FILE BACK ===
        System.out.println("=== Contents of the file ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
