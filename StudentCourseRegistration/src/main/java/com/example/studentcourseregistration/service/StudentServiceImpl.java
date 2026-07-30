package com.example.studentcourseregistration.service;

import com.example.studentcourseregistration.dto.StudentRequest;
import com.example.studentcourseregistration.dto.StudentResponse;
import com.example.studentcourseregistration.exception.DuplicateStudentException;
import com.example.studentcourseregistration.exception.StudentNotFoundException;
import com.example.studentcourseregistration.model.Student;
import com.example.studentcourseregistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // ==========================================================
    // Convert Entity to Response DTO
    // ==========================================================
    private StudentResponse mapToResponse(Student student) {

        return new StudentResponse(
                student.getStudentId(),
                student.getStudentName(),
                student.getCourseName(),
                student.getEmail(),
                student.getAge()
        );
    }

    // ==========================================================
    // Convert Request DTO to Entity
    // ==========================================================
    private Student mapToEntity(StudentRequest request) {

        Student student = new Student();

        student.setStudentName(request.getStudentName());
        student.setCourseName(request.getCourseName());
        student.setEmail(request.getEmail());
        student.setAge(request.getAge());

        return student;
    }

    // ==========================================================
    // Register Student
    // ==========================================================
    @Override
    public StudentResponse registerStudent(StudentRequest request) {

        studentRepository.findByEmail(request.getEmail())
                .ifPresent(student -> {
                    throw new DuplicateStudentException(
                            "Student already registered with email : "
                                    + request.getEmail()
                    );
                });

        Student savedStudent =
                studentRepository.save(mapToEntity(request));

        return mapToResponse(savedStudent);
    }

    // ==========================================================
    // Get All Students
    // ==========================================================
    @Override
    public List<StudentResponse> getAllStudents() {

        return studentRepository
                .findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Student By ID
    // ==========================================================
    @Override
    public StudentResponse getStudentById(Integer studentId) {

        Student student = studentRepository
                .findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student with ID "
                                        + studentId
                                        + " not found."
                        ));

        return mapToResponse(student);
    }

    // ==========================================================
    // Update Student
    // ==========================================================
    @Override
    public StudentResponse updateStudent(Integer studentId,
                                         StudentRequest request) {

        Student existingStudent = studentRepository
                .findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student with ID "
                                        + studentId
                                        + " not found."
                        ));

        existingStudent.setStudentName(request.getStudentName());
        existingStudent.setCourseName(request.getCourseName());
        existingStudent.setEmail(request.getEmail());
        existingStudent.setAge(request.getAge());

        Student updatedStudent =
                studentRepository.save(existingStudent);

        return mapToResponse(updatedStudent);
    }

    // ==========================================================
    // Delete Student
    // ==========================================================
    @Override
    public String deleteStudent(Integer studentId) {

        Student student = studentRepository
                .findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student with ID "
                                        + studentId
                                        + " not found."
                        ));

        studentRepository.delete(student);

        return "Student deleted successfully.";
    }

    // ==========================================================
    // PATCH Student
    // ==========================================================
    @Override
    public StudentResponse patchStudent(Integer studentId,
                                        Map<String, Object> updates) {

        Student existingStudent = studentRepository
                .findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student with ID "
                                        + studentId
                                        + " not found."
                        ));

        if (updates.containsKey("studentName")) {
            existingStudent.setStudentName(
                    updates.get("studentName").toString());
        }

        if (updates.containsKey("courseName")) {
            existingStudent.setCourseName(
                    updates.get("courseName").toString());
        }

        if (updates.containsKey("email")) {
            existingStudent.setEmail(
                    updates.get("email").toString());
        }

        if (updates.containsKey("age")) {
            existingStudent.setAge(
                    Integer.valueOf(updates.get("age").toString()));
        }

        Student updatedStudent =
                studentRepository.save(existingStudent);

        return mapToResponse(updatedStudent);
    }

    // ==========================================================
    // Get Students By Name
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByName(String studentName) {

        return studentRepository
                .findByStudentNameIgnoreCase(studentName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Students By Name Contains
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByNameContains(String studentName) {

        return studentRepository
                .findByStudentNameContainingIgnoreCase(studentName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Students By Name Starts With
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByNameStartsWith(String studentName) {

        return studentRepository
                .findByStudentNameStartingWithIgnoreCase(studentName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Students By Name Ends With
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByNameEndsWith(String studentName) {

        return studentRepository
                .findByStudentNameEndingWithIgnoreCase(studentName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Students By Course
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByCourse(String courseName) {

        return studentRepository
                .findByCourseNameIgnoreCase(courseName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Students By Course Contains
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByCourseContains(String courseName) {

        return studentRepository
                .findByCourseNameContainingIgnoreCase(courseName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Students By Course Starts With
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByCourseStartsWith(String courseName) {

        return studentRepository
                .findByCourseNameStartingWithIgnoreCase(courseName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Students By Course Ends With
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByCourseEndsWith(String courseName) {

        return studentRepository
                .findByCourseNameEndingWithIgnoreCase(courseName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Students By Email Contains
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByEmailContains(String email) {

        return studentRepository
                .findByEmailContainingIgnoreCase(email)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Students By Email Starts With
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByEmailStartsWith(String email) {

        return studentRepository
                .findByEmailStartingWithIgnoreCase(email)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Students By Email Ends With
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByEmailEndsWith(String email) {

        return studentRepository
                .findByEmailEndingWithIgnoreCase(email)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Students By Age
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByAge(Integer age) {

        return studentRepository
                .findByAge(age)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Students By Age Greater Than
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByAgeGreaterThan(Integer age) {

        return studentRepository
                .findByAgeGreaterThan(age)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Students By Age Less Than
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByAgeLessThan(Integer age) {

        return studentRepository
                .findByAgeLessThan(age)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Students By Age Between
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByAgeBetween(Integer min,
                                                         Integer max) {

        return studentRepository
                .findByAgeBetween(min, max)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Students By Name And Course
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByNameAndCourse(
            String studentName,
            String courseName) {

        return studentRepository
                .findByStudentNameAndCourseName(studentName, courseName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Get Students By Course And Age
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByCourseAndAge(
            String courseName,
            Integer age) {

        return studentRepository
                .findByCourseNameAndAgeGreaterThan(courseName, age)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Search Students
    // ==========================================================
    @Override
    public List<StudentResponse> searchStudents(
            String studentName,
            String courseName) {

        return studentRepository
                .findByStudentNameContainingIgnoreCaseAndCourseNameContainingIgnoreCase(
                        studentName,
                        courseName)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Sort By Student Name ASC
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByNameAsc() {

        return studentRepository
                .findAllByOrderByStudentNameAsc()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Sort By Student Name DESC
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByNameDesc() {

        return studentRepository
                .findAllByOrderByStudentNameDesc()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Sort By Course Name
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByCourseAsc() {

        return studentRepository
                .findAllByOrderByCourseNameAsc()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Sort By Age ASC
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByAgeAsc() {

        return studentRepository
                .findAllByOrderByAgeAsc()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Sort By Age DESC
    // ==========================================================
    @Override
    public List<StudentResponse> getStudentsByAgeDesc() {

        return studentRepository
                .findAllByOrderByAgeDesc()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Top 5 Oldest Students
    // ==========================================================
    @Override
    public List<StudentResponse> getTop5OldestStudents() {

        return studentRepository
                .findTop5ByOrderByAgeDesc()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Top 10 Youngest Students
    // ==========================================================
    @Override
    public List<StudentResponse> getTop10YoungestStudents() {

        return studentRepository
                .findTop10ByOrderByAgeAsc()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================================
    // Latest Student
    // ==========================================================
    @Override
    public StudentResponse getLatestStudent() {

        Student student =
                studentRepository.findTopByOrderByStudentIdDesc();

        if (student == null) {
            throw new StudentNotFoundException(
                    "No students registered."
            );
        }

        return mapToResponse(student);
    }

    // ==========================================================
    // Total Students
    // ==========================================================
    @Override
    public Long getTotalStudents() {

        return studentRepository.getTotalStudents();
    }

    // ==========================================================
    // Average Age
    // ==========================================================
    @Override
    public Double getAverageAge() {

        return studentRepository.getAverageAge();
    }

    // ==========================================================
    // Maximum Age
    // ==========================================================
    @Override
    public Integer getMaximumAge() {

        return studentRepository.getMaximumAge();
    }

    // ==========================================================
    // Minimum Age
    // ==========================================================
    @Override
    public Integer getMinimumAge() {

        return studentRepository.getMinimumAge();
    }

}
