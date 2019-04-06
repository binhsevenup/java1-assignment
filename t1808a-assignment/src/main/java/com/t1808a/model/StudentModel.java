package com.t1808a.model;

import com.t1808a.entity.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentModel {

    private Connection connection;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection =
                    DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/myschool?user=root&password=abcD1234");
        }
    }

    public boolean insert(Student obj) {
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into students (rollNumber, name, dob, address, phone, email) values (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, obj.getRollNumber());
            preparedStatement.setString(2, obj.getName());
            preparedStatement.setString(3, obj.getDob());
            preparedStatement.setString(4, obj.getAddress());
            preparedStatement.setString(5, obj.getPhone());
            preparedStatement.setString(6, obj.getEmail());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Có lỗi xảy ra. Vui lòng thử lại sau. Error: " + ex.getMessage());
        }
        return false;
    }

    public boolean update(String id, Student obj) {
        return false;
    }

    public boolean deleteHard(String id) {
        try {
            initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from students where rollNumber = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.err.println("Có lỗi xảy ra, vui lòng thử lại sau. Error: " + ex.getMessage());
        }
        return false;
    }

    public boolean deleteSoft(String id) {
        try {
            initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update students set status = -1 where rollNumber = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.err.println("Có lỗi xảy ra, vui lòng thử lại sau. Error: " + ex.getMessage());
        }
        return false;
    }

    public Student getById(String id) {
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from students where rollNumber = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String rollNumber = resultSet.getString(1);
                String name = resultSet.getString(2);
                String dob = resultSet.getString(3);
                String address = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String email = resultSet.getString(6);
                Student st = new Student(rollNumber, name, dob, address, phone, email);
                return st;
            }
        } catch (Exception ex) {
            System.out.println("Có lỗi xảy ra. Vui lòng thử lại sau. Error: " + ex.getMessage());
        }
        return null;
    }

    public ArrayList<Student> findAll() {
        ArrayList<Student> listObj = new ArrayList<>();
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from students");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String rollNumber = resultSet.getString(1);
                String name = resultSet.getString(2);
                String dob = resultSet.getString(3);
                String address = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String email = resultSet.getString(6);
                Student st = new Student(rollNumber, name, dob, address, phone, email);
                listObj.add(st);
            }
        } catch (Exception ex) {
            System.out.println("Có lỗi xảy ra. Vui lòng thử lại sau. Error: " + ex.getMessage());
        }
        return listObj;
    }
}
