package com.example.onlinefoodordersystem.repository;

import com.example.onlinefoodordersystem.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {

    // ==========================================================
    // Duplicate Order Check
    // ==========================================================
    Optional<FoodOrder> findByCustomerNameAndFoodItem(
            String customerName,
            String foodItem);

    // ==========================================================
    // Customer Queries
    // ==========================================================
    List<FoodOrder> findByCustomerName(String customerName);

    List<FoodOrder> findByCustomerNameIgnoreCase(String customerName);

    List<FoodOrder> findByCustomerNameContainingIgnoreCase(String customerName);

    List<FoodOrder> findByCustomerNameStartingWithIgnoreCase(String customerName);

    List<FoodOrder> findByCustomerNameEndingWithIgnoreCase(String customerName);

    // ==========================================================
    // Food Queries
    // ==========================================================
    List<FoodOrder> findByFoodItem(String foodItem);

    List<FoodOrder> findByFoodItemIgnoreCase(String foodItem);

    List<FoodOrder> findByFoodItemContainingIgnoreCase(String foodItem);

    List<FoodOrder> findByFoodItemStartingWithIgnoreCase(String foodItem);

    List<FoodOrder> findByFoodItemEndingWithIgnoreCase(String foodItem);

    // ==========================================================
    // Quantity Queries
    // ==========================================================
    List<FoodOrder> findByQuantity(Integer quantity);

    List<FoodOrder> findByQuantityGreaterThan(Integer quantity);

    List<FoodOrder> findByQuantityGreaterThanEqual(Integer quantity);

    List<FoodOrder> findByQuantityLessThan(Integer quantity);

    List<FoodOrder> findByQuantityBetween(Integer min, Integer max);

    // ==========================================================
    // Price Queries
    // ==========================================================
    List<FoodOrder> findByPrice(Double price);

    List<FoodOrder> findByPriceGreaterThan(Double price);

    List<FoodOrder> findByPriceGreaterThanEqual(Double price);

    List<FoodOrder> findByPriceLessThan(Double price);

    List<FoodOrder> findByPriceBetween(Double min, Double max);

    // ==========================================================
    // Multiple Condition Queries
    // ==========================================================

    // Renamed to avoid duplicate method
    List<FoodOrder> findAllByCustomerNameAndFoodItem(
            String customerName,
            String foodItem);

    List<FoodOrder> findByCustomerNameAndPriceGreaterThan(
            String customerName,
            Double price);

    List<FoodOrder> findByFoodItemAndQuantityGreaterThan(
            String foodItem,
            Integer quantity);

    List<FoodOrder> findByCustomerNameContainingIgnoreCaseAndFoodItemContainingIgnoreCase(
            String customerName,
            String foodItem);

    // ==========================================================
    // Sorting Queries
    // ==========================================================
    List<FoodOrder> findAllByOrderByPriceAsc();

    List<FoodOrder> findAllByOrderByPriceDesc();

    List<FoodOrder> findAllByOrderByCustomerNameAsc();

    List<FoodOrder> findAllByOrderByFoodItemAsc();

    // ==========================================================
    // Top Records
    // ==========================================================
    List<FoodOrder> findTop5ByOrderByPriceDesc();

    List<FoodOrder> findTop10ByOrderByPriceAsc();

    FoodOrder findTopByOrderByOrderIdDesc();

    // ==========================================================
    // JPQL Queries
    // ==========================================================

    @Query("SELECT f FROM FoodOrder f WHERE f.price > ?1")
    List<FoodOrder> getOrdersCostingMoreThan(Double price);

    @Query("SELECT f FROM FoodOrder f WHERE f.quantity >= ?1")
    List<FoodOrder> getOrdersWithMinimumQuantity(Integer quantity);

    @Query("SELECT COUNT(f) FROM FoodOrder f")
    Long getTotalOrders();

    @Query("SELECT SUM(f.price) FROM FoodOrder f")
    Double getTotalRevenue();

    @Query("SELECT AVG(f.price) FROM FoodOrder f")
    Double getAveragePrice();

    @Query("SELECT MAX(f.price) FROM FoodOrder f")
    Double getMaximumPrice();

    @Query("SELECT MIN(f.price) FROM FoodOrder f")
    Double getMinimumPrice();
}