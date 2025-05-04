import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class User {
    private String role;
    public User(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}

class AdminService {

    @RoleAllowed("ADMIN")
    public void performAdminTask() {
        System.out.println("Admin task performed successfully.");
    }
}

public class RoleBasedAccessControl {
    public static void main(String[] args) throws Exception {
        User adminUser = new User("ADMIN");
        User guestUser = new User("GUEST");

        invokeIfAuthorized(new AdminService(), "performAdminTask", adminUser);
        invokeIfAuthorized(new AdminService(), "performAdminTask", guestUser);
    }

    public static void invokeIfAuthorized(Object obj, String methodName, User user) throws Exception {
        Method method = obj.getClass().getMethod(methodName);
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            if (roleAllowed.value().equals(user.getRole())) {
                method.invoke(obj);
            } else {
                System.out.println("Access Denied!");
            }
        } else {
            method.invoke(obj);
        }
    }
}
