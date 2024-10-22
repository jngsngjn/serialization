package file;

import object.Person;

import java.io.*;

public class FileExample {
    public static void main(String[] args) {
        Person person = new Person("PersonA", 20, "1234");

        // 1. 객체를 파일에 직렬화하여 저장
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(person); // 객체 직렬화
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. 파일에서 객체를 역직렬화하여 읽어오기
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person deserializedPerson = (Person) ois.readObject();  // 객체 역직렬화
            System.out.println("deserializedPerson = " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}