package com.example.movieticketbookingapplication.controller;

import com.example.movieticketbookingapplication.dto.TicketRequest;
import com.example.movieticketbookingapplication.dto.TicketResponse;
import com.example.movieticketbookingapplication.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    // Constructor Injection
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // ==========================================================
    // BOOK MOVIE TICKET
    // POST : http://localhost:8080/api/tickets
    // ==========================================================
    @PostMapping
    public ResponseEntity<TicketResponse> bookTicket(
            @Valid @RequestBody TicketRequest ticketRequest) {

        TicketResponse response =
                ticketService.bookTicket(ticketRequest);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // ==========================================================
    // GET ALL TICKETS
    // GET : http://localhost:8080/api/tickets
    // ==========================================================
    @GetMapping
    public ResponseEntity<List<TicketResponse>> getAllTickets() {

        return ResponseEntity.ok(
                ticketService.getAllTickets());
    }

    // ==========================================================
    // GET TICKET BY ID
    // GET : http://localhost:8080/api/tickets/{ticketId}
    // Example:
    // http://localhost:8080/api/tickets/1
    // ==========================================================
    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketResponse> getTicketById(
            @PathVariable Integer ticketId) {

        return ResponseEntity.ok(
                ticketService.getTicketById(ticketId));
    }

    // ==========================================================
    // UPDATE TICKET
    // PUT : http://localhost:8080/api/tickets/{ticketId}
    // Example:
    // http://localhost:8080/api/tickets/1
    // ==========================================================
    @PutMapping("/{ticketId}")
    public ResponseEntity<TicketResponse> updateTicket(
            @PathVariable Integer ticketId,
            @Valid @RequestBody TicketRequest ticketRequest) {

        return ResponseEntity.ok(
                ticketService.updateTicket(ticketId, ticketRequest));
    }

    // ==========================================================
    // DELETE TICKET
    // DELETE : http://localhost:8080/api/tickets/{ticketId}
    // Example:
    // http://localhost:8080/api/tickets/1
    // ==========================================================
    @DeleteMapping("/{ticketId}")
    public ResponseEntity<String> cancelTicket(
            @PathVariable Integer ticketId) {

        return ResponseEntity.ok(
                ticketService.cancelTicket(ticketId));
    }

    // ==========================================================
    // SEARCH BY MOVIE NAME
    // GET : http://localhost:8080/api/tickets/movie/{movieName}
    // Example:
    // http://localhost:8080/api/tickets/movie/Pushpa 2
    // ==========================================================
    @GetMapping("/movie/{movieName}")
    public ResponseEntity<List<TicketResponse>> getTicketsByMovieName(
            @PathVariable String movieName) {

        return ResponseEntity.ok(
                ticketService.getTicketsByMovieName(movieName));
    }

    // ==========================================================
    // SEARCH BY CUSTOMER NAME
    // GET : http://localhost:8080/api/tickets/customer/{customerName}
    // Example:
    // http://localhost:8080/api/tickets/customer/Anna
    // ==========================================================
    @GetMapping("/customer/{customerName}")
    public ResponseEntity<List<TicketResponse>> getTicketsByCustomerName(
            @PathVariable String customerName) {

        return ResponseEntity.ok(
                ticketService.getTicketsByCustomerName(customerName));
    }

    // ==========================================================
    // SEARCH BY SEAT NUMBER
    // GET : http://localhost:8080/api/tickets/seat/{seatNumber}
    // Example:
    // http://localhost:8080/api/tickets/seat/A10
    // ==========================================================
    @GetMapping("/seat/{seatNumber}")
    public ResponseEntity<TicketResponse> getTicketBySeatNumber(
            @PathVariable String seatNumber) {

        return ResponseEntity.ok(
                ticketService.getTicketBySeatNumber(seatNumber));
    }

    // ==========================================================
    // SEARCH BY PRICE GREATER THAN
    // GET : http://localhost:8080/api/tickets/price/{price}
    // Example:
    // http://localhost:8080/api/tickets/price/300
    // ==========================================================
    @GetMapping("/price/{price}")
    public ResponseEntity<List<TicketResponse>> getTicketsByPriceGreaterThan(
            @PathVariable Double price) {

        return ResponseEntity.ok(
                ticketService.getTicketsByPriceGreaterThan(price));
    }

    // ==========================================================
    // SEARCH BY PRICE RANGE
    // GET : http://localhost:8080/api/tickets/price-range/{min}/{max}
    // Example:
    // http://localhost:8080/api/tickets/price-range/200/500
    // ==========================================================
    @GetMapping("/price-range/{min}/{max}")
    public ResponseEntity<List<TicketResponse>> getTicketsByPriceRange(
            @PathVariable Double min,
            @PathVariable Double max) {

        return ResponseEntity.ok(
                ticketService.getTicketsByPriceRange(min, max));
    }

    // ==========================================================
    // SORT BY PRICE ASCENDING
    // GET : http://localhost:8080/api/tickets/sort/price/asc
    // ==========================================================
    @GetMapping("/sort/price/asc")
    public ResponseEntity<List<TicketResponse>> getTicketsOrderByPriceAsc() {

        return ResponseEntity.ok(
                ticketService.getTicketsOrderByPriceAsc());
    }

    // ==========================================================
    // SORT BY PRICE DESCENDING
    // GET : http://localhost:8080/api/tickets/sort/price/desc
    // ==========================================================
    @GetMapping("/sort/price/desc")
    public ResponseEntity<List<TicketResponse>> getTicketsOrderByPriceDesc() {

        return ResponseEntity.ok(
                ticketService.getTicketsOrderByPriceDesc());
    }

    // ==========================================================
    // SORT BY MOVIE NAME
    // GET : http://localhost:8080/api/tickets/sort/movie
    // ==========================================================
    @GetMapping("/sort/movie")
    public ResponseEntity<List<TicketResponse>> getTicketsOrderByMovieName() {

        return ResponseEntity.ok(
                ticketService.getTicketsOrderByMovieName());
    }

    // ==========================================================
    // GET HIGHEST PRICE TICKET
    // GET : http://localhost:8080/api/tickets/highest-price
    // ==========================================================
    @GetMapping("/highest-price")
    public ResponseEntity<TicketResponse> getHighestPriceTicket() {

        return ResponseEntity.ok(
                ticketService.getHighestPriceTicket());
    }

    // ==========================================================
    // GET LOWEST PRICE TICKET
    // GET : http://localhost:8080/api/tickets/lowest-price
    // ==========================================================
    @GetMapping("/lowest-price")
    public ResponseEntity<TicketResponse> getLowestPriceTicket() {

        return ResponseEntity.ok(
                ticketService.getLowestPriceTicket());
    }

    // ==========================================================
    // GET TOTAL TICKETS COUNT
    // GET : http://localhost:8080/api/tickets/count
    // ==========================================================
    @GetMapping("/count")
    public ResponseEntity<Long> getTicketCount() {

        return ResponseEntity.ok(
                ticketService.getTicketCount());
    }

}