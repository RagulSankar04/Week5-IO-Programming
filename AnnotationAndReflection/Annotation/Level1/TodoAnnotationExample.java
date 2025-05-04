import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectFeatures {

    @Todo(task = "Implement login feature", assignedTo = "Ragul", priority = "HIGH")
    public void loginFeature() {
    }

    @Todo(task = "Add password reset", assignedTo = "Anya")
    public void passwordResetFeature() {
    }

    public void completedFeature() {
        System.out.println("Feature completed and deployed.");
    }
}

public class TodoAnnotationExample {
    public static void main(String[] args) {
        Method[] methods = ProjectFeatures.class.getDeclaredMethods();

        System.out.println("Pending Tasks:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("- Method: " + method.getName());
                System.out.println("  Task       : " + todo.task());
                System.out.println("  Assigned To: " + todo.assignedTo());
                System.out.println("  Priority   : " + todo.priority());
            }
        }
    }
}
