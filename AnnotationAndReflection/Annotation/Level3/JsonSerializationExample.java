import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "email_address")
    private String email;

    private int age;

    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
}

class JsonSerializer {
    public static String toJson(Object obj) {
        Class<?> clazz = obj.getClass();
        Map<String, String> jsonMap = new LinkedHashMap<>();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                try {
                    Object value = field.get(obj);
                    jsonMap.put(annotation.name(), value.toString());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\": \"")
                .append(entry.getValue()).append("\", ");
        }
        if (!jsonMap.isEmpty()) {
            json.setLength(json.length() - 2);
        }
        json.append("}");
        return json.toString();
    }
}

public class JsonSerializationExample {
    public static void main(String[] args) {
        User user = new User("ragul", "ragul@example.com", 22);
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}
