package dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alex Tompkins - 821984
 * @author Nico
 */
public class DBUtil {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsersDB");

    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}
