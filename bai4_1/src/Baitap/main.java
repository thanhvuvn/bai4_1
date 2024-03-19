package Baitap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class main  {
  
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng học viên
        System.out.print("Nhap so luong hoc vien: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống

        // Nhập thông tin học viên và ghi vào file
        try (PrintWriter writer = new PrintWriter("thongTinHocSinh.txt")) {
            for (int i = 0; i < n; i++) {
                System.out.println("Nhap thong tin hoc vien thu " + (i + 1) + ":");
                System.out.print("Ma sinh vien: ");
                String studentID = scanner.nextLine();
                System.out.print("Ho ten: ");
                String name = scanner.nextLine();
                System.out.print("Gioi tinh: ");
                String gender = scanner.nextLine();
                System.out.print("Diem Python: ");
                double pythonScore = scanner.nextDouble();
                System.out.print("Diem Java: ");
                double javaScore = scanner.nextDouble();
                scanner.nextLine(); // Đọc bỏ dòng trống
                writer.println(studentID + "," + name + "," + gender + "," + pythonScore + "," + javaScore);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Đọc dữ liệu từ file và thực hiện các công việc
        List<Student> students = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File("thongTinHocsinh.txt"))) {
            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(",");
                Student student = new Student(data[0], data[1], data[2], Double.parseDouble(data[3]), Double.parseDouble(data[4]));
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Sắp xếp học viên theo điểm trung bình giảm dần
        students.sort(Comparator.comparingDouble(student -> -student.averageScore));

        // In và ghi danh sách học viên đã sắp xếp
        try (PrintWriter writer = new PrintWriter("diemGiamDanCuaHocSinh.txt")) {
            System.out.println("Danh sach hoc vien sau khi sap xep diem trung binh:");
            for (Student student : students) {
                System.out.println(student);
                writer.println(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Tìm kiếm học viên theo tên
        System.out.print("Nhap ho ten hoc vien can tim: ");
        String searchName = scanner.nextLine();
        boolean found = false;
        System.out.println("Ket qua tim kiem:");
        for (Student student : students) {
            if (student.name.equalsIgnoreCase(searchName)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay hoc vien co ho ten " + searchName);
        }

        // Hiển thị thông tin những bạn đã đậu
        System.out.println("Thong tin nhung ban da dau:");
        for (Student student : students) {
            if (student.result.equals("Dau")) {
                System.out.println(student);
            }
        }

        // Hiển thị thông tin những bạn đã trượt
        System.out.println("Thong tin nhung ban da truot:");
        for (Student student : students) {
            if (student.result.equals("Truot")) {
                System.out.println(student);
            }
        }
    }
}

