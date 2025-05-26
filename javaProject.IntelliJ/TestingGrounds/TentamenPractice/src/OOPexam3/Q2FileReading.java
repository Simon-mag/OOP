package OOPexam3;
import java.util.Formatter;
import java.util.Scanner;
import java.nio.file.Paths;

public class Q2FileReading {
    public static void main(String[] args) throws Exception {
        String records = "records.txt";
        String output = "output.txt";

        Scanner in = new Scanner(Paths.get(records));
        Formatter out = new Formatter(output);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] parts = line.split(" ");
            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].toUpperCase();
                out.format("%s%n" ,parts[i]);
                out.flush();
            }
        }

        out.close();
        in.close();

    }

}

