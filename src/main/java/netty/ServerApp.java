package netty;

import netty.server.MyServer;

public class ServerApp {
    public static void main(String[] args) throws InterruptedException {
        new MyServer(8080).start();
    }
}