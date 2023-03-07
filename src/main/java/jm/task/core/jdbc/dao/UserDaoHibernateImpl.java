package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory = getSessionFactory();
        private void statementExecutor(String query) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.createSQLQuery(query)
                        .executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
            statementExecutor("Create Table If Not Exists users " +
                    "(id BIGINT Primary Key AUTO_INCREMENT, name Varchar(100), lastName Varchar(100), age Tinyint)");
    }

    @Override
    public void dropUsersTable() {
    statementExecutor("Drop Table If Exists users");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(session.get(User.class, id));
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("From User", User.class).list();
        }
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        try(Session session= sessionFactory.getCurrentSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.createQuery("delete User").executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
}