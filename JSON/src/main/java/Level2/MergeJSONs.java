package Level2;

import org.json.JSONObject;

public class MergeJSONs {
    public static void main(String[] args) {
        JSONObject obj1 = new JSONObject();
        obj1.put("Name", "Ragul");
        obj1.put("Age", 21);

        JSONObject obj2 = new JSONObject();
        obj2.put("Email", "ragulsankar2004@gmail.com");
        obj2.put("City", "Chennai");

        for(String key: obj2.keySet()){
            obj1.put(key, obj2.get(key));
        }

        System.out.println("Merged JSONs: " + obj1.toString(3));
    }
}
