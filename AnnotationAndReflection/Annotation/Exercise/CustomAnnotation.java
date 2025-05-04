import java.lang.annotation.*;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority() default "Medium";
    String assignedTo() default "Unassigned";
}

class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Ragul")
    public void completeReport() {
        System.out.println("Completing the report task...");
    }
}

public class CustomAnnotation {
    public static void main(String[] args) {
        try {
            Method method = TaskManager.class.getMethod("completeReport");

            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }

            new TaskManager().completeReport();

        } catch (NoSuchMethodException e) {
            
        }
    }
}
