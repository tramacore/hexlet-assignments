package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

public abstract class Tag {
    private String name;
    private Map<String, String> atributes;

    void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAtributes(Map<String, String> atributes) {
        this.atributes = atributes;
    }

    public Map<String, String> getAtributes() {
        return atributes;
    }
}
