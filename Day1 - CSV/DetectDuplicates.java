import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class DetectDuplicates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data.csv"));
        HashSet<String> set = new HashSet<>();
        String line = br.readLine();

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length > 0) {
                if (set.contains(parts[0])) {
                    System.out.println("Duplicate: " + line);
                } else {
                    set.add(parts[0]);
                }
            }
        }

        br.close();
    }
}
