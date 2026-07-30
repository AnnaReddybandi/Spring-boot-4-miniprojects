package com.example.movieticketbookingapplication.repository;


import com.example.movieticketbookingapplication.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    // ==========================================================
    // Derived Query Methods
    // ==========================================================

    // Find By Movie Name
    List<Ticket> findByMovieNameIgnoreCase(String movieName);

    // Find By Customer Name
    List<Ticket> findByCustomerNameContainingIgnoreCase(String customerName);

    // Find By Seat Number
    Ticket findBySeatNumberIgnoreCase(String seatNumber);

    // Find Tickets By Price Greater Than
    List<Ticket> findByTicketPriceGreaterThan(Double ticketPrice);

    // Find Tickets Between Price Range
    List<Ticket> findByTicketPriceBetween(Double minPrice,
                                          Double maxPrice);

    // Sort By Price Ascending
    List<Ticket> findAllByOrderByTicketPriceAsc();

    // Sort By Price Descending
    List<Ticket> findAllByOrderByTicketPriceDesc();

    // Sort By Movie Name
    List<Ticket> findAllByOrderByMovieNameAsc();


    // ==========================================================
    // Custom JPQL Queries
    // ==========================================================

    @Query("""
            SELECT t
            FROM Ticket t
            WHERE LOWER(t.movieName)=LOWER(?1)
            """)
    List<Ticket> searchMovie(String movieName);


    @Query("""
            SELECT t
            FROM Ticket t
            WHERE LOWER(t.customerName)
            LIKE LOWER(CONCAT('%',?1,'%'))
            """)
    List<Ticket> searchCustomer(String customerName);


    @Query("""
            SELECT t
            FROM Ticket t
            WHERE t.ticketPrice>=?1
            """)
    List<Ticket> getTicketsAbovePrice(Double ticketPrice);


    @Query("""
            SELECT t
            FROM Ticket t
            WHERE t.ticketPrice BETWEEN ?1 AND ?2
            """)
    List<Ticket> getTicketsBetweenPrice(Double minPrice,
                                        Double maxPrice);


    @Query("""
            SELECT t
            FROM Ticket t
            ORDER BY t.ticketPrice DESC
            LIMIT 1
            """)
    Ticket getHighestPriceTicket();


    @Query("""
            SELECT t
            FROM Ticket t
            ORDER BY t.ticketPrice ASC
            LIMIT 1
            """)
    Ticket getLowestPriceTicket();

    Ticket findFirstByOrderByTicketPriceAsc();

    Ticket findFirstByOrderByTicketPriceDesc();
}