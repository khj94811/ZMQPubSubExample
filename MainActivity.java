package com.example.bidirectionalzeromq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ZeroMQPublisher publisher;
    private ZeroMQSubscriber subscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        publisher = new ZeroMQPublisher();
        subscriber = new ZeroMQSubscriber();
        TextView logView = findViewById(R.id.tv_log);

        findViewById(R.id.btn_send).setOnClickListener(view -> {
            publisher.send("Hello World!");
        });

        findViewById(R.id.btn_receive).setOnClickListener(view -> {
            String message = subscriber.receive();
            logView.append("Message: " + message + "\n");
        });

    }

    @Override
    protected void onDestroy() {
        publisher.close();
        subscriber.close();
        super.onDestroy();
    }
}