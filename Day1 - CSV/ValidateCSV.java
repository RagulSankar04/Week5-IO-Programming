import java.io.*;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "contacts.csv";

        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 2;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String email = columns[2].trim();
                String phone = columns[3].trim();

                boolean emailValid = emailPattern.matcher(email).matches();
                boolean phoneValid = phonePattern.matcher(phone).matches();

                if (!emailValid || !phoneValid) {
                    System.out.println("Invalid data at line " + lineNumber + ": " + line);
                    if (!emailValid) {
                        System.out.println(" -> Invalid Email: " + email);
                    }
                    if (!phoneValid) {
                        System.out.println(" -> Invalid Phone Number: " + phone);
                    }
                }
                lineNumber++;
            }

        } catch (IOException e) {
        }
    }
}
