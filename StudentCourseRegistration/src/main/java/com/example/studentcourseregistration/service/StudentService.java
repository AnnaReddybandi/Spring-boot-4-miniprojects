package com.example.studentcourseregistration.service;

import com.example.studentcourseregistration.dto.StudentRequest;
import com.example.studentcourseregistration.dto.StudentResponse;

import java.util.List;
import java.util.Map;

public interface StudentService {

    // ==========================================================
    // CRUD Operations
    // ==========================================================

    StudentResponse registerStudent(StudentRequest request);

    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(Integer studentId);

    StudentResponse updateStudent(Integer studentId,
                                  StudentRequest request);

    String deleteStudent(Integer studentId);

    StudentResponse patchStudent(Integer studentId,
                                 Map<String, Object> updates);

    // ==========================================================
    // Student Name Queries
    // ==========================================================

    List<StudentResponse> getStudentsByName(String studentName);

    List<StudentResponse> getStudentsByNameContains(String studentName);

    List<StudentResponse> getStudentsByNameStartsWith(String studentName);

    List<StudentResponse> getStudentsByNameEndsWith(String studentName);

    // ==========================================================
    // Course Queries
    // ==========================================================

    List<StudentResponse> getStudentsByCourse(String courseName);

    List<StudentResponse> getStudentsByCourseContains(String courseName);

    List<StudentResponse> getStudentsByCourseStartsWith(String courseName);

    List<StudentResponse> getStudentsByCourseEndsWith(String courseName);

    // ==========================================================
    // Email Queries
    // ==========================================================

    List<StudentResponse> getStudentsByEmailContains(String email);

    List<StudentResponse> getStudentsByEmailStartsWith(String email);

    List<StudentResponse> getStudentsByEmailEndsWith(String email);

    // ==========================================================
    // Age Queries
    // ==========================================================

    List<StudentResponse> getStudentsByAge(Integer age);

    List<StudentResponse> getStudentsByAgeGreaterThan(Integer age);

    List<StudentResponse> getStudentsByAgeLessThan(Integer age);

    List<StudentResponse> getStudentsByAgeBetween(Integer min,
                                                  Integer max);

    // ==========================================================
    // Multiple Conditions
    // ==========================================================

    List<StudentResponse> getStudentsByNameAndCourse(
            String studentName,
            String courseName);

    List<StudentResponse> getStudentsByCourseAndAge(
            String courseName,
            Integer age);

    List<StudentResponse> searchStudents(
            String studentName,
            String courseName);

    // ==========================================================
    // Sorting
    // ==========================================================

    List<StudentResponse> getStudentsByNameAsc();

    List<StudentResponse> getStudentsByNameDesc();

    List<StudentResponse> getStudentsByCourseAsc();

    List<StudentResponse> getStudentsByAgeAsc();

    List<StudentResponse> getStudentsByAgeDesc();

    // ==========================================================
    // Top Records
    // ==========================================================

    List<StudentResponse> getTop5OldestStudents();

    List<StudentResponse> getTop10YoungestStudents();

    StudentResponse getLatestStudent();

    // ==========================================================
    // Statistics
    // ==========================================================

    Long getTotalStudents();

    Double getAverageAge();

    Integer getMaximumAge();

    Integer getMinimumAge();

}