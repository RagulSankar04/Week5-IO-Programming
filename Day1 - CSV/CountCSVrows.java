import java.io.*;

public class CountCSVrows {
    public static void main(String[] args) {
        String filePath = "employees.csv";

        int rowCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();

            while (br.readLine() != null) {
                rowCount++;
            }

            System.out.println("Total Number of Lines: " + rowCount);
        } catch (IOException e) {
            System.err.println("An Unexpected Error Occured" + e.getMessage());
        }
    }
}
