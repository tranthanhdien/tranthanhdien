/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Profile;

/**
 *
 * @author HP
 */
public class ProcessProfile extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        if (action != null && action.equals("update-profile")) {
            String firstName = request.getParameter("first-name");
            String lastName = request.getParameter("last-name");
            String newEmailOrPhone = request.getParameter("mobile-or-email");
            String password = request.getParameter("user-password");
            String day = request.getParameter("day");
            String month = request.getParameter("month");
            String year = request.getParameter("year");
            String birthday = String.format("%s-%s-%s", day, month, year);
            String sex = request.getParameter("sex");
            Profile profile = new Profile(0, firstName, lastName, 
                    newEmailOrPhone, password, birthday, sex);
            String currentEmailOrPhone = 
                    ((Profile)session.getAttribute("user")).getEmailOrPhone();
            boolean result = UserDAO.updateUser(profile, currentEmailOrPhone);
            if (!result) {
                session.setAttribute("error", "Cannot update! Try again!");
            } else {
                session.setAttribute("error", "");
                session.setAttribute("user", profile);
            }
        }
        
        if (session.getAttribute("user") != null) {
            RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/profile.jsp");
            dis.forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
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

}
