package com.example.onlinefoodordersystem.service;

import com.example.onlinefoodordersystem.dto.OrderRequest;
import com.example.onlinefoodordersystem.dto.OrderResponse;

import java.util.List;
import java.util.Map;

public interface FoodOrderService {

    // ==========================================================
    // CRUD Operations
    // ==========================================================

    OrderResponse addOrder(OrderRequest request);

    List<OrderResponse> getAllOrders();

    OrderResponse getOrderById(Integer orderId);

    OrderResponse updateOrder(Integer orderId, OrderRequest request);

    String deleteOrder(Integer orderId);

    OrderResponse patchOrder(Integer orderId, Map<String, Object> updates);

    // ==========================================================
    // Customer Queries
    // ==========================================================

    List<OrderResponse> getOrdersByCustomerName(String customerName);

    List<OrderResponse> getOrdersByCustomerNameContains(String customerName);

    List<OrderResponse> getOrdersByCustomerStartsWith(String customerName);

    List<OrderResponse> getOrdersByCustomerEndsWith(String customerName);

    // ==========================================================
    // Food Queries
    // ==========================================================

    List<OrderResponse> getOrdersByFoodItem(String foodItem);

    List<OrderResponse> getOrdersByFoodContains(String foodItem);

    List<OrderResponse> getOrdersByFoodStartsWith(String foodItem);

    List<OrderResponse> getOrdersByFoodEndsWith(String foodItem);

    // ==========================================================
    // Quantity Queries
    // ==========================================================

    List<OrderResponse> getOrdersByQuantity(Integer quantity);

    List<OrderResponse> getOrdersByQuantityGreaterThan(Integer quantity);

    List<OrderResponse> getOrdersByQuantityLessThan(Integer quantity);

    List<OrderResponse> getOrdersByQuantityBetween(Integer min,
                                                   Integer max);

    // ==========================================================
    // Price Queries
    // ==========================================================

    List<OrderResponse> getOrdersByPrice(Double price);

    List<OrderResponse> getOrdersByPriceGreaterThan(Double price);

    List<OrderResponse> getOrdersByPriceLessThan(Double price);

    List<OrderResponse> getOrdersByPriceBetween(Double min,
                                                Double max);

    // ==========================================================
    // Multiple Condition Queries
    // ==========================================================

    List<OrderResponse> getOrdersByCustomerAndFood(String customerName,
                                                   String foodItem);

    List<OrderResponse> getOrdersByCustomerAndPrice(String customerName,
                                                    Double price);

    List<OrderResponse> getOrdersByFoodAndQuantity(String foodItem,
                                                   Integer quantity);

    List<OrderResponse> searchOrders(String customerName,
                                     String foodItem);

    // ==========================================================
    // Sorting Queries
    // ==========================================================

    List<OrderResponse> getOrdersByPriceAsc();

    List<OrderResponse> getOrdersByPriceDesc();

    List<OrderResponse> getOrdersByCustomerAsc();

    List<OrderResponse> getOrdersByFoodAsc();

    // ==========================================================
    // Top Orders
    // ==========================================================

    List<OrderResponse> getTop5ExpensiveOrders();

    List<OrderResponse> getTop10CheapestOrders();

    OrderResponse getLatestOrder();

    // ==========================================================
    // Statistics
    // ==========================================================

    Long getTotalOrders();

    Double getTotalRevenue();

    Double getAveragePrice();

    Double getMaximumPrice();

    Double getMinimumPrice();

}