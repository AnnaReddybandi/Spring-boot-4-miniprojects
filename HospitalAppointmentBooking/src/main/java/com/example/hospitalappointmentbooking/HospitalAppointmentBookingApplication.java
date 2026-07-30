package com.example.hospitalappointmentbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalAppointmentBookingApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                HospitalAppointmentBookingApplication.class,
                args
        );

        System.out.println();
        System.out.println("==============================================");
        System.out.println(" Hospital Appointment Booking System Started ");
        System.out.println("==============================================");
        System.out.println("Application Running On : http://localhost:8080");
        System.out.println();

    }

}