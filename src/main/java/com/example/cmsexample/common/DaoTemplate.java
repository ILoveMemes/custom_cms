package com.example.cmsexample.common;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.core.GenericTypeResolver;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class DaoTemplate<DataType> {

    private final Class<DataType> genericType;

    public DaoTemplate() {
        genericType = (Class<DataType>) GenericTypeResolver.resolveTypeArgument(getClass(), DaoTemplate.class);
    }

    private static <T> List<T> loadAllData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = session.createQuery(criteria).getResultList();
        return data;
    }

    public DataType get(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(genericType, id);
    }

    public List<DataType> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<DataType> list = loadAllData(genericType, session);
        session.close();
        return list;
    }

    public DataType save(DataType data) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(data);
        tx1.commit();
        session.close();
        return data;
    }

    public DataType update(DataType data) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(data);
        tx1.commit();
        session.close();
        return data;
    }

    public void delete(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        DataType data = session.load(genericType, id);
        session.delete(data);
        tx1.commit();
        session.close();
    }

    public void delete(DataType data) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(data);
        tx1.commit();
        session.close();
    }

}
