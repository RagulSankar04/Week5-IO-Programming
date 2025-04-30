package Level2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterJSON {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree("E:\\Capgemini_Working\\Day29 - JSON\\JSON\\src\\main\\resources\\data.json");
        if(rootNode.isArray()){
            for (JsonNode node : rootNode){
                int age = node.get("age").asInt();
                if(age > 25){
                    System.out.println("Name: " + node.get("name").asText() + ", Age: " + age);
                }
            }
        }
    }
}
