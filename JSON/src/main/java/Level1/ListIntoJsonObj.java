package Level1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class Student{
    private String name;
    private int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(){
        this.age = age;
    }
}
public class ListIntoJsonObj {
    public static void main(String[] args) throws JsonProcessingException {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ragul", 21));
        students.add(new Student("Rohit", 20));

        ObjectMapper mapper = new ObjectMapper();
        String jsonArray = mapper.writeValueAsString(students);

        System.out.println(jsonArray);
    }
}
