package com.example.demo.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService();
        studentService.addStudent(new Student("SV01", "Dai", 8, 7, 9));
    }

    @Test
    void addStudentWithNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> studentService.addStudent(null));
        assertEquals("student cannot be null", exception.getMessage());
    }

    @Test
    void addStudent() {
        Student student = new Student("SV02", "Lan", 6, 7, 8);
        studentService.addStudent(student);
        assertEquals(student, studentService.findStudent("SV02"));
    }

    @Test
    void removeStudent() {
        assertTrue(studentService.removeStudent("SV01"));
        assertNull(studentService.findStudent("SV01"));
    }

    @Test
    void updateStudent() {
        Student newStudent = new Student("SV01", "Nam", 9, 9, 9);
        assertTrue(studentService.updateStudent("SV01", newStudent));
        assertEquals(9.0, studentService.findStudent("SV01").calculateGPA());
    }

    @Test
    void findStudent() {
        assertNotNull(studentService.findStudent("SV01"));
        assertNull(studentService.findStudent("SV99"));
    }
}