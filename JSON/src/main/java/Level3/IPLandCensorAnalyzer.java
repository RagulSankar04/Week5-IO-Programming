package Level3;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class IPLandCensorAnalyzer {
    public static void main(String[] args) throws Exception {
        String jsonData = new String(Files.readAllBytes(Paths.get("E:\\Capgemini_Working\\Day29 - JSON\\JSON\\src\\main\\resources\\ipl_data.json")));
        JSONArray jsonArray = new JSONArray(jsonData);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject match = jsonArray.getJSONObject(i);
            match.put("team1", censorTeamName(match.getString("team1")));
            match.put("team2", censorTeamName(match.getString("team2")));
            match.put("player_of_match", "REDACTED");
        }
        Files.write(Paths.get("ipl_censored.json"), jsonArray.toString(2).getBytes());
        BufferedReader br = new BufferedReader(new FileReader("ipl_data.csv"));
        String line;
        List<String[]> csvData = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            if (csvData.isEmpty()) {
                csvData.add(values);
            } else {
                values[1] = censorTeamName(values[1]);
                values[2] = censorTeamName(values[2]);
                values[6] = "REDACTED";
                csvData.add(values);
            }
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("ipl_censored.csv"));
        for (String[] row : csvData) {
            bw.write(String.join(",", row));
            bw.newLine();
        }
        bw.close();
    }
    private static String censorTeamName(String teamName) {
        if (teamName.contains("Mumbai")) {
            return "Mumbai ***";
        }
        return teamName;
    }
}
