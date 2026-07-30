package com.example.hospitalappointmentbooking.repository;

import com.example.hospitalappointmentbooking.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    // Find appointments by patient name
    List<Appointment> findByPatientNameContainingIgnoreCase(String patientName);

    // Find appointments by doctor name
    List<Appointment> findByDoctorNameContainingIgnoreCase(String doctorName);

    // Find appointments by disease
    List<Appointment> findByDiseaseContainingIgnoreCase(String disease);

    // Find appointments by appointment date
    List<Appointment> findByAppointmentDate(LocalDate appointmentDate);

    // Find upcoming appointments
    List<Appointment> findByAppointmentDateGreaterThanEqual(LocalDate appointmentDate);

    // Find appointments between two dates
    List<Appointment> findByAppointmentDateBetween(LocalDate startDate,
                                                   LocalDate endDate);

    // Check duplicate appointment
    Optional<Appointment> findByPatientNameAndDoctorNameAndAppointmentDate(
            String patientName,
            String doctorName,
            LocalDate appointmentDate
    );

}