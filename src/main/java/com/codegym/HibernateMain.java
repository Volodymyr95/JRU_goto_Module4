package com.codegym;

import com.codegym.config.HibernateUtil;
import com.codegym.models.enity.PassportInfo;
import com.codegym.models.enity.User;
import com.codegym.models.enums.Gender;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateMain {
    private static Session session = null;

    public static void main(String[] args) {

        session = HibernateUtil.getSessionFactory().openSession();

        createUser();
    }

    private static void getUsersGraterThanAge(int age) {
        Query query = session.createQuery("SELECT u from User u where u.age > :age", User.class);
        query.setParameter("age", 15);
    }

    private static void getAgeSumm() {
        Query query = session.createQuery("SELECT SUM(u.age) from User u", Long.class);
        System.out.println(query.uniqueResult());
    }

    private static void createUser() {
        Transaction transaction = session.beginTransaction();
        PassportInfo passportInfo = new PassportInfo("UA", "u");

        User user = new User("Mike", "Tyson", 36);
        user.setGender(Gender.MALE);
        user.setTgChanels(List.of("java", "spring"));
        user.setPassportInfo(passportInfo);
        session.merge(user);
        transaction.commit();
    }

    private static void joinUserWithAddress() {
        Query query = session.createQuery("SELECT u.firstName, a.street FROM User u JOIN u.address a where u.address.id = a.id");
        List<Object[]> list = query.list();


        for (Object[] objects : list) {
            System.out.print((String) objects[0] + " - ");
            System.out.print((String) objects[1]);
        }
    }

    private static void useIn() {
        Query query = session.createQuery("SELECT  u from User u WHERE u.age IN (:ageSet)");
        query.setParameterList("ageSet", new Integer[]{10, 11, 18});
        System.out.println(query.list());
    }
}
