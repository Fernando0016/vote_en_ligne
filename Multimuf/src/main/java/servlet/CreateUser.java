package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.Database;
import DAO.UserDAO;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Imed
 */
public class CreateUser extends HttpServlet {

    private boolean email_ok = false;
    private boolean pass_ok = false;
    private boolean pseudo_ok = false;
    private boolean confirmation_ok = false;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String mail = request.getParameter("email");

        if (mail != null && !"".equals(mail)) {
            email_ok = true;
        }
        String pass = request.getParameter("password");

        if (pass != null && !"".equals(pass)) {
            pass_ok = true;
        }
        String pseudo = request.getParameter("pseudo");

        if (pseudo != null && !"".equals(pseudo)) {
            pseudo_ok = true;
        }
        String confirmation = request.getParameter("confirmation");

        if (confirmation != null && !"".equals(confirmation)) {
            confirmation_ok = true;
        }

        try {

            if (email_ok && pass_ok && pseudo_ok && confirmation_ok) 
            {
                /* ici avec les DAO il faut le modele
            User user;
            MongoClient client=new MongoClient();
            UserDAO userDao=new UserDAO(client.getDB());
            user=userDao.createUpdate(user);
                 */
                //ici un test sans DAO
/*
                Database db = new Database("testMu");
                UserDAO userDao = new UserDAO(db);
                if (userDao.create(mail, pseudo, pass) != null) {
                    request.setAttribute("info", "vos infos ont bien été enregistrés");
                 */

                Database db = new Database("testMu"); // A CHANGER
                UserDAO userDAO = new UserDAO(db);
                User user = userDAO.getUserByEmail(mail);
                if (user == null) 
                {
                    if (confirmation.equals(pass))
                    {
                        user = new User(mail, pseudo, pass);
                        user = userDAO.create(user);
                        if (user != null) {
                            request.setAttribute("info", "vos infos ont bien été enregistrés");
                            request.getRequestDispatcher("index.html").forward(request, response);
                        } else {
                            request.setAttribute("info", "erreur lors de la création");
                            request.getRequestDispatcher("jsp/inscription.jsp").forward(request, response);
                               }
                    } else { //cas confirmation
                        request.setAttribute("info", "les deux mots de passe sont différents ");
                        request.getRequestDispatcher("jsp/inscription.jsp").forward(request, response);
                           }
                } else {
                    request.setAttribute("info", "l'adresse email est déjà prise par un autre utilisateur");
                    request.getRequestDispatcher("jsp/inscription.jsp").forward(request, response);
                }

            } else {
                request.setAttribute("info", "vous devez remplir tous les champs");
                request.getRequestDispatcher("jsp/inscription.jsp").forward(request, response);
            }

        
    }
    catch (Exception e) {
            request.setAttribute("info", e.getMessage());
    }

    request.getRequestDispatcher ("jsp/inscription.jsp").forward(request, response);
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
        
    public void test_post(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
