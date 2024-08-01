package com.example.javaee_hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.graph.GraphSemantic;

import java.util.List;
import java.util.Map;

public class AthleteDAO {

    public boolean saveAthlete(Athlete athlete) {
        Transaction transaction = null;
        boolean flag = false;
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(athlete);
            session.getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        }
        return flag;
    }

    public Athlete AthleteWithCoacheAndSpecialitiesById(int id) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            var athleteGraph = session.getEntityGraph("WithCoacheAndSpecialitiesById");
            Map<String, Object> properties = Map.of(
                    GraphSemantic.LOAD.getJakartaHintName(), athleteGraph);

            var athlete = session.find(Athlete.class, id, properties);

            session.getTransaction().commit();

            return athlete;
        }
    }

    public List<Athlete> allAthletes() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            var athleteGraph = session.getEntityGraph("WithCoacheAndSpecialities");
            var athletes = session.createQuery("select a from Athlete a",
                            Athlete.class)
                    .setHint(GraphSemantic.LOAD.getJakartaHintName(), athleteGraph)
                    .list();

            return athletes;
        }
    }

    public boolean deleteAthlete(Integer id) {
        Transaction transaction = null;
        boolean flag = false;
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Person person = session.get(Person.class, id);
            session.remove(person);
            session.flush();
            session.getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        }
        return flag;
    }

    public boolean updateAthlete(Integer id, String name, String surname, String coach_id) {
        Transaction transaction = null;

        boolean flag = false;
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Athlete athlete = getAthlete(id);

            String nameForUpdate = athlete.getName();
            String surnameForUpdate = athlete.getSurname();
            int coachForUpdate = athlete.getCoach_id();

            if (!("".equals(name))) nameForUpdate = name;
            if (!("".equals(surname))) surnameForUpdate = surname;
            if (!("".equals(coach_id))) coachForUpdate = Integer.parseInt(coach_id);

            session.createQuery(
                    "update Athlete a set name = ?1, surname = ?2, coach_id = ?3 where a.id = ?4").
                    setParameter(1, nameForUpdate).
                    setParameter(2, surnameForUpdate).
                    setParameter(3, coachForUpdate).
                    setParameter(4, id).
                    executeUpdate();

            session.getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        }
        return flag;
    }

     public Athlete getAthlete (int id) {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
              Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Athlete athlete = session.get(Athlete.class, id);
            session.getTransaction().commit();
            return athlete;
        }
     }

}
