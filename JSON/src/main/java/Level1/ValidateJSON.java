package Level1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJSON {
    public static void main(String[] args) {
        String jsonStr = "{ \"name\": \"Ragul\", \"age\": 21 }";  // Try invalid JSON here too

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode node = mapper.readTree(jsonStr);
            System.out.println("Valid JSON ✅");
            System.out.println(node.toPrettyString());
        } catch (Exception e) {
            System.out.println("Invalid JSON ❌");
            e.printStackTrace();
        }
    }
}
