package com.example.onlinefoodordersystem.service;

import com.example.onlinefoodordersystem.dto.OrderRequest;
import com.example.onlinefoodordersystem.dto.OrderResponse;
import com.example.onlinefoodordersystem.exception.DuplicateOrderException;
import com.example.onlinefoodordersystem.exception.OrderNotFoundException;
import com.example.onlinefoodordersystem.model.FoodOrder;
import com.example.onlinefoodordersystem.repository.FoodOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FoodOrderServiceImpl implements FoodOrderService {

    @Autowired
    private FoodOrderRepository foodOrderRepository;

    // ==========================================================
    // Convert Entity to Response DTO
    // ==========================================================
    private OrderResponse mapToResponse(FoodOrder order) {

        return new OrderResponse(
                order.getOrderId(),
                order.getCustomerName(),
                order.getFoodItem(),
                order.getQuantity(),
                order.getPrice()
        );
    }

    // ==========================================================
    // Convert Request DTO to Entity
    // ==========================================================
    private FoodOrder mapToEntity(OrderRequest request) {

        FoodOrder order = new FoodOrder();

        order.setCustomerName(request.getCustomerName());
        order.setFoodItem(request.getFoodItem());
        order.setQuantity(request.getQuantity());
        order.setPrice(request.getPrice());

        return order;
    }

    // ==========================================================
    // Add Order
    // ==========================================================
    @Override
    public OrderResponse addOrder(OrderRequest request) {

        foodOrderRepository
                .findByCustomerNameAndFoodItem(
                        request.getCustomerName(),
                        request.getFoodItem())
                .ifPresent(order -> {
                    throw new DuplicateOrderException(
                            "Order already exists for customer "
                                    + request.getCustomerName()
                                    + " with food item "
                                    + request.getFoodItem()
                    );
                });

        FoodOrder order = mapToEntity(request);

        FoodOrder savedOrder = foodOrderRepository.save(order);

        return mapToResponse(savedOrder);
    }

    // ==========================================================
    // Get All Orders
    // ==========================================================
    @Override
    public List<OrderResponse> getAllOrders() {

        return foodOrderRepository
                .findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Order By ID
    // ==========================================================
    @Override
    public OrderResponse getOrderById(Integer orderId) {

        FoodOrder order = foodOrderRepository
                .findById(orderId)
                .orElseThrow(() ->
                        new OrderNotFoundException(
                                "Order with ID "
                                        + orderId
                                        + " not found."));

        return mapToResponse(order);
    }

    // ==========================================================
    // Update Order
    // ==========================================================
    @Override
    public OrderResponse updateOrder(Integer orderId, OrderRequest request) {

        FoodOrder existingOrder = foodOrderRepository
                .findById(orderId)
                .orElseThrow(() ->
                        new OrderNotFoundException(
                                "Order with ID " + orderId + " not found."));

        existingOrder.setCustomerName(request.getCustomerName());
        existingOrder.setFoodItem(request.getFoodItem());
        existingOrder.setQuantity(request.getQuantity());
        existingOrder.setPrice(request.getPrice());

        FoodOrder updatedOrder = foodOrderRepository.save(existingOrder);

        return mapToResponse(updatedOrder);
    }

    // ==========================================================
    // Delete Order
    // ==========================================================
    @Override
    public String deleteOrder(Integer orderId) {

        FoodOrder existingOrder = foodOrderRepository
                .findById(orderId)
                .orElseThrow(() ->
                        new OrderNotFoundException(
                                "Order with ID " + orderId + " not found."));

        foodOrderRepository.delete(existingOrder);

        return "Order deleted successfully.";
    }

    // ==========================================================
    // Partial Update Order (PATCH)
    // ==========================================================
    @Override
    public OrderResponse patchOrder(Integer orderId,
                                    Map<String, Object> updates) {

        FoodOrder existingOrder = foodOrderRepository
                .findById(orderId)
                .orElseThrow(() ->
                        new OrderNotFoundException(
                                "Order with ID " + orderId + " not found."));

        if (updates.containsKey("customerName")) {
            existingOrder.setCustomerName(
                    updates.get("customerName").toString());
        }

        if (updates.containsKey("foodItem")) {
            existingOrder.setFoodItem(
                    updates.get("foodItem").toString());
        }

        if (updates.containsKey("quantity")) {
            existingOrder.setQuantity(
                    Integer.valueOf(updates.get("quantity").toString()));
        }

        if (updates.containsKey("price")) {
            existingOrder.setPrice(
                    Double.valueOf(updates.get("price").toString()));
        }

        FoodOrder updatedOrder = foodOrderRepository.save(existingOrder);

        return mapToResponse(updatedOrder);
    }



    // ==========================================================
    // Get Orders By Customer Name
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByCustomerName(String customerName) {

        return foodOrderRepository
                .findByCustomerNameIgnoreCase(customerName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Orders By Customer Name Contains
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByCustomerNameContains(String customerName) {

        return foodOrderRepository
                .findByCustomerNameContainingIgnoreCase(customerName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Orders By Customer Starts With
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByCustomerStartsWith(String customerName) {

        return foodOrderRepository
                .findByCustomerNameStartingWithIgnoreCase(customerName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Orders By Customer Ends With
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByCustomerEndsWith(String customerName) {

        return foodOrderRepository
                .findByCustomerNameEndingWithIgnoreCase(customerName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Orders By Food Item
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByFoodItem(String foodItem) {

        return foodOrderRepository
                .findByFoodItemIgnoreCase(foodItem)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Orders By Food Item Contains
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByFoodContains(String foodItem) {

        return foodOrderRepository
                .findByFoodItemContainingIgnoreCase(foodItem)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Orders By Food Item Starts With
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByFoodStartsWith(String foodItem) {

        return foodOrderRepository
                .findByFoodItemStartingWithIgnoreCase(foodItem)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Orders By Food Item Ends With
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByFoodEndsWith(String foodItem) {

        return foodOrderRepository
                .findByFoodItemEndingWithIgnoreCase(foodItem)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Orders By Quantity
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByQuantity(Integer quantity) {

        return foodOrderRepository
                .findByQuantity(quantity)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Orders By Quantity Greater Than
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByQuantityGreaterThan(Integer quantity) {

        return foodOrderRepository
                .findByQuantityGreaterThan(quantity)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Orders By Quantity Less Than
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByQuantityLessThan(Integer quantity) {

        return foodOrderRepository
                .findByQuantityLessThan(quantity)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Orders By Quantity Between
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByQuantityBetween(Integer min,
                                                          Integer max) {

        return foodOrderRepository
                .findByQuantityBetween(min, max)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }


    // ==========================================================
    // Get Orders By Price
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByPrice(Double price) {

        return foodOrderRepository
                .findByPrice(price)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Orders By Price Greater Than
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByPriceGreaterThan(Double price) {

        return foodOrderRepository
                .findByPriceGreaterThan(price)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Orders By Price Less Than
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByPriceLessThan(Double price) {

        return foodOrderRepository
                .findByPriceLessThan(price)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Orders By Price Between
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByPriceBetween(Double min,
                                                       Double max) {

        return foodOrderRepository
                .findByPriceBetween(min, max)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }



    // ==========================================================
    // Get Orders By Customer Name And Food Item
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByCustomerAndFood(String customerName,
                                                          String foodItem) {

        return foodOrderRepository
                .findByCustomerNameAndFoodItem(customerName, foodItem)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Orders By Customer Name And Price
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByCustomerAndPrice(String customerName,
                                                           Double price) {

        return foodOrderRepository
                .findByCustomerNameAndPriceGreaterThan(customerName, price)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Orders By Food Item And Quantity
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByFoodAndQuantity(String foodItem,
                                                          Integer quantity) {

        return foodOrderRepository
                .findByFoodItemAndQuantityGreaterThan(foodItem, quantity)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Search Orders
    // ==========================================================
    @Override
    public List<OrderResponse> searchOrders(String customerName,
                                            String foodItem) {

        return foodOrderRepository
                .findByCustomerNameContainingIgnoreCaseAndFoodItemContainingIgnoreCase(
                        customerName,
                        foodItem)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Sort By Price Ascending
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByPriceAsc() {

        return foodOrderRepository
                .findAllByOrderByPriceAsc()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Sort By Price Descending
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByPriceDesc() {

        return foodOrderRepository
                .findAllByOrderByPriceDesc()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Sort By Customer Name
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByCustomerAsc() {

        return foodOrderRepository
                .findAllByOrderByCustomerNameAsc()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Sort By Food Item
    // ==========================================================
    @Override
    public List<OrderResponse> getOrdersByFoodAsc() {

        return foodOrderRepository
                .findAllByOrderByFoodItemAsc()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }


    // ==========================================================
    // Top 5 Expensive Orders
    // ==========================================================
    @Override
    public List<OrderResponse> getTop5ExpensiveOrders() {

        return foodOrderRepository
                .findTop5ByOrderByPriceDesc()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Top 10 Cheapest Orders
    // ==========================================================
    @Override
    public List<OrderResponse> getTop10CheapestOrders() {

        return foodOrderRepository
                .findTop10ByOrderByPriceAsc()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Latest Order
    // ==========================================================
    @Override
    public OrderResponse getLatestOrder() {

        FoodOrder order = foodOrderRepository.findTopByOrderByOrderIdDesc();

        if (order == null) {
            throw new OrderNotFoundException("No orders available.");
        }

        return mapToResponse(order);
    }

    // ==========================================================
    // Total Orders
    // ==========================================================
    @Override
    public Long getTotalOrders() {

        return foodOrderRepository.getTotalOrders();
    }

    // ==========================================================
    // Total Revenue
    // ==========================================================
    @Override
    public Double getTotalRevenue() {

        return foodOrderRepository.getTotalRevenue();
    }

    // ==========================================================
    // Average Price
    // ==========================================================
    @Override
    public Double getAveragePrice() {

        return foodOrderRepository.getAveragePrice();
    }

    // ==========================================================
    // Maximum Price
    // ==========================================================
    @Override
    public Double getMaximumPrice() {

        return foodOrderRepository.getMaximumPrice();
    }

    // ==========================================================
    // Minimum Price
    // ==========================================================
    @Override
    public Double getMinimumPrice() {

        return foodOrderRepository.getMinimumPrice();
    }



}







