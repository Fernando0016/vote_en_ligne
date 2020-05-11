/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static com.mongodb.client.model.Filters.exists;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antoine
 */
public class UserDAOTest {

    private UserDAO userDAO;
    private Database db;
    private User user;

    public UserDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        db = new Database("TestUser");
        userDAO = new UserDAO(db);
        user = new User("cetEmail@existe.fr", "test", "mdp");
    }

    @After
    public void tearDown() {
        db.getCollection("User").deleteMany(exists("pseudo"));
    }

    /**
     * Test of getUserByEmail method, of class UserDAO.
     */
    @Test
    public void testGetUserByEmail() {
        System.out.println("getUserByEmail");

        String email = "";
        User expResult = null;
        User result = userDAO.getUserByEmail(email);
        assertEquals(expResult, result);

        result = userDAO.getUserByEmail(null);
        assertEquals(expResult, result);

        email = "cetEmail@nexiste.pas";
        result = userDAO.getUserByEmail(email);
        assertEquals(expResult, result);

        userDAO.create(user);
        email = "cetEmail@existe.fr";
        result = userDAO.getUserByEmail(email);
        assertEquals(user.getId(), result.getId());
    }

    /**
     * Test of create method, of class UserDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");

        User userCreate = new User("test@create.fr", "test", "mdp");
        User expResult = null;
        User result = userDAO.create(null);
        //Test si le parametre est égal à null
        assertEquals(expResult, result);

        result = userDAO.create(userCreate);
        //Test de bon fonctionnement
        assertEquals(userCreate.getId(), result.getId());

        result = userDAO.create(userCreate);
        //Test pour vérifier qu'il n'insère pas à nouveau l'utilisateur si celui-ci est déjà enregistré dans la base
        assertEquals(expResult, result);

    }

    /**
     * Test of update method, of class UserDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        User userUpdate = new User("test@update.fr", "test", "mdp");
        userDAO.create(userUpdate);
        String oldEmail = "test@update.fr";

        User expResult = null;
        User result = userDAO.update(null, userUpdate);
        //Test si l'email est à null
        assertEquals(expResult, result);

        //Test si l'user est à null
        result = userDAO.update(oldEmail, null);
        assertEquals(expResult, result);

        //Test si la string est vide
        result = userDAO.update("", null);
        assertEquals(expResult, result);

        User userUpdate2 = new User(userUpdate.getId(), "test@update.fr", "test", "mdp");
        result = userDAO.update(oldEmail, userUpdate2);
        //Test de bon fonctionnement
        assertEquals(userUpdate.getId(), result.getId());
        assertEquals(userUpdate2.getEmail(), result.getEmail());

    }

    /**
     * Test of Delete method, of class UserDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("Delete");
        
        User userDelete = new User ("test@delete.fr", "test", "mdp");
        userDAO.create(userDelete);
        String email = "test@delete.fr";
        
        //Test si la string en parametre est vide
        User result = userDAO.Delete("");
        assertEquals(null, result);
        
        //Test si le parametre est null
        result = userDAO.Delete(null);
        assertEquals(null, result);

        //Test de bon fonctionnement
        result = userDAO.Delete(email);
        assertEquals(userDelete.getId(), result.getId());
    }

}
