package redis;

import object.Person;
import redis.clients.jedis.Jedis;

import java.io.*;

public class RedisExample {
    public static void main(String[] args) {
        // Redis에 연결
        try (Jedis jedis = new Jedis("localhost", 6379)) {
//            // 1. 객체 생성
//            Person person = new Person("Person_Redis", 30);
//
//            // 2. 객체를 직렬화하여 바이트 배열로 변환
//            byte[] serializedPerson = serialize(person);
//
//            // 3. Redis에 직렬화된 객체 저장
//            jedis.set("person".getBytes(), serializedPerson);

            // 4. Redis에서 바이트 배열로 객체 읽어오기
            byte[] personData = jedis.get("person".getBytes());

            // 5. 바이트 배열을 역직렬화하여 객체로 복원
            Person deserializedPerson = (Person) deserialize(personData);
            System.out.println("Redis에서 가져온 객체: " + deserializedPerson);
        }
    }

    // 객체를 직렬화하여 바이트 배열로 변환하는 메서드
    public static byte[] serialize(Object obj) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(obj);
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 바이트 배열을 객체로 역직렬화하는 메서드
    public static Object deserialize(byte[] data) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}