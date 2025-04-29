import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCSV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("large.csv"));
        String line = br.readLine();
        int count = 0;

        while (line != null) {
            int linesRead = 0;
            while (line != null && linesRead < 100) {
                count++;
                linesRead++;
                line = br.readLine();
            }
            System.out.println("Processed: " + count);
        }

        br.close();
    }
}
