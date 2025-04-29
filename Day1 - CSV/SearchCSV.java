import java.io.*;
import java.util.*;

public class SearchCSV {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        String filePath = "students.csv";
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Name of Employee to search for:  ");
        String searchName = sc.nextLine().trim();

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            br.readLine();

            String line;
            while((line = br.readLine()) != null){
                String[] columns = line.split(",");
                String name = columns[1].trim();

                if(name.equalsIgnoreCase(searchName)){
                    System.out.println("ID: " + columns[0]);
                    System.out.println("Age: " + columns[2]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee '" + searchName + "' not found.");
            }
            
        } catch (IOException e) {
            System.err.println("An Error Occurred..." + e.getMessage());
        }
        sc.close();
    }
}
