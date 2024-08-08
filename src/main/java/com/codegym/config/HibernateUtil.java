package com.
        codegym.config;

import com.codegym.models.enity.Address;
import com.codegym.models.enity.PassportInfo;
import com.codegym.models.enity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/jru_goto_jpa");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "12345678");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true");

        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(PassportInfo.class);

        sessionFactory = configuration.buildSessionFactory();

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
