package Level2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJSONPrintKeyValues {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("E:\\Capgemini_Working\\Day29 - JSON\\JSON\\src\\main\\resources\\data.json")));
            JSONObject jsonObject = new JSONObject(content);
            printJson(jsonObject, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printJson(Object obj, String path) {
        if (obj instanceof JSONObject jsonObj) {
            for (String key : jsonObj.keySet()) {
                printJson(jsonObj.get(key), path.isEmpty() ? key : path + "." + key);
            }
        } else if (obj instanceof JSONArray array) {
            for (int i = 0; i < array.length(); i++) {
                printJson(array.get(i), path + "[" + i + "]");
            }
        } else {
            System.out.println(path + ": " + obj);
        }
    }
}
