package com.example.hospitalappointmentbooking.service;

import com.example.hospitalappointmentbooking.dto.AppointmentRequest;
import com.example.hospitalappointmentbooking.dto.AppointmentResponse;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

    // ==========================================
    // CRUD Operations
    // ==========================================

    // Book Appointment
    AppointmentResponse saveAppointment(AppointmentRequest appointmentRequest);

    // Get All Appointments
    List<AppointmentResponse> getAllAppointments();

    // Get Appointment By Id
    AppointmentResponse getAppointmentById(Integer appointmentId);

    // Update Appointment
    AppointmentResponse updateAppointment(Integer appointmentId,
                                          AppointmentRequest appointmentRequest);

    // Delete Appointment
    String deleteAppointment(Integer appointmentId);

    // ==========================================
    // Custom Query Methods
    // ==========================================

    // Search By Patient Name
    List<AppointmentResponse> getAppointmentsByPatientName(String patientName);

    // Search By Doctor Name
    List<AppointmentResponse> getAppointmentsByDoctorName(String doctorName);

    // Search By Disease
    List<AppointmentResponse> getAppointmentsByDisease(String disease);

    // Search By Appointment Date
    List<AppointmentResponse> getAppointmentsByDate(LocalDate appointmentDate);

    // Get Upcoming Appointments
    List<AppointmentResponse> getUpcomingAppointments();

    // Get Appointments Between Two Dates
    List<AppointmentResponse> getAppointmentsBetweenDates(LocalDate startDate,
                                                          LocalDate endDate);

    // Get Total Appointment Count
    Long getTotalAppointments();

}