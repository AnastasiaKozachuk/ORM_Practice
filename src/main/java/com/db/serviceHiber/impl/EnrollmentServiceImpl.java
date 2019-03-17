package com.db.serviceHiber.impl;

import com.db.HibernateUtil;
import com.db.daoHiber.EnrollmentDAOH;
import com.db.daoHiber.impl.EnrollmentDAOHImpl;
import com.db.model.Discipline;
import com.db.model.Enrollment;
import com.db.serviceHiber.EnrollmentService;
import org.hibernate.HibernateException;

import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {

    EnrollmentDAOH daoh = new EnrollmentDAOHImpl();

    @Override
    public Enrollment get(Integer id) {
        Enrollment enrollment = null;
        try {
            HibernateUtil.beginTransaction();
            enrollment = daoh.get(id);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            System.out.println("Getting error with get Enrollment.");
        }
        return enrollment;
    }

    @Override
    public List<Enrollment> getByStudentId(Integer studId) {
        List<Enrollment> enrollments = null;
        try {
            HibernateUtil.beginTransaction();
            enrollments = daoh.getByStudentId(studId);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            System.out.println("Getting error with get Enrollment.");
        }
        return enrollments;
    }
}
