package com.db.serviceHiber.impl;

import com.db.HibernateUtil;
import com.db.daoHiber.StudentDAOH;
import com.db.daoHiber.impl.StudentDAOHImpl;
import com.db.model.Enrollment;
import com.db.model.Student;
import com.db.serviceHiber.StudentService;
import org.hibernate.HibernateException;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentDAOH daoh = new StudentDAOHImpl();

    @Override
    public Student get(Integer id) {
        Student student = null;
        try {
            HibernateUtil.beginTransaction();
            student = daoh.get(id);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            System.out.println("Getting error with get Student.");
        }
        return student;
    }

    @Override
    public Student getByName(String name) {
        Student student = null;
        try {
            HibernateUtil.beginTransaction();
            student = daoh.getByName(name);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            System.out.println("Getting error with get Student.");
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = null;
        try {
            HibernateUtil.beginTransaction();
            students = daoh.getAllStudents();
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            System.out.println("Getting error with get Student.");
        }
        return students;
    }
}
