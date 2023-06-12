package com.spring.cache_mess_queue.Cache_Message.producer;

import com.spring.cache_mess_queue.Cache_Message.model.Order;
import com.spring.cache_mess_queue.Cache_Message.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    OrderService orderService;


    @PostMapping("/pushMessage")
    public String bookOrder(@RequestBody Order order) {
        return orderService.orderProcessedService(order);
    }

}
