import java.io.*;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFilePath = "employees.csv";
        String outputFilePath = "updated_employees.csv";

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))
        ) {
            String line = br.readLine();
            if (line != null) {
                bw.write(line);
                bw.newLine();
            }

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String department = columns[2].trim();

                if (department.equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(columns[3].trim());
                    salary *= 1.10;
                    columns[3] = String.format("%.2f", salary);
                }

                bw.write(String.join(",", columns));
                bw.newLine();
            }

            System.out.println("Updated file written to: " + outputFilePath);

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
