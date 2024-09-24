package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class App {

    public static void save(Path path, Car car) throws IOException {
        try {
        String data = car.serialize();
        Files.write(path, data.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static Car extract(Path path) throws JsonParseException, JsonMappingException, IOException {
        String json = new String(Files.readAllBytes(path));
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Car.class);
}
}
