import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldMayBeFinal")
class Student {
    private String id;
    private String name;
    private int age;
    private double marks;

    public Student(String id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks;
    }
}

public class CSVintoJava {
    public static void main(String[] args) {
        String filePath = "students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String id = columns[0].trim();
                String name = columns[1].trim();
                int age = Integer.parseInt(columns[2].trim());
                double marks = Double.parseDouble(columns[3].trim());

                students.add(new Student(id, name, age, marks));
            }
            System.out.println("Student Details");
            System.out.println("----------------");
            for (Student student : students) {
                System.out.println(student);
            }

        } catch (IOException e) {
            System.err.println("An Error Occured" + e.getMessage());
        }
    }
}
