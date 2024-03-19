package Baitap;

import java.io.*;
import java.util.*;

class Student {
    String studentID;
    String name;
    String gender;
    double pythonScore;
    double javaScore;
    double averageScore;
    String result;

    public Student(String studentID, String name, String gender, double pythonScore, double javaScore) {
        this.studentID = studentID;
        this.name = name;
        this.gender = gender;
        this.pythonScore = pythonScore;
        this.javaScore = javaScore;
        this.averageScore = (javaScore * 2 + pythonScore) / 3;
        this.result = calculateResult();
    }

    private String calculateResult() {
        if (averageScore >= 5)
            return "Dau";
        else if (averageScore < 5 && gender.equalsIgnoreCase("Nam"))
            return "Truot";
        else if (averageScore < 5 && gender.equalsIgnoreCase("Nu"))
            return "Dau";
        return "Khong xac dinh";
    }

    @Override
    public String toString() {
        return "Ma sinh vien: " + studentID +
                " - Ho ten: " + name +
                " - Gioi tinh: " + gender +
                " - Diem Python: " + pythonScore +
                " - Diem Java: " + javaScore +
                " - Diem trung binh: " + averageScore +
                " - Ket qua: " + result;
    }
}

