import java.io.*;
import java.util.*;
import java.util.Formatter;

public class Appending {

    private static final String FILE_NAME = "example.txt";

    public static void main(String[] args) {
        appendWithWriter();
        appendWithFormatter();
        try {
            insertIntoFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Appends a simple line using BufferedWriter
    public static void appendWithWriter() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write("Appended line using Writer\n");
            writer.flush(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Appends a formatted line using Formatter
    public static void appendWithFormatter() {
        try (Formatter formatter = new Formatter(new FileWriter(FILE_NAME, true))) {
            formatter.format("Appended using Formatter: %d, %.2f%n", 42, 3.1415);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Inserts a line at a specific position in the file by rewriting it
    public static void insertIntoFile() throws IOException {
        File file = new File(FILE_NAME);
        List<String> lines = new ArrayList<>();

        // Read all lines into a list
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        // Insert a line at index 2 (or any position you'd like)
        lines.add(2, ">>> INSERTED LINE <<<");

        // Write all lines back to the file (overwriting it)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
