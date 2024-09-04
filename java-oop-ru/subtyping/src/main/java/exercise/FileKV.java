package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileKV implements KeyValueStorage {
    private String file = "";
    private Map<String, String> dictionary;

    public FileKV(String file, Map<String, String> dictionary) {
        this.file = file;
        this.dictionary = new HashMap<>(dictionary);
    }

    @Override
    public void set(String key, String value) {
        dictionary.put(key, value);
    }

    @Override
    public void unset(String key) {
        dictionary.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return dictionary.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return dictionary;
    }

    public void writeToFile() {
        Utils.writeFile(file, Utils.serialize(dictionary));
    }

    public void readFromFile() {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        this.dictionary = Utils.deserialize(Utils.readFile(path));
    }
}
