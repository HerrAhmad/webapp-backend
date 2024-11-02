package org.example.repository;

import org.example.model.Student;
import org.example.utils.DatabaseFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public Student findById(int id) {
        String query = "SELECT * from students WHERE id = ?;";
        Student student = new Student();

        try (
                Connection connection = DatabaseFactory.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                student.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return student;
    }

    public List<Student> findAll() {
        String query = "SELECT * from students;";
        List<Student> students = new ArrayList<>();

        try (
                Connection connection = DatabaseFactory.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setName(resultSet.getString("name"));
                //student.setAge(resultSet.getInt("age"));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }
}
