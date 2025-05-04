import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {

    @MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;
        validateFields();
    }

    public String getUserName(){
        return username;
    }

    private void validateFields() {
        Field[] fields = User.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                try {
                    field.setAccessible(true); // Access private field
                    String fieldValue = (String) field.get(this);
                    if (fieldValue.length() > maxLength.value()) {
                        throw new IllegalArgumentException(field.getName() + " exceeds maximum length of " + maxLength.value());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class MaxLengthAnnotationExample {
    public static void main(String[] args) {
        try {
            User user1 = new User("shortname");
            System.out.println("User created with username: " + user1.getUserName());

            User user2 = new User("thisisaverylongusername");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
