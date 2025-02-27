package com.example.demo.student;

public class Student {
    private String id;
    private String name;
    private double math;
    private double physics;
    private double english;

    public double calculateGPA() {
        return (math + physics + english) / 3.0;
    }

    public String classify() {
        double gpa = calculateGPA();
        if (gpa >= 8.0) {
            return "Gioi";
        }
        else if (gpa >= 6.5) {
            return "Kha";
        }
        else if (gpa >= 5.0) {
            return  "Trung binh";
        }
        return "Yeu";
    }

    public Student() {};

    public Student(String id, String name, double math, double physics, double english) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.physics = physics;
        this.english = english;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysics() {
        return physics;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", math=" + math +
                ", physics=" + physics +
                ", english=" + english +
                '}';
    }
}
