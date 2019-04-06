package com.t1808a.entity;

import com.t1808a.model.StudentModel;

import java.util.ArrayList;

public class Student extends Person {

    private StudentModel studentModel = new StudentModel();

    private String rollNumber;

    private ArrayList<String> errors;

    public Student() {
    }

    public Student(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Student(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.setName(name);
    }

    public Student(String rollNumber, String name, String dob, String address, String phone, String email) {
        this.rollNumber = rollNumber;
        this.setName(name);
        this.setDob(dob);
        this.setAddress(address);
        this.setPhone(phone);
        this.setEmail(email);
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public boolean isValid() {
        this.errors = new ArrayList<>();
        boolean valid = true;
        if (this.rollNumber == null || this.rollNumber.length() == 0) {
            errors.add("Mã số sinh viên không được bỏ trống!");
            valid = false;
        } else {
            Student student = studentModel.getById(this.rollNumber);
            if (student != null) {
                errors.add("Mã số sinh viên đã tồn tại! Vui lòng chọn mã sinh viên khác!");
                valid = false;
            }
        }
        if (this.getName() == null || this.getName().length() == 0) {
            errors.add("Tên sinh viên không được bỏ trống!");
            valid = false;
        } else if (this.getName().length() < 2 || this.getName().length() > 30) {
            errors.add("Tên phải nằm trong khoảng từ 2 đến 30 ký tự!");
            valid = false;
        }
        return valid;
    }

    public ArrayList<String> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<String> errors) {
        this.errors = errors;
    }

    public boolean isValidRollNumber() {
        boolean valid = true;
        this.errors = new ArrayList<>();
        if (this.rollNumber == null || this.rollNumber.length() == 0) {
            errors.add("Mã số sinh viên không được bỏ trống!");
            valid = false;
        } else {
            Student student = studentModel.getById(this.rollNumber);
            if (student != null) {
                errors.add("Mã số sinh viên đã tồn tại! Vui lòng chọn mã sinh viên khác!");
                valid = false;
            }
        }
        return valid;
    }

    public void printErrors() {
        for (int i = 0; i < this.getErrors().size(); i++) {
            System.err.println(this.getErrors().get(i));
        }
    }
}
