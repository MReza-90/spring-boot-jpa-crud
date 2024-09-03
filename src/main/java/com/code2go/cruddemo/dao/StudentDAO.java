package com.code2go.cruddemo.dao;

import com.code2go.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findByLastName(String lastName);

    List<Student> findAll();

    void update(Student theStudent);

    void deleteStudent(Integer id);

    int deleteAl();

}
