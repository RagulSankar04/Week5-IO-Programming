package Level1;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ExtractSpecificFields {
    public static void main(String[] args) {
        try{
            String content = new String(Files.readAllBytes(Paths.get("E:\\Capgemini_Working\\Day29 - JSON\\JSON\\src\\main\\resources\\data.json")));
            JSONObject jsonObject = new JSONObject(content);

            String name = jsonObject.getString("name");
            String email = jsonObject.getString("email");

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
