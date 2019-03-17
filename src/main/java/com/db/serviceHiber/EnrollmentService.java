package com.db.serviceHiber;

import com.db.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    Enrollment get(Integer id);
    List getByStudentId(Integer studId);
}
