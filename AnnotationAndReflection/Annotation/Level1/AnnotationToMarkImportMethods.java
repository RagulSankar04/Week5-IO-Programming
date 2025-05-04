import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod{
    String level() default "HIGH";
}

class ApplicationService{

    @ImportantMethod
    public void initializeSystem(){
        System.out.println("System Initialized");
    }
    @ImportantMethod(level = "MEDIUM")
    public void performBackup(){
        System.out.println("Backup Performed");
    }
    public void temporaryMethod(){
        System.out.println("Temporary method - not critical.");
    }
}


public class AnnotationToMarkImportMethods {
    public static void main(String[] args) {
        Method[] methods = ApplicationService.class.getDeclaredMethods();

        System.out.println("Important Methods:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("- " + method.getName() + " (Level: " + annotation.level() + ")");
            }
        }

        ApplicationService app = new ApplicationService();
        app.initializeSystem();
        app.performBackup();
        app.temporaryMethod();
    }
}
