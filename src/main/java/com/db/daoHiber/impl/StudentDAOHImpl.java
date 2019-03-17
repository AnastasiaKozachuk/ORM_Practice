package com.db.daoHiber.impl;

import com.db.HibernateUtil;
import com.db.daoHiber.StudentDAOH;
import com.db.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class StudentDAOHImpl implements StudentDAOH {
    protected Session getSession() {
        return HibernateUtil.getSession();
    }

    @Override
    public Student get(Integer id) {
        String hql = "from Student S "
                + "where S.id=:id";
        Query query = this.getSession().createQuery(hql).setParameter("id", id);

        return (Student)  query.uniqueResult();
    }

    @Override
    public Student getByName(String name) {
        String hql = "from Student S "
                + "where S.fio=:name";
        Query query = this.getSession().createQuery(hql).setParameter("name", name);

        return (Student)  query.uniqueResult();
    }

    @Override
    public List<Student> getAllStudents() {
        Session hibernateSession = this.getSession();
        Query query = hibernateSession.createQuery("from Student ");
        return (List<Student> ) query.list();
    }
}
