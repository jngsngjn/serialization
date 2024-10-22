import client.MyClient;

public class ClientApp {
    public static void main(String[] args) throws InterruptedException {
        Thread client1 = new Thread(() -> {
            try {
                new MyClient("localhost", 8080, "A", 10).connect();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread client2 = new Thread(() -> {
            try {
                new MyClient("localhost", 8080, "B", 20).connect();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread client3 = new Thread(() -> {
            try {
                new MyClient("localhost", 8080, "C", 30).connect();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        client1.start();
        client2.start();
        client3.start();

        client1.join();
        client2.join();
        client3.join();
    }
}