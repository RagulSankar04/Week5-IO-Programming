import java.util.ArrayList;
import java.util.List;

public class SupressUncheckedWarnings {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        @SuppressWarnings("rawtypes")
        List list = new ArrayList();

        list.add("Hello");
        list.add("World");

        List<String> stringList = list;
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
