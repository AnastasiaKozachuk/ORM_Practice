package com.db.serviceHiber;

import com.db.model.Student;

import java.util.List;

public interface StudentService {

    Student get(Integer id);
    Student getByName(String name);
    List<Student> getAllStudents();
}
