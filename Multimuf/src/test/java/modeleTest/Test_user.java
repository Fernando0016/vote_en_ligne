package modeleTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class Test_user {
    
    @Test
    public void test_authentification_good_pswd()
    {
        User user = new User("machin@waho.com", "machin", "nihcam");
        boolean b = user.authentification("nihcam");
        assertEquals(true, b);
    }
    
    @Test
    public void test_authentification_wrong_pswd()
    {
        User user = new User("machin@waho.com", "machin", "nihcam");
        boolean b = user.authentification("lol");
        assertEquals(false, b);
    }
    
    @Test
    public void test_authentification_empty_pswd()
    {
        User user = new User("machin@waho.com", "machin", "nihcam");
        boolean b = user.authentification("");
        assertEquals(false, b);
    }
    
}
