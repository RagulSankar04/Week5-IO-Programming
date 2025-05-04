import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports{
    BugReport[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport{
    String description();
}

class CodeAnalyzer {

    @BugReport(description = "Null pointer when input is null")
    @BugReport(description = "IndexOutOfBounds when list is empty")
    public void analyze() {
        System.out.println("Analyzing code...");
    }
}

public class RepeatableAnnotation {
    public static void main(String[] args) {
        try {
            Method method = CodeAnalyzer.class.getMethod("analyze");

            if (method.isAnnotationPresent(BugReports.class)) {
                BugReport[] bugReports = method.getAnnotation(BugReports.class).value();
                for (BugReport bug : bugReports) {
                    System.out.println("Bug: " + bug.description());
                }
            }

            new CodeAnalyzer().analyze();

        } catch (NoSuchMethodException e) {

        }
    }
}
