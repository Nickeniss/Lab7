package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.*;

/**
 *
 * @author Alex Tompkins - 821984
 * @author Nico
 */
public class UserDB {

    public List<User> getAll() throws Exception {
        List<User> users = new ArrayList<>();
        
        EntityManager em = null;
        
        try {
            em = DBUtil.getEmFactory().createEntityManager();
            users = em.createNamedQuery("User.findAll",
                    User.class).getResultList();
            
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (em != null)
                em.close();  
            return users;
        }
    }

    public User get(String email) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            User user = em.find(User.class, email);
            return user;
        } finally {
            em.close();
        }
    }

    public void insert(User user) throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(user);
            trans.commit();

        } catch (Exception ex) {
            trans.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    public void update(User user) throws Exception{

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(user);
            trans.commit();

        } catch (Exception ex) {
            trans.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }


public void delete(User user) throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(user));
            trans.commit();

        } catch (Exception ex) {
            trans.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

}
