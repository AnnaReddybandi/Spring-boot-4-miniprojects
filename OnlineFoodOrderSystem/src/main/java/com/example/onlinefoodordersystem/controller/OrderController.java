package com.example.onlinefoodordersystem.controller;

import com.example.onlinefoodordersystem.dto.OrderRequest;
import com.example.onlinefoodordersystem.dto.OrderResponse;
import com.example.onlinefoodordersystem.service.FoodOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private FoodOrderService foodOrderService;

    // ==========================================================
    // POST http://localhost:8080/api/orders
    // ==========================================================
    @PostMapping
    public ResponseEntity<OrderResponse> addOrder(
            @Valid @RequestBody OrderRequest request) {

        return ResponseEntity.ok(foodOrderService.addOrder(request));
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders
    // ==========================================================
    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {

        return ResponseEntity.ok(foodOrderService.getAllOrders());
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders/{id}
    // ==========================================================
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(foodOrderService.getOrderById(id));
    }

    // ==========================================================
    // PUT http://localhost:8080/api/orders/{id}
    // ==========================================================
    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> updateOrder(
            @PathVariable Integer id,
            @Valid @RequestBody OrderRequest request) {

        return ResponseEntity.ok(foodOrderService.updateOrder(id, request));
    }

    // ==========================================================
    // DELETE http://localhost:8080/api/orders/{id}
    // ==========================================================
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(
            @PathVariable Integer id) {

        return ResponseEntity.ok(foodOrderService.deleteOrder(id));
    }

    // ==========================================================
    // PATCH http://localhost:8080/api/orders/{id}
    // ==========================================================
    @PatchMapping("/{id}")
    public ResponseEntity<OrderResponse> patchOrder(
            @PathVariable Integer id,
            @RequestBody Map<String, Object> updates) {

        return ResponseEntity.ok(foodOrderService.patchOrder(id, updates));
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders/customer/{customerName}
    // ==========================================================
    @GetMapping("/customer/{customerName}")
    public ResponseEntity<List<OrderResponse>> getOrdersByCustomer(
            @PathVariable String customerName) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByCustomerName(customerName));
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders/customer/contains/{customerName}
    // ==========================================================
    @GetMapping("/customer/contains/{customerName}")
    public ResponseEntity<List<OrderResponse>> getCustomerContains(
            @PathVariable String customerName) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByCustomerNameContains(customerName));
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders/customer/start/{customerName}
    // ==========================================================
    @GetMapping("/customer/start/{customerName}")
    public ResponseEntity<List<OrderResponse>> getCustomerStartsWith(
            @PathVariable String customerName) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByCustomerStartsWith(customerName));
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders/customer/end/{customerName}
    // ==========================================================
    @GetMapping("/customer/end/{customerName}")
    public ResponseEntity<List<OrderResponse>> getCustomerEndsWith(
            @PathVariable String customerName) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByCustomerEndsWith(customerName));
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders/food/{foodItem}
    // ==========================================================
    @GetMapping("/food/{foodItem}")
    public ResponseEntity<List<OrderResponse>> getFood(
            @PathVariable String foodItem) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByFoodItem(foodItem));
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders/food/contains/{foodItem}
    // ==========================================================
    @GetMapping("/food/contains/{foodItem}")
    public ResponseEntity<List<OrderResponse>> getFoodContains(
            @PathVariable String foodItem) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByFoodContains(foodItem));
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders/food/start/{foodItem}
    // ==========================================================
    @GetMapping("/food/start/{foodItem}")
    public ResponseEntity<List<OrderResponse>> getFoodStartsWith(
            @PathVariable String foodItem) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByFoodStartsWith(foodItem));
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders/food/end/{foodItem}
    // ==========================================================
    @GetMapping("/food/end/{foodItem}")
    public ResponseEntity<List<OrderResponse>> getFoodEndsWith(
            @PathVariable String foodItem) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByFoodEndsWith(foodItem));
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders/quantity/{quantity}
    // ==========================================================
    @GetMapping("/quantity/{quantity}")
    public ResponseEntity<List<OrderResponse>> getQuantity(
            @PathVariable Integer quantity) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByQuantity(quantity));
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders/quantity/greater/{quantity}
    // ==========================================================
    @GetMapping("/quantity/greater/{quantity}")
    public ResponseEntity<List<OrderResponse>> getQuantityGreater(
            @PathVariable Integer quantity) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByQuantityGreaterThan(quantity));
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders/quantity/less/{quantity}
    // ==========================================================
    @GetMapping("/quantity/less/{quantity}")
    public ResponseEntity<List<OrderResponse>> getQuantityLess(
            @PathVariable Integer quantity) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByQuantityLessThan(quantity));
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders/quantity/between?min=1&max=5
    // ==========================================================
    @GetMapping("/quantity/between")
    public ResponseEntity<List<OrderResponse>> getQuantityBetween(
            @RequestParam Integer min,
            @RequestParam Integer max) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByQuantityBetween(min, max));
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders/price/{price}
    // ==========================================================
    @GetMapping("/price/{price}")
    public ResponseEntity<List<OrderResponse>> getPrice(
            @PathVariable Double price) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByPrice(price));
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders/price/greater/{price}
    // ==========================================================
    @GetMapping("/price/greater/{price}")
    public ResponseEntity<List<OrderResponse>> getPriceGreater(
            @PathVariable Double price) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByPriceGreaterThan(price));
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders/price/less/{price}
    // ==========================================================
    @GetMapping("/price/less/{price}")
    public ResponseEntity<List<OrderResponse>> getPriceLess(
            @PathVariable Double price) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByPriceLessThan(price));
    }

    // ==========================================================
    // GET http://localhost:8080/api/orders/price/between?min=100&max=500
    // ==========================================================
    @GetMapping("/price/between")
    public ResponseEntity<List<OrderResponse>> getPriceBetween(
            @RequestParam Double min,
            @RequestParam Double max) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByPriceBetween(min, max));
    }

    // ==========================================================
    // GET Customer + Food
    // ==========================================================
    @GetMapping("/customer-food")
    public ResponseEntity<List<OrderResponse>> getOrdersByCustomerAndFood(
            @RequestParam String customerName,
            @RequestParam String foodItem) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByCustomerAndFood(customerName, foodItem));
    }

    // ==========================================================
    // GET Customer + Price
    // ==========================================================
    @GetMapping("/customer-price")
    public ResponseEntity<List<OrderResponse>> getOrdersByCustomerAndPrice(
            @RequestParam String customerName,
            @RequestParam Double price) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByCustomerAndPrice(customerName, price));
    }

    // ==========================================================
    // GET Food + Quantity
    // ==========================================================
    @GetMapping("/food-quantity")
    public ResponseEntity<List<OrderResponse>> getOrdersByFoodAndQuantity(
            @RequestParam String foodItem,
            @RequestParam Integer quantity) {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByFoodAndQuantity(foodItem, quantity));
    }

    // ==========================================================
    // Search Orders
    // ==========================================================
    @GetMapping("/search")
    public ResponseEntity<List<OrderResponse>> searchOrders(
            @RequestParam String customerName,
            @RequestParam String foodItem) {

        return ResponseEntity.ok(
                foodOrderService.searchOrders(customerName, foodItem));
    }

    // ==========================================================
    // Sort By Price ASC
    // ==========================================================
    @GetMapping("/sort/price/asc")
    public ResponseEntity<List<OrderResponse>> getPriceAsc() {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByPriceAsc());
    }

    // ==========================================================
    // Sort By Price DESC
    // ==========================================================
    @GetMapping("/sort/price/desc")
    public ResponseEntity<List<OrderResponse>> getPriceDesc() {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByPriceDesc());
    }

    // ==========================================================
    // Sort Customer Name
    // ==========================================================
    @GetMapping("/sort/customer")
    public ResponseEntity<List<OrderResponse>> getCustomerAsc() {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByCustomerAsc());
    }

    // ==========================================================
    // Sort Food Item
    // ==========================================================
    @GetMapping("/sort/food")
    public ResponseEntity<List<OrderResponse>> getFoodAsc() {

        return ResponseEntity.ok(
                foodOrderService.getOrdersByFoodAsc());
    }

    // ==========================================================
    // Top 5 Expensive Orders
    // ==========================================================
    @GetMapping("/top5")
    public ResponseEntity<List<OrderResponse>> getTop5Orders() {

        return ResponseEntity.ok(
                foodOrderService.getTop5ExpensiveOrders());
    }

    // ==========================================================
    // Top 10 Cheapest Orders
    // ==========================================================
    @GetMapping("/top10")
    public ResponseEntity<List<OrderResponse>> getTop10Orders() {

        return ResponseEntity.ok(
                foodOrderService.getTop10CheapestOrders());
    }

    // ==========================================================
    // Latest Order
    // ==========================================================
    @GetMapping("/latest")
    public ResponseEntity<OrderResponse> getLatestOrder() {

        return ResponseEntity.ok(
                foodOrderService.getLatestOrder());
    }

    // ==========================================================
    // Total Orders
    // ==========================================================
    @GetMapping("/statistics/total-orders")
    public ResponseEntity<Long> getTotalOrders() {

        return ResponseEntity.ok(
                foodOrderService.getTotalOrders());
    }

    // ==========================================================
    // Total Revenue
    // ==========================================================
    @GetMapping("/statistics/revenue")
    public ResponseEntity<Double> getRevenue() {

        return ResponseEntity.ok(
                foodOrderService.getTotalRevenue());
    }

    // ==========================================================
    // Average Price
    // ==========================================================
    @GetMapping("/statistics/average-price")
    public ResponseEntity<Double> getAveragePrice() {

        return ResponseEntity.ok(
                foodOrderService.getAveragePrice());
    }

    // ==========================================================
    // Maximum Price
    // ==========================================================
    @GetMapping("/statistics/max-price")
    public ResponseEntity<Double> getMaxPrice() {

        return ResponseEntity.ok(
                foodOrderService.getMaximumPrice());
    }

    // ==========================================================
    // Minimum Price
    // ==========================================================
    @GetMapping("/statistics/min-price")
    public ResponseEntity<Double> getMinPrice() {

        return ResponseEntity.ok(
                foodOrderService.getMinimumPrice());
    }

}


