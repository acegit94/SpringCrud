package com.anshul.cruddemo.dao;

import com.anshul.cruddemo.entity.Student;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    void delete(Integer id);

    int deleteAll();

    List<Student> findAll();

    Student findByLastName(String lastName);

    void update(Student student);

}
