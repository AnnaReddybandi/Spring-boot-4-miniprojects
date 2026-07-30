package com.example.hospitalappointmentbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponse {

    private Integer appointmentId;

    private String patientName;

    private String doctorName;

    private String disease;

    private LocalDate appointmentDate;

}