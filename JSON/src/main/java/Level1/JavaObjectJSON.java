package Level1;

import org.json.JSONObject;

public class JavaObjectJSON {
    String make;
    String model;
    int year;

    public JavaObjectJSON(String make, String car, int year){
        this.make = make;
        this.model = car;
        this.year = year;
    }
    public static void main(String[] args) {
        JavaObjectJSON car = new JavaObjectJSON("Hyundai", "i20", 2024);

        JSONObject carJson = new JSONObject();
        carJson.put("Make", car.make);
        carJson.put("Model", car.model);
        carJson.put("Year", car.year);

        System.out.println(carJson.toString(3));
    }
}
