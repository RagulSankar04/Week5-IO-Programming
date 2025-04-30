package Level2;

import org.json.JSONObject;
import org.json.XML;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONtoXML {
    public static void main(String[] args) throws Exception {

        String jsonContent = new String(Files.readAllBytes(Paths.get("data.json")));

        JSONObject jsonObject = new JSONObject(jsonContent);

        String xml = XML.toString(jsonObject);

        System.out.println(xml);
    }
}
