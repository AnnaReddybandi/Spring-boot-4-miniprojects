package com.example.studentcourseregistration.controller;

import com.example.studentcourseregistration.dto.StudentRequest;
import com.example.studentcourseregistration.dto.StudentResponse;
import com.example.studentcourseregistration.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // ==========================================================
    // POST Register Student
    // POST http://localhost:8080/api/students
    // ==========================================================
    @PostMapping
    public ResponseEntity<StudentResponse> registerStudent(
            @Valid @RequestBody StudentRequest request) {

        return ResponseEntity.ok(
                studentService.registerStudent(request));
    }

    // ==========================================================
    // GET All Students
    // GET http://localhost:8080/api/students
    // ==========================================================
    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents() {

        return ResponseEntity.ok(
                studentService.getAllStudents());
    }

    // ==========================================================
    // GET Student By ID
    // GET http://localhost:8080/api/students/{id}
    // ==========================================================
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                studentService.getStudentById(id));
    }

    // ==========================================================
    // PUT Update Student
    // PUT http://localhost:8080/api/students/{id}
    // ==========================================================
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudent(
            @PathVariable Integer id,
            @Valid @RequestBody StudentRequest request) {

        return ResponseEntity.ok(
                studentService.updateStudent(id, request));
    }

    // ==========================================================
    // DELETE Student
    // DELETE http://localhost:8080/api/students/{id}
    // ==========================================================
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                studentService.deleteStudent(id));
    }

    // ==========================================================
    // PATCH Student
    // PATCH http://localhost:8080/api/students/{id}
    // ==========================================================
    @PatchMapping("/{id}")
    public ResponseEntity<StudentResponse> patchStudent(
            @PathVariable Integer id,
            @RequestBody Map<String, Object> updates) {

        return ResponseEntity.ok(
                studentService.patchStudent(id, updates));
    }

    // ==========================================================
    // Student Name Queries
    // ==========================================================

    // GET http://localhost:8080/api/students/name/Anna
    @GetMapping("/name/{studentName}")
    public ResponseEntity<List<StudentResponse>> getStudentsByName(
            @PathVariable String studentName) {

        return ResponseEntity.ok(
                studentService.getStudentsByName(studentName));
    }

    // GET http://localhost:8080/api/students/name/contains/Ann
    @GetMapping("/name/contains/{studentName}")
    public ResponseEntity<List<StudentResponse>> getStudentsByNameContains(
            @PathVariable String studentName) {

        return ResponseEntity.ok(
                studentService.getStudentsByNameContains(studentName));
    }

    // GET http://localhost:8080/api/students/name/start/A
    @GetMapping("/name/start/{studentName}")
    public ResponseEntity<List<StudentResponse>> getStudentsByNameStartsWith(
            @PathVariable String studentName) {

        return ResponseEntity.ok(
                studentService.getStudentsByNameStartsWith(studentName));
    }

    // GET http://localhost:8080/api/students/name/end/ddy
    @GetMapping("/name/end/{studentName}")
    public ResponseEntity<List<StudentResponse>> getStudentsByNameEndsWith(
            @PathVariable String studentName) {

        return ResponseEntity.ok(
                studentService.getStudentsByNameEndsWith(studentName));
    }

    // ==========================================================
    // Course Queries
    // ==========================================================

    // GET http://localhost:8080/api/students/course/Java
    @GetMapping("/course/{courseName}")
    public ResponseEntity<List<StudentResponse>> getStudentsByCourse(
            @PathVariable String courseName) {

        return ResponseEntity.ok(
                studentService.getStudentsByCourse(courseName));
    }

    // GET http://localhost:8080/api/students/course/contains/Ja
    @GetMapping("/course/contains/{courseName}")
    public ResponseEntity<List<StudentResponse>> getStudentsByCourseContains(
            @PathVariable String courseName) {

        return ResponseEntity.ok(
                studentService.getStudentsByCourseContains(courseName));
    }

    // GET http://localhost:8080/api/students/course/start/J
    @GetMapping("/course/start/{courseName}")
    public ResponseEntity<List<StudentResponse>> getStudentsByCourseStartsWith(
            @PathVariable String courseName) {

        return ResponseEntity.ok(
                studentService.getStudentsByCourseStartsWith(courseName));
    }

    // GET http://localhost:8080/api/students/course/end/va
    @GetMapping("/course/end/{courseName}")
    public ResponseEntity<List<StudentResponse>> getStudentsByCourseEndsWith(
            @PathVariable String courseName) {

        return ResponseEntity.ok(
                studentService.getStudentsByCourseEndsWith(courseName));
    }

    // ==========================================================
    // Email Queries
    // ==========================================================

    // GET http://localhost:8080/api/students/email/contains/gmail
    @GetMapping("/email/contains/{email}")
    public ResponseEntity<List<StudentResponse>> getStudentsByEmailContains(
            @PathVariable String email) {

        return ResponseEntity.ok(
                studentService.getStudentsByEmailContains(email));
    }


    // GET http://localhost:8080/api/students/email/start/anna
    @GetMapping("/email/start/{email}")
    public ResponseEntity<List<StudentResponse>> getStudentsByEmailStartsWith(
            @PathVariable String email) {

        return ResponseEntity.ok(
                studentService.getStudentsByEmailStartsWith(email));
    }


    // GET http://localhost:8080/api/students/email/end/com
    @GetMapping("/email/end/{email}")
    public ResponseEntity<List<StudentResponse>> getStudentsByEmailEndsWith(
            @PathVariable String email) {

        return ResponseEntity.ok(
                studentService.getStudentsByEmailEndsWith(email));
    }



    // ==========================================================
    // Age Queries
    // ==========================================================


    // GET http://localhost:8080/api/students/age/25
    @GetMapping("/age/{age}")
    public ResponseEntity<List<StudentResponse>> getStudentsByAge(
            @PathVariable Integer age) {

        return ResponseEntity.ok(
                studentService.getStudentsByAge(age));
    }



    // GET http://localhost:8080/api/students/age/greater/20
    @GetMapping("/age/greater/{age}")
    public ResponseEntity<List<StudentResponse>> getStudentsByAgeGreaterThan(
            @PathVariable Integer age) {

        return ResponseEntity.ok(
                studentService.getStudentsByAgeGreaterThan(age));
    }



    // GET http://localhost:8080/api/students/age/less/30
    @GetMapping("/age/less/{age}")
    public ResponseEntity<List<StudentResponse>> getStudentsByAgeLessThan(
            @PathVariable Integer age) {

        return ResponseEntity.ok(
                studentService.getStudentsByAgeLessThan(age));
    }



    // GET http://localhost:8080/api/students/age/between?min=20&max=30
    @GetMapping("/age/between")
    public ResponseEntity<List<StudentResponse>> getStudentsByAgeBetween(
            @RequestParam Integer min,
            @RequestParam Integer max) {

        return ResponseEntity.ok(
                studentService.getStudentsByAgeBetween(min, max));
    }



    // ==========================================================
    // Multiple Condition Queries
    // ==========================================================


    // GET http://localhost:8080/api/students/name-course?studentName=Anna&courseName=Java
    @GetMapping("/name-course")
    public ResponseEntity<List<StudentResponse>> getStudentsByNameAndCourse(
            @RequestParam String studentName,
            @RequestParam String courseName) {

        return ResponseEntity.ok(
                studentService.getStudentsByNameAndCourse(
                        studentName,
                        courseName));
    }



    // GET http://localhost:8080/api/students/course-age?courseName=Java&age=25
    @GetMapping("/course-age")
    public ResponseEntity<List<StudentResponse>> getStudentsByCourseAndAge(
            @RequestParam String courseName,
            @RequestParam Integer age) {

        return ResponseEntity.ok(
                studentService.getStudentsByCourseAndAge(
                        courseName,
                        age));
    }



    // GET http://localhost:8080/api/students/search?studentName=Anna&courseName=Java
    @GetMapping("/search")
    public ResponseEntity<List<StudentResponse>> searchStudents(
            @RequestParam String studentName,
            @RequestParam String courseName) {

        return ResponseEntity.ok(
                studentService.searchStudents(
                        studentName,
                        courseName));
    }



    // ==========================================================
    // Sorting Queries
    // ==========================================================


    // GET http://localhost:8080/api/students/sort/name/asc
    @GetMapping("/sort/name/asc")
    public ResponseEntity<List<StudentResponse>> getStudentsByNameAsc() {

        return ResponseEntity.ok(
                studentService.getStudentsByNameAsc());
    }



    // GET http://localhost:8080/api/students/sort/name/desc
    @GetMapping("/sort/name/desc")
    public ResponseEntity<List<StudentResponse>> getStudentsByNameDesc() {

        return ResponseEntity.ok(
                studentService.getStudentsByNameDesc());
    }



    // GET http://localhost:8080/api/students/sort/course/asc
    @GetMapping("/sort/course/asc")
    public ResponseEntity<List<StudentResponse>> getStudentsByCourseAsc() {

        return ResponseEntity.ok(
                studentService.getStudentsByCourseAsc());
    }



    // GET http://localhost:8080/api/students/sort/age/asc
    @GetMapping("/sort/age/asc")
    public ResponseEntity<List<StudentResponse>> getStudentsByAgeAsc() {

        return ResponseEntity.ok(
                studentService.getStudentsByAgeAsc());
    }



    // GET http://localhost:8080/api/students/sort/age/desc
    @GetMapping("/sort/age/desc")
    public ResponseEntity<List<StudentResponse>> getStudentsByAgeDesc() {

        return ResponseEntity.ok(
                studentService.getStudentsByAgeDesc());
    }



    // ==========================================================
    // Top Records
    // ==========================================================


    // GET http://localhost:8080/api/students/top5-oldest
    @GetMapping("/top5-oldest")
    public ResponseEntity<List<StudentResponse>> getTop5OldestStudents() {

        return ResponseEntity.ok(
                studentService.getTop5OldestStudents());
    }



    // GET http://localhost:8080/api/students/top10-youngest
    @GetMapping("/top10-youngest")
    public ResponseEntity<List<StudentResponse>> getTop10YoungestStudents() {

        return ResponseEntity.ok(
                studentService.getTop10YoungestStudents());
    }



    // GET http://localhost:8080/api/students/latest
    @GetMapping("/latest")
    public ResponseEntity<StudentResponse> getLatestStudent() {

        return ResponseEntity.ok(
                studentService.getLatestStudent());
    }



    // ==========================================================
    // Statistics
    // ==========================================================


    // GET http://localhost:8080/api/students/count
    @GetMapping("/count")
    public ResponseEntity<Long> getTotalStudents() {

        return ResponseEntity.ok(
                studentService.getTotalStudents());
    }



    // GET http://localhost:8080/api/students/average-age
    @GetMapping("/average-age")
    public ResponseEntity<Double> getAverageAge() {

        return ResponseEntity.ok(
                studentService.getAverageAge());
    }



    // GET http://localhost:8080/api/students/max-age
    @GetMapping("/max-age")
    public ResponseEntity<Integer> getMaximumAge() {

        return ResponseEntity.ok(
                studentService.getMaximumAge());
    }



    // GET http://localhost:8080/api/students/min-age
    @GetMapping("/min-age")
    public ResponseEntity<Integer> getMinimumAge() {

        return ResponseEntity.ok(
                studentService.getMinimumAge());
    }

}

