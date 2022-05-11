package com.example.bidirectionalzeromq;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class ZeroMQPublisher {
    private final ZContext context = new ZContext();
    private final ZMQ.Socket publisher = context.createSocket(SocketType.PUB);

    public ZeroMQPublisher() {
        publisher.bind("tcp://*:5555");
    }

    public void send(String message) {
        publisher.send(message);
    }

    public void close() {
        publisher.close();
        context.close();
    }
}
