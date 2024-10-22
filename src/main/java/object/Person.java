package object;

import lombok.Data;
import java.io.Serializable;

@Data
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    transient private String password;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }
}