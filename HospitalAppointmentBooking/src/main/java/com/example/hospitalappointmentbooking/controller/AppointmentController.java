package com.example.hospitalappointmentbooking.controller;

import com.example.hospitalappointmentbooking.dto.AppointmentRequest;
import com.example.hospitalappointmentbooking.dto.AppointmentResponse;
import com.example.hospitalappointmentbooking.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // ============================================================
    // POST : Book Appointment
    // URL : http://localhost:8080/api/appointments
    // ============================================================
    @PostMapping
    public ResponseEntity<AppointmentResponse> saveAppointment(
            @Valid @RequestBody AppointmentRequest appointmentRequest) {

        AppointmentResponse response =
                appointmentService.saveAppointment(appointmentRequest);

        return ResponseEntity.ok(response);
    }

    // ============================================================
    // GET : Get All Appointments
    // URL : http://localhost:8080/api/appointments
    // ============================================================
    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAllAppointments() {

        List<AppointmentResponse> response =
                appointmentService.getAllAppointments();

        return ResponseEntity.ok(response);
    }

    // ============================================================
    // GET : Get Appointment By Id
    // URL : http://localhost:8080/api/appointments/{id}
    // ============================================================
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponse> getAppointmentById(
            @PathVariable Integer id) {

        AppointmentResponse response =
                appointmentService.getAppointmentById(id);

        return ResponseEntity.ok(response);
    }

    // ============================================================
    // PUT : Update Appointment
    // URL : http://localhost:8080/api/appointments/{id}
    // ============================================================
    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResponse> updateAppointment(
            @PathVariable Integer id,
            @Valid @RequestBody AppointmentRequest appointmentRequest) {

        AppointmentResponse response =
                appointmentService.updateAppointment(id, appointmentRequest);

        return ResponseEntity.ok(response);
    }

    // ============================================================
    // DELETE : Cancel Appointment
    // URL : http://localhost:8080/api/appointments/{id}
    // ============================================================
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(
            @PathVariable Integer id) {

        String response =
                appointmentService.deleteAppointment(id);

        return ResponseEntity.ok(response);
    }

    // ============================================================
    // GET : Search By Patient Name
    // URL : http://localhost:8080/api/appointments/patient/{patientName}
    // ============================================================
    @GetMapping("/patient/{patientName}")
    public ResponseEntity<List<AppointmentResponse>> getByPatientName(
            @PathVariable String patientName) {

        return ResponseEntity.ok(
                appointmentService.getAppointmentsByPatientName(patientName));
    }

    // ============================================================
    // GET : Search By Doctor Name
    // URL : http://localhost:8080/api/appointments/doctor/{doctorName}
    // ============================================================
    @GetMapping("/doctor/{doctorName}")
    public ResponseEntity<List<AppointmentResponse>> getByDoctorName(
            @PathVariable String doctorName) {

        return ResponseEntity.ok(
                appointmentService.getAppointmentsByDoctorName(doctorName));
    }

    // ============================================================
    // GET : Search By Disease
    // URL : http://localhost:8080/api/appointments/disease/{disease}
    // ============================================================
    @GetMapping("/disease/{disease}")
    public ResponseEntity<List<AppointmentResponse>> getByDisease(
            @PathVariable String disease) {

        return ResponseEntity.ok(
                appointmentService.getAppointmentsByDisease(disease));
    }

    // ============================================================
    // GET : Search By Appointment Date
    // URL : http://localhost:8080/api/appointments/date/{date}
    // Example : 2026-08-15
    // ============================================================
    @GetMapping("/date/{date}")
    public ResponseEntity<List<AppointmentResponse>> getByDate(
            @PathVariable LocalDate date) {

        return ResponseEntity.ok(
                appointmentService.getAppointmentsByDate(date));
    }

    // ============================================================
    // GET : Upcoming Appointments
    // URL : http://localhost:8080/api/appointments/upcoming
    // ============================================================
    @GetMapping("/upcoming")
    public ResponseEntity<List<AppointmentResponse>> getUpcomingAppointments() {

        return ResponseEntity.ok(
                appointmentService.getUpcomingAppointments());
    }

    // ============================================================
    // GET : Appointments Between Two Dates
    // URL :
    // http://localhost:8080/api/appointments/between?startDate=2026-08-01&endDate=2026-08-31
    // ============================================================
    @GetMapping("/between")
    public ResponseEntity<List<AppointmentResponse>> getAppointmentsBetweenDates(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {

        return ResponseEntity.ok(
                appointmentService.getAppointmentsBetweenDates(
                        startDate,
                        endDate));
    }

    // ============================================================
    // GET : Total Appointments
    // URL : http://localhost:8080/api/appointments/count
    // ============================================================
    @GetMapping("/count")
    public ResponseEntity<Long> getTotalAppointments() {

        return ResponseEntity.ok(
                appointmentService.getTotalAppointments());
    }

}