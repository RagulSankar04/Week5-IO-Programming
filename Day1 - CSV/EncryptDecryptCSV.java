import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Base64;

public class EncryptDecryptCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("encrypted.csv"));
        String line = br.readLine();
        bw.write(line);
        bw.newLine();
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 4) {
                parts[2] = Base64.getEncoder().encodeToString(parts[2].getBytes());
                parts[3] = Base64.getEncoder().encodeToString(parts[3].getBytes());
                bw.write(String.join(",", parts));
                bw.newLine();
            }
        }
        br.close();
        bw.close();
        BufferedReader br2 = new BufferedReader(new FileReader("encrypted.csv"));
        String l = br2.readLine();
        while ((l = br2.readLine()) != null) {
            String[] p = l.split(",");
            if (p.length >= 4) {
                p[2] = new String(Base64.getDecoder().decode(p[2]));
                p[3] = new String(Base64.getDecoder().decode(p[3]));
                System.out.println(String.join(",", p));
            }
        }
        br2.close();
    }
}
