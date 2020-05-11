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
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Imed
 */
public class Connexion extends HttpServlet {

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
        try {

            String mail = request.getParameter("email1");
            String pass = request.getParameter("password1");
            HttpSession session=request.getSession();
            session.setAttribute("email",mail);
            session.setAttribute("password",pass);
            if (mail != null && !"".equals(mail)
                    && pass != null && !"".equals(pass)) {

                Database DB = new Database("testMu");

                /* 
                MongoClient client = new MongoClient("localhost", 27017);
                DB data = client.getDB("multimuf");
                DBCollection user = data.getCollection("utilisateur");
                 */
                UserDAO user = new UserDAO(DB);
                User user1 = user.getUserByEmail(mail);

                if (user1 != null) {
                    if (user1.getPassword().equals(pass)) {
                        request.setAttribute("info", "SUCCESS");
                        request.getRequestDispatcher("accueil.html").forward(request, response);
                    } else {
                        request.setAttribute("info", "mot de passe incorrect");
                        request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("info", "Failed Connexion");
                    request.getRequestDispatcher("index.html").forward(request, response);
                }
            } else {
                request.setAttribute("info", "vous devez remplir tous les champs svp");
                request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("info", e);
        }

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
