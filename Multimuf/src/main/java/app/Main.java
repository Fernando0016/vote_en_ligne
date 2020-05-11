/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import DAO.Database;
import DAO.UserDAO;
import model.User;

public class Main {

    public static void main(String[] args) throws Exception {
        Database db = new Database("testMu");
        UserDAO userDAO = new UserDAO(db);

        User user = new User("tatata@tata.fr", "tata", "password");
        User user2 = userDAO.create(user);


        //System.out.println(user.getEmail());
        User user4 = new User("ttitittit@ttiei.fr", "TATA", "mdp");
        user = userDAO.update("tatata@tata.fr", user2);

        User toto = new User("toto@tata.fr", "toto", "password");
        user = userDAO.create(toto);

        User nulll = userDAO.getUserByEmail("fffefef");
        if (nulll == null) {
            System.out.println("CA MARCHE");
        } else {
            System.out.println("CA MARCHE PAS");
        }

        System.out.println(user.getEmail());
        System.out.println(user.getId());

        //user = userDAO.update("tatata@tata.fr", user2);
    }
}
