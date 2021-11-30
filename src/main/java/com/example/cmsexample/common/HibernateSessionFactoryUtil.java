package com.example.cmsexample.common;

import com.example.cmsexample.models.Picture;
import com.example.cmsexample.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Picture.class);
                configuration.addAnnotatedClass(Partner.class);
                configuration.addAnnotatedClass(Address.class);
                configuration.addAnnotatedClass(Common.class);
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(History.class);
                configuration.addAnnotatedClass(License.class);
                configuration.addAnnotatedClass(Messenger.class);
                configuration.addAnnotatedClass(Phone.class);
                configuration.addAnnotatedClass(Requisite.class);
                configuration.addAnnotatedClass(Service.class);
                configuration.addAnnotatedClass(User.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("[Exception!] " + e);
            }
        }
        return sessionFactory;
    }
}
