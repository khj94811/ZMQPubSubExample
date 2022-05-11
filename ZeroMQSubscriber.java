package com.example.bidirectionalzeromq;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class ZeroMQSubscriber {
    private final ZContext context = new ZContext();
    private final ZMQ.Socket subscriber = context.createSocket(SocketType.SUB);

    public ZeroMQSubscriber() {
        subscriber.connect("tcp://127.0.0.1:5555");
        subscriber.subscribe(ZMQ.SUBSCRIPTION_ALL);
    }

    public String receive() {
        return subscriber.recvStr(1);
    }

    public void close() {
        subscriber.close();
        context.close();
    }
}
