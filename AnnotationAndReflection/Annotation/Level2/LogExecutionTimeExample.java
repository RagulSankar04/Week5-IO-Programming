import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class ExecutionDemo {

    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1000; i++) {}
    }

    @LogExecutionTime
    public void slowMethod() {
        for (int i = 0; i < 1000000; i++) {}
    }

    public void regularMethod() {
        System.out.println("No timing for this method.");
    }
}

public class LogExecutionTimeExample {
    public static void main(String[] args) throws Exception {
        ExecutionDemo demo = new ExecutionDemo();
        Method[] methods = ExecutionDemo.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(demo);
                long end = System.nanoTime();
                long duration = end - start;
                System.out.println(method.getName() + " executed in " + duration + " ns");
            }
        }

        demo.regularMethod();
    }
}
