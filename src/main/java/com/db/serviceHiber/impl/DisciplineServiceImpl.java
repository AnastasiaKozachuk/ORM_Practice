package com.db.serviceHiber.impl;

import com.db.HibernateUtil;
import com.db.daoHiber.DisciplineDAOH;
import com.db.daoHiber.impl.DisciplineDAOHImpl;
import com.db.model.Discipline;
import com.db.serviceHiber.DisciplineService;
import org.hibernate.HibernateException;

public class DisciplineServiceImpl implements DisciplineService {
    DisciplineDAOH daoh = new DisciplineDAOHImpl();

    @Override
    public Discipline get(Integer id) {
        Discipline discipline = null;
        try {
            HibernateUtil.beginTransaction();
            discipline = daoh.get(id);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            System.out.println("Getting error.");
        }
        return discipline;
    }
}
