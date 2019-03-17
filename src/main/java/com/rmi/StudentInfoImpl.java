package com.rmi;

import com.db.daoHiber.DisciplineDAOH;
import com.db.daoHiber.EnrollmentDAOH;
import com.db.daoHiber.StudentDAOH;
import com.db.daoHiber.impl.DisciplineDAOHImpl;
import com.db.daoHiber.impl.EnrollmentDAOHImpl;
import com.db.daoHiber.impl.StudentDAOHImpl;
import com.db.daoJdbc.DisciplineDAO;
import com.db.daoJdbc.EnrollmentDAO;
import com.db.daoJdbc.StudentDAO;
import com.db.daoJdbc.impl.DisciplineDAOImpl;
import com.db.daoJdbc.impl.EnrollmentDAOImpl;
import com.db.daoJdbc.impl.StudentDAOImpl;
import com.db.model.Discipline;
import com.db.model.Enrollment;
import com.db.model.Student;
import com.db.serviceHiber.DisciplineService;
import com.db.serviceHiber.EnrollmentService;
import com.db.serviceHiber.StudentService;
import com.db.serviceHiber.impl.DisciplineServiceImpl;
import com.db.serviceHiber.impl.EnrollmentServiceImpl;
import com.db.serviceHiber.impl.StudentServiceImpl;

import java.rmi.RemoteException;
import java.util.List;

public class StudentInfoImpl implements StudentInfo {
    @Override
    public String getInfoAboutAllStud() {
        StudentDAO studentDAO = new StudentDAOImpl();
        StringBuilder result=new StringBuilder();
        for(Student student:  studentDAO.getAllStudents()){
            result.append(student.toString()).append("\n");
        }
        return result.toString();
    }

    @Override
    public String getInfoAboutOneStud(String name) {

        StudentDAO studentDAO = new StudentDAOImpl();
        DisciplineDAO disciplineDAO = new DisciplineDAOImpl();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAOImpl();

        StringBuilder result=new StringBuilder();

        Student student = studentDAO.getByName(name);
        if (student != null) {
            List<Enrollment> enrollmentList = enrollmentDAO.getByStudentId(student.getId());

            for (Enrollment enrollment : enrollmentList) {
                Discipline discipline = disciplineDAO.get(enrollment.getDisc_id());
                result.append("Discipline: ").append(discipline.getName()).append(", Grade: ").append(enrollment.getGrade()).append("\n");
            }
        }

        return result.toString();
    }

    @Override
    public String getInfoAboutAllStudH() throws RemoteException {
        StudentService studentService = new StudentServiceImpl();
        StringBuilder result=new StringBuilder();
        for(Student student:  studentService.getAllStudents()){
            result.append(student.toString()).append("\n");
        }
        return result.toString();
    }

    @Override
    public String getInfoAboutOneStudH(String name) throws RemoteException {
        StudentService studentService = new StudentServiceImpl();
        DisciplineService disciplineService = new DisciplineServiceImpl();
        EnrollmentService enrollmentService = new EnrollmentServiceImpl();

        StringBuilder result=new StringBuilder();

        Student student = studentService.getByName(name);
        if (student != null) {
            List<Enrollment> enrollmentList = enrollmentService.getByStudentId(student.getId());

            for (Enrollment enrollment : enrollmentList) {
                Discipline discipline = disciplineService.get(enrollment.getDisc_id());
                result.append("Discipline: ").append(discipline.getName()).append(", Grade: ").append(enrollment.getGrade()).append("\n");
            }
        }

        return result.toString();
    }
}
