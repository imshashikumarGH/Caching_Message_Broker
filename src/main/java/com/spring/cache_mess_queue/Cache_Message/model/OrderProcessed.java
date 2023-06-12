package com.spring.cache_mess_queue.Cache_Message.model;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class OrderProcessed implements Serializable {
    private Order order;
    private String status;//progress,completed
    private String message;
}
