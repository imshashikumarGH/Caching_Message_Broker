package com.spring.cache_mess_queue.Cache_Message.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order implements Serializable {
    private String uuid;
    private String name;
    private Integer quantity;
}
