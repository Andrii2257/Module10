package hw.module10.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneFilter {
    private static final String FILE_NAME = "file.txt";
    public static void main(String[] args) {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("File " + file.getName() + " not exists!");
            System.exit(-1);

        }
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.matches("^\\(\\d{3}\\) \\d{3}-\\d{4}$")
                        || line.matches("^\\d{3}-\\d{3}-\\d{4}$")) {
                    System.out.println("line = " + line);
                }

            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }


    }

}
