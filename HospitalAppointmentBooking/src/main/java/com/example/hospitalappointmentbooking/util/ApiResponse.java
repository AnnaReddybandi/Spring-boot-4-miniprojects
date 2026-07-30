package com.example.hospitalappointmentbooking.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private Integer status;

    private String message;

    private Object data;

    private LocalDateTime timestamp;

}