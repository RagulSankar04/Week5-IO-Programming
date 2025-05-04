import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class ExpensiveService {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int num) {
        if (cache.containsKey(num)) {
            return cache.get(num);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        int result = num * num;
        cache.put(num, result);
        return result;
    }
}

public class CacheSystemExample {
    public static void main(String[] args) throws Exception {
        ExpensiveService service = new ExpensiveService();

        long start1 = System.nanoTime();
        System.out.println("Result: " + service.computeSquare(5));
        long end1 = System.nanoTime();
        System.out.println("Time: " + (end1 - start1) / 1_000_000 + " ms");

        long start2 = System.nanoTime();
        System.out.println("Result: " + service.computeSquare(5));
        long end2 = System.nanoTime();
        System.out.println("Time: " + (end2 - start2) / 1_000_000 + " ms");
    }
}
