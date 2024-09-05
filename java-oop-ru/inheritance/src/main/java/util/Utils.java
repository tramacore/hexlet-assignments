package util;

import exercise.Tag;

import java.util.List;
import java.util.Map;

public class Utils {
    public static String[] nameAtr(Map<String, String> atributes) { //Метод берет все ключи из мапы
        String[] names = new String[atributes.keySet().size()];
        int i = 0;
        for (Map.Entry<String, String> entry : atributes.entrySet()) {
            names[i] = entry.getKey();
            i++;
        }
        return names;
    }

    public static String[] atr(Map<String, String> atributes) { //Метод берет все значения из мапы
        String[] atribs = new String[atributes.keySet().size()];
        int i = 0;
        for (Map.Entry<String, String> entry : atributes.entrySet()) {
            atribs[i] = "\"" + entry.getValue() + "\"";
            i++;
        }
        return atribs;
    }

    public static String serialize(List<Tag> tags) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Tag tag : tags) {
            stringBuilder.append("<" + tag.getName() + " " + nameAtr(tag.getAtributes())[i]
                    + "=" + atr(tag.getAtributes())[i] + ">");
        }
        return stringBuilder.toString();
    }
}
