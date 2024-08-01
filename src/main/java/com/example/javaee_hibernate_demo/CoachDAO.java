package com.example.javaee_hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CoachDAO {

    public boolean saveCoach(Coach coach, Integer speciality_id) {
        Transaction transaction = null;
        boolean flag = false;
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                Speciality speciality = session.get(Speciality.class, speciality_id);
                coach.addSpeciality(speciality);
                session.persist(coach);
                session.getTransaction().commit();
                flag = true;
            } catch (Exception e) {
                flag = false;
                if (transaction.isActive()) transaction.rollback();
            }
        return flag;
    }

    public List<Coach> allCoaches() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            List<Coach> coaches = session.
                    createQuery("select c from Coach c left join fetch c.athletes",
                            Coach.class).list();
//            Alternative way:
//            var cGraph = session.getEntityGraph("WithAthletes");
//            var coaches = session.createQuery("select c from Coach c",
//                            Coach.class)
//                    .setHint(GraphSemantic.LOAD.getJakartaHintName(), cGraph)
//                    .list();

            return coaches;
        }
    }

}
