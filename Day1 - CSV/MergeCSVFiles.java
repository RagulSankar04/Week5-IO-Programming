import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        Map<String, String[]> studentMap = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            br1.readLine();
            String line;
            while ((line = br1.readLine()) != null) {
                String[] columns = line.split(",");
                studentMap.put(columns[0].trim(), new String[] {
                    columns[1].trim(),
                    columns[2].trim()
                });
            }
        } catch (IOException e) {
            System.err.println("Error reading file1: " + e.getMessage());
        }

        try (
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {
            br2.readLine();
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            String line;
            while ((line = br2.readLine()) != null) {
                String[] columns = line.split(",");
                String id = columns[0].trim();
                String marks = columns[1].trim();
                String grade = columns[2].trim();

                if (studentMap.containsKey(id)) {
                    String[] student1 = studentMap.get(id);
                    bw.write(id + "," + student1[0] + "," + student1[1] + "," + marks + "," + grade);
                    bw.newLine();
                }
            }
            System.out.println("Merged file written to: " + outputFile);

        } catch (IOException e) {
            System.err.println("Error merging files: " + e.getMessage());
        }
    }
}
