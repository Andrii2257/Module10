package hw.module10.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordsFrequencyCounter {
    private static final String FILE_NAME = "words.txt";

    public static void main(String[] args) {
        getWordFrequency();
    }

    public static void getWordFrequency() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("file = " + file.getName() + " is not exist!");
            System.exit(-1);
        }
        HashMap<String, Integer> wordFreqMap = new HashMap<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] words = scanner.nextLine().split(" +");
                for (String word: words) {
                    wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Map.Entry<String, Integer>> list = wordFreqMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
        for (var item : list) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}
