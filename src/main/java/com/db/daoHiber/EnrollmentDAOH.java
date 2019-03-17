package com.db.daoHiber;

import com.db.model.Enrollment;

import java.util.List;

public interface EnrollmentDAOH {

    Enrollment get(Integer id);
    List getByStudentId(Integer studId);

}
