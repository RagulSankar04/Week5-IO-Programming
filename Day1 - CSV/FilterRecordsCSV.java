
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FilterRecordsCSV {
    public static void main(String[] args) {
        String filePath = "students.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            br.readLine();

            String line;
            System.out.println("Students scoring more than 80 marks:");
            System.out.println("----------------------------------------");

            while((line = br.readLine()) != null){
                String[] columns = line.split(",");
                int marks = Integer.parseInt(columns[3]);

                if(marks > 80){
                    System.out.println("ID: " + columns[0] + " Name: " + columns[1] + " Age: " + columns[2] + " Marks: " + columns[3]);
                }
            }
            
        } catch (IOException e) {
            System.err.println("An Error Occurred..." + e.getMessage());
        }


    }
}
