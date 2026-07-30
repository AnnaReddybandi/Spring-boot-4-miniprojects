package com.example.movieticketbookingapplication.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketRequest {

    @NotBlank(message = "Movie name is required")
    @Size(min = 2, max = 100,
            message = "Movie name must be between 2 and 100 characters")
    private String movieName;

    @NotBlank(message = "Customer name cannot be empty")
    @Size(min = 3, max = 50,
            message = "Customer name must be between 3 and 50 characters")
    private String customerName;

    @NotBlank(message = "Seat number is required")
    private String seatNumber;

    @Positive(message = "Ticket price must be positive")
    private Double ticketPrice;

}