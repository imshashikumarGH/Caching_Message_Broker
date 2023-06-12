package com.spring.cache_mess_queue.Cache_Message.listener;

import com.google.gson.Gson;
import com.spring.cache_mess_queue.Cache_Message.model.OrderProcessed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class OrderListener {
    public static final String QUEUE = "myQueue";

    @RabbitListener(queues = {QUEUE}, autoStartup = "true", ackMode = "AUTO")
    public void getMessageFromQueue(String message) {
        OrderProcessed processed = new Gson().fromJson(message, OrderProcessed.class);

        log.info(processed.toString());
    }
}
