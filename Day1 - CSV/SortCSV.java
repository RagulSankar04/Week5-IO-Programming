import java.util.*;
import java.io.*;

public class SortCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                records.add(line.split(","));
            }
            records.sort((a, b) -> Double.compare(
                    Double.parseDouble(b[3].trim()),
                    Double.parseDouble(a[3].trim())));

            System.out.println(header);
            System.out.println("Top 5 Highest-Paid Employees:");
            System.out.println("-------------------------------");

            for (int i = 0; i < Math.min(5, records.size()); i++) {
                String[] emp = records.get(i);
                System.out.println("ID: " + emp[0].trim() + ", Name: " + emp[1].trim() + ", Department: "
                        + emp[2].trim() + ", Salary: " + emp[3].trim());
            }

        } catch (IOException e) {
            System.err.println("An Error Occured" + e.getMessage());
        }
    }
}
