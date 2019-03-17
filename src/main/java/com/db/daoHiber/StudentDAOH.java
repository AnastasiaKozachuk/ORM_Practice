package com.db.daoHiber;

import com.db.model.Student;

import java.util.List;

public interface StudentDAOH {

    Student get(Integer id);
    Student getByName(String name);
    List<Student> getAllStudents();

}
