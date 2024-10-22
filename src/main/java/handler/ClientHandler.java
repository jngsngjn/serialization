package handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import serialization.Person;

import java.time.LocalDateTime;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    private final String name;
    private final int age;

    public ClientHandler(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        Person person = new Person(name, age);
        ctx.writeAndFlush(person);
        System.out.println("[CLIENT] 서버에게 객체 전송: " + person.getName());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}