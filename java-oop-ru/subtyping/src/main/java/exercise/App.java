package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class App {
    public static void swapKeyValue(KeyValueStorage dictionary) {
        Map<String, String> originalMap = new HashMap<>(dictionary.toMap());

        Map<String, String> swappedMap = new HashMap<>();

        for (Map.Entry<String, String> entry : originalMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            swappedMap.put(value, key);
            dictionary.unset(key);
        }

        for (Map.Entry<String, String> entry : swappedMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            dictionary.set(key, value);
        }
    }
}
