package hw.module10.hw2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserTests {
    private static final String INPUT_FILE_NAME = "file2.txt";
    private static final String OUTPUT_FILE_NAME = "user.json";
    public static void main(String[] args) {
        File file = new File(INPUT_FILE_NAME);
        if (!file.exists()) {
            System.out.println("File " + file.getName() + " is not exist!");
            System.exit(-1);
        }
        List<User> users = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(" +");
                    users.add(new User(parts[0], Integer.valueOf(parts[1])));
                }
            }
        } catch (FileNotFoundException e)  {
            throw new RuntimeException(e);
        }
        file = new File(OUTPUT_FILE_NAME);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter jsonFile = new FileWriter(file)) {
            jsonFile.write(gson.toJson(users));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
