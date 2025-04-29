
import java.io.*;

public class WriteDataCSV {
    public static void main(String[] args) {
        String filepath = "employees.csv";

        try (FileWriter writer = new FileWriter(filepath)) {
            writer.append("\nID, Name, Department, Salary\n");

            writer.append("201,John Smith,Engineering,75000\n");
            writer.append("202,Alice Johnson,HR,68000\n");
            writer.append("203,Bob Lee,Marketing,72000\n");
            writer.append("204,Meera Singh,Finance,80000\n");
            writer.append("205,Ravi Kumar,IT,70000\n");

            System.out.println("Data written to " + filepath + " successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
