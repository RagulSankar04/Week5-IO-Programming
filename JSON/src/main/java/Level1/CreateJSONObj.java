package Level1;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJSONObj {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", "Ragul");
        jsonObject.put("age", 21);

        JSONArray subjects = new JSONArray();
        subjects.put("Java");
        subjects.put("CPP");
        subjects.put("Python");

        jsonObject.put("Subjects", subjects);

        System.out.println(jsonObject.toString(4));
    }
}
