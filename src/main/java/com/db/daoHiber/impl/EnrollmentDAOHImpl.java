package com.db.daoHiber.impl;

import com.db.HibernateUtil;
import com.db.daoHiber.EnrollmentDAOH;
import com.db.model.Enrollment;
import org.hibernate.Query;
import org.hibernate.Session;


import java.util.List;

public class EnrollmentDAOHImpl implements EnrollmentDAOH {

    protected Session getSession() {
        return HibernateUtil.getSession();
    }
    @Override
    public Enrollment get(Integer id) {
        String hql = "from Enrollment E "
                + "where E.id=:id";
        Query query = this.getSession().createQuery(hql).setParameter("id", id);

        return (Enrollment)  query.uniqueResult();
    }

    @Override
    public List<Enrollment> getByStudentId(Integer studId) {
        Session hibernateSession = this.getSession();
        Query query = hibernateSession.createQuery("from Enrollment E where E.stud_id=:stud_id ").setParameter("stud_id",studId);

        return query.list();
    }
}
