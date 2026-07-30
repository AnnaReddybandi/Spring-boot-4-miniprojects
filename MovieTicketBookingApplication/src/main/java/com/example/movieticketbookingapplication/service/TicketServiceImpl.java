package com.example.movieticketbookingapplication.service;


import com.example.movieticketbookingapplication.dto.TicketRequest;
import com.example.movieticketbookingapplication.dto.TicketResponse;
import com.example.movieticketbookingapplication.exception.DuplicateSeatException;
import com.example.movieticketbookingapplication.exception.TicketNotFoundException;
import com.example.movieticketbookingapplication.model.Ticket;
import com.example.movieticketbookingapplication.repository.TicketRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    // ==========================================================
    // Constructor Injection
    // ==========================================================

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // ==========================================================
    // Entity -> Response DTO
    // ==========================================================

    private TicketResponse mapToResponse(Ticket ticket) {

        return TicketResponse.builder()
                .ticketId(ticket.getTicketId())
                .movieName(ticket.getMovieName())
                .customerName(ticket.getCustomerName())
                .seatNumber(ticket.getSeatNumber())
                .ticketPrice(ticket.getTicketPrice())
                .build();
    }

    // ==========================================================
    // Request DTO -> Entity
    // ==========================================================

    private Ticket mapToEntity(TicketRequest request) {

        return Ticket.builder()
                .movieName(request.getMovieName())
                .customerName(request.getCustomerName())
                .seatNumber(request.getSeatNumber())
                .ticketPrice(request.getTicketPrice())
                .build();
    }

    // ==========================================================
    // Book Ticket
    // ==========================================================

    @Override
    public TicketResponse bookTicket(TicketRequest request) {

        Ticket seat = ticketRepository.findBySeatNumberIgnoreCase(
                request.getSeatNumber());

        if (seat != null) {
            throw new DuplicateSeatException(
                    "Seat " + request.getSeatNumber() + " is already booked.");
        }

        Ticket savedTicket = ticketRepository.save(mapToEntity(request));

        return mapToResponse(savedTicket);
    }

    // ==========================================================
    // Get All Tickets
    // ==========================================================

    @Override
    public List<TicketResponse> getAllTickets() {

        return ticketRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ==========================================================
    // Get Ticket By Id
    // ==========================================================

    @Override
    public TicketResponse getTicketById(Integer ticketId) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() ->
                        new TicketNotFoundException(
                                "Ticket with ID " + ticketId + " not found."));

        return mapToResponse(ticket);
    }

    // ==========================================================
    // Update Ticket
    // ==========================================================

    @Override
    public TicketResponse updateTicket(Integer ticketId,
                                       TicketRequest request) {

        Ticket existingTicket = ticketRepository.findById(ticketId)
                .orElseThrow(() ->
                        new TicketNotFoundException(
                                "Ticket with ID " + ticketId + " not found."));

        Ticket seat = ticketRepository.findBySeatNumberIgnoreCase(
                request.getSeatNumber());

        if (seat != null && !seat.getTicketId().equals(ticketId)) {
            throw new DuplicateSeatException(
                    "Seat " + request.getSeatNumber() + " is already booked.");
        }

        existingTicket.setMovieName(request.getMovieName());
        existingTicket.setCustomerName(request.getCustomerName());
        existingTicket.setSeatNumber(request.getSeatNumber());
        existingTicket.setTicketPrice(request.getTicketPrice());

        Ticket updatedTicket = ticketRepository.save(existingTicket);

        return mapToResponse(updatedTicket);
    }

    // ==========================================================
    // Cancel Ticket
    // ==========================================================

    @Override
    public String cancelTicket(Integer ticketId) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() ->
                        new TicketNotFoundException(
                                "Ticket with ID " + ticketId + " not found."));

        ticketRepository.delete(ticket);

        return "Ticket cancelled successfully.";
    }

    // ==========================================================
    // Get Tickets By Movie Name
    // ==========================================================

    @Override
    public List<TicketResponse> getTicketsByMovieName(String movieName) {

        return ticketRepository.findByMovieNameIgnoreCase(movieName)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ==========================================================
    // Get Tickets By Customer Name
    // ==========================================================

    @Override
    public List<TicketResponse> getTicketsByCustomerName(String customerName) {

        return ticketRepository
                .findByCustomerNameContainingIgnoreCase(customerName)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ==========================================================
    // Get Ticket By Seat Number
    // ==========================================================

    @Override
    public TicketResponse getTicketBySeatNumber(String seatNumber) {

        Ticket ticket =
                ticketRepository.findBySeatNumberIgnoreCase(seatNumber);

        if (ticket == null) {
            throw new TicketNotFoundException(
                    "Ticket with Seat Number " + seatNumber + " not found.");
        }

        return mapToResponse(ticket);
    }

    // ==========================================================
    // Get Tickets By Price Greater Than
    // ==========================================================

    @Override
    public List<TicketResponse> getTicketsByPriceGreaterThan(Double ticketPrice) {

        return ticketRepository.findByTicketPriceGreaterThan(ticketPrice)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ==========================================================
    // Get Tickets By Price Range
    // ==========================================================

    @Override
    public List<TicketResponse> getTicketsByPriceRange(Double minPrice,
                                                       Double maxPrice) {

        return ticketRepository.findByTicketPriceBetween(minPrice, maxPrice)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ==========================================================
    // Sort Tickets By Price Ascending
    // ==========================================================

    @Override
    public List<TicketResponse> getTicketsOrderByPriceAsc() {

        return ticketRepository.findAllByOrderByTicketPriceAsc()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ==========================================================
    // Sort Tickets By Price Descending
    // ==========================================================

    @Override
    public List<TicketResponse> getTicketsOrderByPriceDesc() {

        return ticketRepository.findAllByOrderByTicketPriceDesc()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ==========================================================
    // Sort Tickets By Movie Name
    // ==========================================================

    @Override
    public List<TicketResponse> getTicketsOrderByMovieName() {

        return ticketRepository.findAllByOrderByMovieNameAsc()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ==========================================================
    // Highest Price Ticket
    // ==========================================================

    @Override
    public TicketResponse getHighestPriceTicket() {

        Ticket ticket =
                ticketRepository.findFirstByOrderByTicketPriceDesc();

        if (ticket == null) {
            throw new TicketNotFoundException("No tickets available.");
        }

        return mapToResponse(ticket);
    }

    // ==========================================================
    // Lowest Price Ticket
    // ==========================================================

    @Override
    public TicketResponse getLowestPriceTicket() {

        Ticket ticket =
                ticketRepository.findFirstByOrderByTicketPriceAsc();

        if (ticket == null) {
            throw new TicketNotFoundException("No tickets available.");
        }

        return mapToResponse(ticket);
    }

    // ==========================================================
    // Total Ticket Count
    // ==========================================================

    @Override
    public Long getTicketCount() {

        return ticketRepository.count();
    }

}