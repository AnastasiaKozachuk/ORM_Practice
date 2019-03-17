package com.db.daoHiber.impl;

import com.db.HibernateUtil;
import com.db.daoHiber.DisciplineDAOH;
import com.db.model.Discipline;
import org.hibernate.Query;
import org.hibernate.Session;

public class DisciplineDAOHImpl implements DisciplineDAOH {

    protected Session getSession() {
        return HibernateUtil.getSession();
    }

    @Override
    public Discipline get(Integer id) {
        String hql = "from Discipline D "
                + "where D.id=:id";
        Query query = this.getSession().createQuery(hql).setParameter("id", id);

        return (Discipline)  query.uniqueResult();
    }
}
