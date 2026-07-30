package com.example.onlinefoodordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Integer orderId;

    private String customerName;

    private String foodItem;

    private Integer quantity;

    private Double price;

}