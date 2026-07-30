package com.example.movieticketbookingapplication.service;


import com.example.movieticketbookingapplication.dto.TicketRequest;
import com.example.movieticketbookingapplication.dto.TicketResponse;

import java.util.List;

public interface TicketService {

    // ==========================================================
    // CRUD Operations
    // ==========================================================

    // Book Movie Ticket
    TicketResponse bookTicket(TicketRequest ticketRequest);

    // Get All Tickets
    List<TicketResponse> getAllTickets();

    // Get Ticket By Id
    TicketResponse getTicketById(Integer ticketId);

    // Update Ticket
    TicketResponse updateTicket(Integer ticketId,
                                TicketRequest ticketRequest);

    // Cancel Ticket
    String cancelTicket(Integer ticketId);



    // ==========================================================
    // Custom Query Operations
    // ==========================================================

    // Search By Movie Name
    List<TicketResponse> getTicketsByMovieName(String movieName);

    // Search By Customer Name
    List<TicketResponse> getTicketsByCustomerName(String customerName);

    // Search By Seat Number
    TicketResponse getTicketBySeatNumber(String seatNumber);

    // Search Ticket Price Greater Than
    List<TicketResponse> getTicketsByPriceGreaterThan(Double ticketPrice);

    // Search Ticket Price Between Range
    List<TicketResponse> getTicketsByPriceRange(Double minPrice,
                                                Double maxPrice);



    // ==========================================================
    // Sorting Operations
    // ==========================================================

    // Sort Ticket Price Ascending
    List<TicketResponse> getTicketsOrderByPriceAsc();

    // Sort Ticket Price Descending
    List<TicketResponse> getTicketsOrderByPriceDesc();

    // Sort By Movie Name
    List<TicketResponse> getTicketsOrderByMovieName();



    // ==========================================================
    // Statistics
    // ==========================================================

    // Highest Price Ticket
    TicketResponse getHighestPriceTicket();

    // Lowest Price Ticket
    TicketResponse getLowestPriceTicket();

    // Total Tickets Count
    Long getTicketCount();

}