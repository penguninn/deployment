package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateGPA() {
        Student student = new Student("SV001", "Dai", 8, 7, 9);
        assertEquals(8.0, student.calculateGPA());

        student = new Student("SV002", "Dai", 5, 5, 5);
        assertEquals(5.0, student.calculateGPA());
    }

    @Test
    void classify() {
        assertEquals("Gioi", new Student("SV01", "Nam", 9, 8, 8).classify());
        assertEquals("Kha", new Student("SV02", "Lan", 7, 6.5, 6.5).classify());
        assertEquals("Trung binh", new Student("SV03", "Tùng", 5, 5.5, 5).classify());
        assertEquals("Yeu", new Student("SV04", "Minh", 4, 4.5, 4).classify());
    }
}