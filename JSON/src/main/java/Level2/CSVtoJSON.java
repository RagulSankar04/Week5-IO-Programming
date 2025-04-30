package Level2;

import org.json.CDL;
import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVtoJSON {
    public static void main(String[] args) throws IOException {
        String csvData = new String(Files.readAllBytes(Paths.get("E:\\Capgemini_Working\\Day29 - JSON\\JSON\\src\\main\\resources\\data.csv")));

        JSONArray jsonArray = CDL.toJSONArray(csvData.trim());

        if (jsonArray == null) {
            System.out.println("Failed to parse CSV into JSON. Check your CSV format.");
        } else {
            System.out.println("Converted JSON:\n" + jsonArray.toString(4));
        }
    }
}
