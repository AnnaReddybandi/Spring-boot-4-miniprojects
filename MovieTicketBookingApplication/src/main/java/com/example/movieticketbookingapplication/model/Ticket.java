package com.example.movieticketbookingapplication.model;


import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "movie_tickets")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;

    @NotBlank(message = "Movie name is required")
    @Size(min = 2, max = 100, message = "Movie name must be between 2 and 100 characters")
    @Column(name = "movie_name", nullable = false, length = 100)
    private String movieName;

    @NotBlank(message = "Customer name cannot be empty")
    @Size(min = 3, max = 50, message = "Customer name must be between 3 and 50 characters")
    @Column(name = "customer_name", nullable = false, length = 50)
    private String customerName;

    @NotBlank(message = "Seat number is required")
    @Column(name = "seat_number", nullable = false, unique = true, length = 10)
    private String seatNumber;

    @Positive(message = "Ticket price must be positive")
    @Column(name = "ticket_price", nullable = false)
    private Double ticketPrice;

}