package com.example.demo.student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<Student>();

    public void addStudent(Student student) {
        if(student == null) {
            throw new IllegalArgumentException("student cannot be null");
        }
        students.add(student);
    }

    public boolean removeStudent(String id) {
        return students.removeIf(student -> student.getId().equals(id));
    }

    public boolean updateStudent(String id, Student student) {
        if(student == null) {
            throw new IllegalArgumentException("student cannot be null");
        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }

    public Student findStudent(String id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }
}
