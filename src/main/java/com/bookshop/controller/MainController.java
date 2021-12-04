/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.controller;

import java.io.IOException;
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
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String GET_LIST_BOOK = "GetListBookController";
    private static final String GET_LANDING = "GetLandingController";
    private static final String GET_DETAIL = "GetDetailController";
    private static final String GET_CATE = "GetCateController";
    private static final String GET_TYPE = "GetTypeController";
    private static final String ADD_TO_CART = "AddToCartController";
    private static final String UPDATE_CART = "UpdateCartController";
    private static final String DELETE_CART = "DeleteCartController";
    private static final String CHECK_OUT = "GetInfoCheckoutController";
    private static final String LOG_OUT = "LogoutController";
    private static final String GET_PRODUCT = "GetProductController";
    private static final String ADD_PRODUCT = "AddProductController";
    private static final String UPDATE_PRODUCT = "UpdateProductController";
    private static final String DELETE_PRODUCT = "DeleteProductController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        
        try {
            String action = request.getParameter("action");
            if ("Login".equals(action)) {
                url = LOGIN;
            }
            else if ("GetBook".equals(action)) {
                url = GET_LIST_BOOK;
            }    
            else if ("GetLanding".equals(action)) {
                url = GET_LANDING;
            }    
            else if ("Detail".equals(action)) {
                url = GET_DETAIL;
            }    
            else if ("GetCate".equals(action)) {
                url = GET_CATE;
            }    
            else if ("GetType".equals(action)) {
                url = GET_TYPE;
            }    
            else if ("AddToCart".equals(action)) {
                url = ADD_TO_CART;
            }    
            else if ("UpdateCart".equals(action)) {
                url = UPDATE_CART;
            }    
            else if ("DeleteCart".equals(action)) {
                url = DELETE_CART;
            }    
            else if ("GetInfoCheckout".equals(action)) {
                url = CHECK_OUT;
            }    
            else if ("Logout".equals(action)) {
                url = LOG_OUT;
            }    
            else if ("GetAllProduct".equals(action)) {
                url = GET_PRODUCT;
            }    
            else if ("AddProduct".equals(action)) {
                url = ADD_PRODUCT;
            }    
            else if ("EditProduct".equals(action)) {
                url = UPDATE_PRODUCT;
            }    
            else if ("DeleteProduct".equals(action)) {
                url = DELETE_PRODUCT;
            }    
            else {
                HttpSession session = request.getSession();
                session.setAttribute("CONTROLLER_ERROR_MESSAGE", "This function is not supported!");
            }
        } 
        catch (Exception e) {
            log("Error at MainController: " + e.toString());
        }
        finally {
            request.getRequestDispatcher(url).forward(request, response);
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
