package com.example.studentcourseregistration.repository;

import com.example.studentcourseregistration.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    // ==========================================================
    // Duplicate Email Check
    // ==========================================================
    Optional<Student> findByEmail(String email);

    // ==========================================================
    // Student Name Queries
    // ==========================================================
    List<Student> findByStudentName(String studentName);

    List<Student> findByStudentNameIgnoreCase(String studentName);

    List<Student> findByStudentNameContainingIgnoreCase(String studentName);

    List<Student> findByStudentNameStartingWithIgnoreCase(String studentName);

    List<Student> findByStudentNameEndingWithIgnoreCase(String studentName);

    // ==========================================================
    // Course Queries
    // ==========================================================
    List<Student> findByCourseName(String courseName);

    List<Student> findByCourseNameIgnoreCase(String courseName);

    List<Student> findByCourseNameContainingIgnoreCase(String courseName);

    List<Student> findByCourseNameStartingWithIgnoreCase(String courseName);

    List<Student> findByCourseNameEndingWithIgnoreCase(String courseName);

    // ==========================================================
    // Email Queries
    // ==========================================================
    List<Student> findByEmailContainingIgnoreCase(String email);

    List<Student> findByEmailStartingWithIgnoreCase(String email);

    List<Student> findByEmailEndingWithIgnoreCase(String email);

    // ==========================================================
    // Age Queries
    // ==========================================================
    List<Student> findByAge(Integer age);

    List<Student> findByAgeGreaterThan(Integer age);

    List<Student> findByAgeGreaterThanEqual(Integer age);

    List<Student> findByAgeLessThan(Integer age);

    List<Student> findByAgeLessThanEqual(Integer age);

    List<Student> findByAgeBetween(Integer min, Integer max);

    // ==========================================================
    // Multiple Conditions
    // ==========================================================
    List<Student> findByStudentNameAndCourseName(
            String studentName,
            String courseName);

    List<Student> findByCourseNameAndAgeGreaterThan(
            String courseName,
            Integer age);

    List<Student> findByStudentNameContainingIgnoreCaseAndCourseNameContainingIgnoreCase(
            String studentName,
            String courseName);

    List<Student> findByCourseNameAndEmail(
            String courseName,
            String email);

    List<Student> findByStudentNameAndAge(
            String studentName,
            Integer age);

    // ==========================================================
    // Sorting
    // ==========================================================
    List<Student> findAllByOrderByStudentNameAsc();

    List<Student> findAllByOrderByStudentNameDesc();

    List<Student> findAllByOrderByCourseNameAsc();

    List<Student> findAllByOrderByAgeAsc();

    List<Student> findAllByOrderByAgeDesc();

    // ==========================================================
    // Top Records
    // ==========================================================
    List<Student> findTop5ByOrderByAgeDesc();

    List<Student> findTop10ByOrderByAgeAsc();

    Student findTopByOrderByStudentIdDesc();

    // ==========================================================
    // JPQL Queries
    // ==========================================================

    @Query("SELECT s FROM Student s WHERE s.age > ?1")
    List<Student> getStudentsAboveAge(Integer age);

    @Query("SELECT s FROM Student s WHERE s.courseName = ?1")
    List<Student> getStudentsByCourse(String courseName);

    @Query("SELECT COUNT(s) FROM Student s")
    Long getTotalStudents();

    @Query("SELECT AVG(s.age) FROM Student s")
    Double getAverageAge();

    @Query("SELECT MAX(s.age) FROM Student s")
    Integer getMaximumAge();

    @Query("SELECT MIN(s.age) FROM Student s")
    Integer getMinimumAge();

}