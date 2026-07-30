package com.example.studentcourseregistration.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @NotBlank(message = "Student name cannot be empty")
    @Column(nullable = false)
    private String studentName;

    @NotBlank(message = "Course name cannot be empty")
    @Column(nullable = false)
    private String courseName;

    @Email(message = "Enter valid email")
    @NotBlank(message = "Email is required")
    @Column(nullable = false, unique = true)
    private String email;

    @Min(value = 18, message = "Age must be above 18")
    @Column(nullable = false)
    private Integer age;
}