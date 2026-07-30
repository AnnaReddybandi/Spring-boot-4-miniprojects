package com.example.movieticketbookingapplication.util;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {

    // Indicates whether the request was successful
    private boolean success;

    // Response message
    private String message;

    // Actual response data
    private T data;

}