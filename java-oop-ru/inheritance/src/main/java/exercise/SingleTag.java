package exercise;

import java.util.Map;

import static util.Utils.atr;
import static util.Utils.nameAtr;


public class SingleTag extends Tag {
    private String name;
    private Map<String, String> atributes;

    public SingleTag(String name, Map<String, String> atributes) {
        this.name = name;
        super.setName(name);
        this.atributes = atributes;
        super.setAtributes(atributes);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("<" + name + " ");
        for (int i = 0; i < nameAtr(atributes).length; i++) {
            stringBuilder.append(nameAtr(atributes)[i] + "=" + atr(atributes)[i] + " ");
        }
        String answer = stringBuilder.toString().trim() + ">";
        return answer;
    }

    public Map<String, String> getAtributes() {
        return atributes;
    }
}
