package com.example.movieticketbookingapplication.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketResponse {

    private Integer ticketId;

    private String movieName;

    private String customerName;

    private String seatNumber;

    private Double ticketPrice;

}