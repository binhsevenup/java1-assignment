package com.t1808a.utility;

import com.t1808a.controller.StudentController;

import java.util.Scanner;

public class MenuUtil {

    private StudentController studentController = new StudentController();
    private Scanner scanner = new Scanner(System.in);

    public void generateStudentMenu() {
        while (true) {
            System.out.println("-------------Menu----------------");
            System.out.println("1. Thêm mới sinh viên.");
            System.out.println("2. Hiển thị danh sách sinh viên.");
            System.out.println("3. Sửa thông tin sinh viên.");
            System.out.println("4. Xoá sinh viên.");
            System.out.println("5. Thoát chương trình.");
            System.out.println("---------------------------------");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    studentController.create();
                    break;
                case 2:
                    studentController.read();
                    break;
                case 3:
                    studentController.update();
                    break;
                case 4:
                    studentController.delete();
                    break;
                case 5:
                    System.out.println("Hẹn gặp lại.");
                    break;
                default:
                    System.out.println("Lựa chọn sai, vui lòng nhập số trong khoảng từ 1 đến 5.");
                    break;
            }
            if (choice == 5) {
                break;
            }
        }
    }
}
