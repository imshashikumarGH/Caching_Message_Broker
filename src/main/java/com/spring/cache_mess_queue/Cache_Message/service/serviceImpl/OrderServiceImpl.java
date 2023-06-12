package com.spring.cache_mess_queue.Cache_Message.service.serviceImpl;

import com.google.gson.Gson;
import com.spring.cache_mess_queue.Cache_Message.config.AmqpConfiguration;
import com.spring.cache_mess_queue.Cache_Message.model.Order;
import com.spring.cache_mess_queue.Cache_Message.model.OrderProcessed;
import com.spring.cache_mess_queue.Cache_Message.service.OrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private RabbitTemplate template;

    @Override
    public String orderProcessedService(Order order) {
        order.setUuid(UUID.randomUUID().toString());
        template.convertAndSend(AmqpConfiguration.EXCHANGE,
                AmqpConfiguration.ROUTING_KEY,
                new Gson().toJson(OrderProcessed.builder()
                        .order(order)
                        .status("PROCESSED")
                        .message("Success")
                        .build()));
        return "Success !!";
    }
}
