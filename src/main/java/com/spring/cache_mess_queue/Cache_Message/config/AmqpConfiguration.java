package com.spring.cache_mess_queue.Cache_Message.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {

    @Value("${rabbitmq.queue.name}")
    public static final String QUEUE = "";

    @Value("${rabbitmq.exchange.name}")
    public static String EXCHANGE = "my_Exchange";

    @Value("${rabbitmq.routingKey.name}")
    public static String ROUTING_KEY = "routeToMyQueue";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(ROUTING_KEY);
    }
}
