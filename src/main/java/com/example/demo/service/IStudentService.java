package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student createStudent(Student student);

    Student updateStudent(Long id, Student updateStudent);

    void deleteStudent(Long id);
}
