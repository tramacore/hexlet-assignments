package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {
    public static List<String> validate(Address address) throws IllegalAccessException {
        List<String> answer = new ArrayList<String>();

        for(Field field: address.getClass().getDeclaredFields()){
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (notNull != null) {
                field.setAccessible(true);
            try {
                Object value = field.get(address);
                if (value == null) {
                    answer.add(field.getName());    
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
        return answer;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> answer = new HashMap<>();

        for(Field field: address.getClass().getDeclaredFields()){
            MinLength minLength = field.getAnnotation(MinLength.class);
            NotNull notNull = field.getAnnotation(NotNull.class);
            field.setAccessible(true);
            
            try {
                List<String> messages = new ArrayList<>();
                Object value = field.get(address);
                if (notNull != null && value == null) {
                    messages.add("can not be null");
                }
                
                if (minLength != null && value instanceof String) {
                    String string = (String) value;
                    if (string.length() < minLength.minLength()) {
                        messages.add("length less than " + minLength.minLength());
                    }
                }

                if (!messages.isEmpty()) {
                    answer.put(field.getName(), messages);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    
    return answer;
    }
}