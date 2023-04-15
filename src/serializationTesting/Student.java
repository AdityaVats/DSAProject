package serializationTesting;

import java.io.Serializable;

/**
 * Created by libsys on 1/4/2023.
 */
public class Student implements Serializable {

    private static int count;
    private int id;
    private String dept;
    private transient String password;


    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Student.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
