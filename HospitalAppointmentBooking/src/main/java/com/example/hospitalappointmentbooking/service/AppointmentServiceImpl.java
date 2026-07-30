package com.example.hospitalappointmentbooking.service;

import com.example.hospitalappointmentbooking.dto.AppointmentRequest;
import com.example.hospitalappointmentbooking.dto.AppointmentResponse;
import com.example.hospitalappointmentbooking.exception.AppointmentNotFoundException;
import com.example.hospitalappointmentbooking.exception.DuplicateAppointmentException;
import com.example.hospitalappointmentbooking.model.Appointment;
import com.example.hospitalappointmentbooking.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // ==========================================
    // Book Appointment
    // ==========================================
    @Override
    public AppointmentResponse saveAppointment(AppointmentRequest request) {

        appointmentRepository
                .findByPatientNameAndDoctorNameAndAppointmentDate(
                        request.getPatientName(),
                        request.getDoctorName(),
                        request.getAppointmentDate())
                .ifPresent(a -> {
                    throw new DuplicateAppointmentException(
                            "Appointment already exists for patient "
                                    + request.getPatientName()
                                    + " with Dr. "
                                    + request.getDoctorName()
                                    + " on "
                                    + request.getAppointmentDate());
                });

        Appointment appointment = new Appointment();

        appointment.setPatientName(request.getPatientName());
        appointment.setDoctorName(request.getDoctorName());
        appointment.setDisease(request.getDisease());
        appointment.setAppointmentDate(request.getAppointmentDate());

        Appointment savedAppointment =
                appointmentRepository.save(appointment);

        return mapToResponse(savedAppointment);
    }

    // ==========================================
    // Get All Appointments
    // ==========================================
    @Override
    public List<AppointmentResponse> getAllAppointments() {

        return appointmentRepository
                .findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================
    // Get Appointment By Id
    // ==========================================
    @Override
    public AppointmentResponse getAppointmentById(Integer appointmentId) {

        Appointment appointment = appointmentRepository
                .findById(appointmentId)
                .orElseThrow(() ->
                        new AppointmentNotFoundException(
                                "Appointment with ID "
                                        + appointmentId
                                        + " not found."));

        return mapToResponse(appointment);
    }

    // ==========================================
    // Update Appointment
    // ==========================================
    @Override
    public AppointmentResponse updateAppointment(Integer appointmentId,
                                                 AppointmentRequest request) {

        Appointment appointment = appointmentRepository
                .findById(appointmentId)
                .orElseThrow(() ->
                        new AppointmentNotFoundException(
                                "Appointment with ID "
                                        + appointmentId
                                        + " not found."));

        appointment.setPatientName(request.getPatientName());
        appointment.setDoctorName(request.getDoctorName());
        appointment.setDisease(request.getDisease());
        appointment.setAppointmentDate(request.getAppointmentDate());

        Appointment updatedAppointment =
                appointmentRepository.save(appointment);

        return mapToResponse(updatedAppointment);
    }

    // ==========================================
    // Delete Appointment
    // ==========================================
    @Override
    public String deleteAppointment(Integer appointmentId) {

        Appointment appointment = appointmentRepository
                .findById(appointmentId)
                .orElseThrow(() ->
                        new AppointmentNotFoundException(
                                "Appointment with ID "
                                        + appointmentId
                                        + " not found."));

        appointmentRepository.delete(appointment);

        return "Appointment cancelled successfully.";
    }

    // ==========================================
    // Search By Patient Name
    // ==========================================
    @Override
    public List<AppointmentResponse> getAppointmentsByPatientName(String patientName) {

        return appointmentRepository
                .findByPatientNameContainingIgnoreCase(patientName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================
    // Search By Doctor Name
    // ==========================================
    @Override
    public List<AppointmentResponse> getAppointmentsByDoctorName(String doctorName) {

        return appointmentRepository
                .findByDoctorNameContainingIgnoreCase(doctorName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================
    // Search By Disease
    // ==========================================
    @Override
    public List<AppointmentResponse> getAppointmentsByDisease(String disease) {

        return appointmentRepository
                .findByDiseaseContainingIgnoreCase(disease)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================
    // Search By Date
    // ==========================================
    @Override
    public List<AppointmentResponse> getAppointmentsByDate(LocalDate appointmentDate) {

        return appointmentRepository
                .findByAppointmentDate(appointmentDate)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================
    // Upcoming Appointments
    // ==========================================
    @Override
    public List<AppointmentResponse> getUpcomingAppointments() {

        return appointmentRepository
                .findByAppointmentDateGreaterThanEqual(LocalDate.now())
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================
    // Appointments Between Dates
    // ==========================================
    @Override
    public List<AppointmentResponse> getAppointmentsBetweenDates(
            LocalDate startDate,
            LocalDate endDate) {

        return appointmentRepository
                .findByAppointmentDateBetween(startDate, endDate)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================
    // Total Appointments
    // ==========================================
    @Override
    public Long getTotalAppointments() {

        return appointmentRepository.count();
    }

    // ==========================================
    // Entity -> DTO Mapping
    // ==========================================
    private AppointmentResponse mapToResponse(Appointment appointment) {

        AppointmentResponse response = new AppointmentResponse();

        response.setAppointmentId(appointment.getAppointmentId());
        response.setPatientName(appointment.getPatientName());
        response.setDoctorName(appointment.getDoctorName());
        response.setDisease(appointment.getDisease());
        response.setAppointmentDate(appointment.getAppointmentDate());

        return response;
    }

}