package Level2;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;

public class EmailValidator {
    public static void main(String[] args) {
        try {
            FileInputStream schemaStream = new FileInputStream("schema.json");
            JSONObject rawSchema = new JSONObject(new JSONTokener(schemaStream));
            Schema schema = SchemaLoader.load(rawSchema);

            FileInputStream dataStream = new FileInputStream("data.json");
            JSONObject jsonData = new JSONObject(new JSONTokener(dataStream));

            schema.validate(jsonData);
            System.out.println("Valid JSON with valid email!");

        } catch (Exception e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}

