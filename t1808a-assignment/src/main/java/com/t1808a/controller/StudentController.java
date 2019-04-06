package com.t1808a.controller;

import com.t1808a.entity.Student;
import com.t1808a.model.StudentModel;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {

    private StudentModel studentModel = new StudentModel();

    public void create() {
        System.out.println("Thêm mới thông tin sinh viên, vui lòng nhập các thông tin dưới đây: ");
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        while (!student.isValidRollNumber()) {
            System.out.println("Nhập mã sinh viên: ");
            String rollNumber = scanner.nextLine();
            student.setRollNumber(rollNumber);
            if (!student.isValidRollNumber()) {
                student.printErrors();
            }
        }

//        System.out.println("Tên: ");
//        String name = scanner.nextLine();
//        System.out.println("Ngày sinh: ");
//        String dob = scanner.nextLine();
//        System.out.println("Địa chỉ: ");
//        String address = scanner.nextLine();
//        System.out.println("Số điện thoại: ");
//        String phone = scanner.nextLine();
//        System.out.println("Email: ");
//        String email = scanner.nextLine();

        // 1.1 Kiểm tra mã sinh viên không được để trống.
        // 1.2 Kiểm tra mã sinh viên tồn tại rồi.
        // 2.1 Tên không được để trống.
        // 2.2 Tên phải nằm trong khoảng 2 - 30 ký tự.
//        Student obj = new Student(rollNumber, name, dob, address, phone, email);
//        if (obj.isValid()) {
//            studentModel.insert(obj);
//        } else {
//            System.err.println("Vui lòng sửa các lỗi dưới đây: ");
//            for (int i = 0; i < obj.getErrors().size(); i++) {
//                System.err.println("- " + obj.getErrors().get(i));
//            }
//            System.out.println("\n");
//        }
    }

    public void read() {
        ArrayList<Student> list = studentModel.findAll();
        if (list.size() == 0) {
            System.out.println("Hiện tại không có sinh viên nào.");
            return;
        }
        System.out.println("Hiển thị danh sách sinh viên: ");
        System.out.printf("%15s | %15s | %15s | %15s\n", "Mã sinh viên", "Tên", "Ngày sinh", "Địa chỉ");
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.printf("%15s | %15s | %15s | %15s\n",
                    student.getRollNumber(), student.getName(), student.getDob(), student.getAddress());
        }

    }

    public void update() {

    }

    public void delete() {

    }
}
