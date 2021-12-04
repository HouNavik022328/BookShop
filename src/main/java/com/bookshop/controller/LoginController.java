/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.controller;

import com.bookshop.users.UserDAO;
import com.bookshop.users.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author VODUCMINH
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    private static final String ERROR = "login.html";
    private static final String USER = "category.jsp";
    private static final String ADMIN = "admin-product.jsp";
    private static final String CHECKOUT = "checkout.jsp";
    private static final int AD = 1;
    private static final int US = 2;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "login.html";
        try {
            String userID = request.getParameter("userID");
            String password = request.getParameter("password");
            
            UserDAO dao = new UserDAO();
            UserDTO loginUser = dao.checkLogin(userID, password);
            
            HttpSession session = request.getSession();
            session.setAttribute("LOGIN_USER", loginUser);
            
            if (loginUser != null) {
                
                if (AD == loginUser.getRoleID()) {
                    url = ADMIN;
                }
                else if (US == loginUser.getRoleID()) {
                    url = USER;
                }
                else {
                    session.setAttribute("MESSAGE_ERROR", "This role is not supported!");
                }
            }
            else {
                session.setAttribute("MESSAGE_ERROR", "Incorrect user ID or password!");
            }
        } 
        catch (Exception e) {
        }
        finally {
            response.sendRedirect(url);
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
