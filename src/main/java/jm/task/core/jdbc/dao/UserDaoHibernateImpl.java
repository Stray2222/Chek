package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
        private void statementExecutor(String query) {
            try (Session session = Util.getSessionFactory().openSession()) {
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
        Transaction transaction;

        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
    statementExecutor("Delete from User u where u.id =:id");
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = getSessionFactory().openSession()) {
            return session.createQuery("From User", User.class).list();
        }
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction;

        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("Delete From User")
                    .executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}