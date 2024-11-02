package org.example.service;

import org.example.model.Student;
import org.example.repository.StudentRepository;

import java.util.List;

public class StudentService {

    StudentRepository repo = new StudentRepository();

    public List<Student> getAllStudents() {
        // Aufruf des Repository "findAll()"
        return repo.findAll();
    }
}
