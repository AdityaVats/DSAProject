package serializationTesting;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by libsys on 1/4/2023.
 */
public class SerializationDriver  {
    public static void main(String[] args) throws Exception{
        Student student = new Student();
        student.setId(1);
        student.setDept("SDG");
        Student.setCount(2);
        student.setPassword("Aditya");
        String path = "C:\\Users\\libsys\\Desktop\\student.txt";
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student s = (Student) ois.readObject();
        //FileOutputStream fos = new FileOutputStream(path);
        //ObjectOutputStream oos = new ObjectOutputStream(fos);
        //oos.writeObject(student);
    }
}
