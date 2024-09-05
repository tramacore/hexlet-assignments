package exercise;

import java.util.Map;
import java.util.List;

import static util.Utils.serialize;
import static util.Utils.atr;
import static util.Utils.nameAtr;

public class PairedTag extends Tag {

    private String name;
    private Map<String, String> atributes;
    private String body;
    private List<Tag> tags;

    public PairedTag(String name, Map<String, String> atributes, String body, List<Tag> tags) {
        this.name = name;
        this.atributes = atributes;
        this.body = body;
        this.tags = tags;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("<" + name + " ");
        for (int i = 0; i < nameAtr(atributes).length; i++) {
            stringBuilder.append(nameAtr(atributes)[i] + "=" + atr(atributes)[i] + " ");
        }
        String answer = stringBuilder.toString().trim() + ">" + body + serialize(tags) + "</" + name + ">";
        return answer;
    }
}
