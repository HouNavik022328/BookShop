/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.controller;

import com.bookshop.orders.ShippingInfo;
import com.bookshop.books.BookDAO;
import com.bookshop.shopping.Cart;
import com.bookshop.shopping.CartProduct;
import com.bookshop.users.UserDAO;
import com.bookshop.users.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
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
@WebServlet(name = "GetInfoCheckoutController", urlPatterns = {"/GetInfoCheckoutController"})
public class GetInfoCheckoutController extends HttpServlet {
    private static final String ERROR = "checkout.jsp";
    private static final String VN_PAY = "vnpay_index.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        
        try {
            String fullName = request.getParameter("fullName");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String phone = request.getParameter("phone");
            String note = request.getParameter("note");
//            String order_time = request.getParameter("order_time");
            String payment_option = request.getParameter("payment_option");
//            String newOrderID = null;
            
            HttpSession session = request.getSession();
            Cart cart = (Cart)session.getAttribute("CART");
            String loginCheck = (String)session.getAttribute("LOGIN_CHECK");
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            BookDAO productDAO = new BookDAO();
            
            boolean checkQuantityProduct = false;
            
            
             if ("vnpay".equals(payment_option)) {
//                UUID uuid = UUID.randomUUID();
//                newOrderID = uuid.toString();
                 for (CartProduct product : cart.getCart().values()) {
                    int productData = productDAO.getProductQuantity(product.getID());
                    if (product.getQuantity() <= productData) {
                        checkQuantityProduct = true;
                    }
                    else {
                        checkQuantityProduct = false;
                    }
                }
                
                if (checkQuantityProduct) {
                    ShippingInfo shippingInfo = new ShippingInfo(fullName, address, city, state, phone, note, "", 1);
                
                
                    session.setAttribute("SHIPPING_INFO", shippingInfo);
    //                request.setAttribute("ORDER_ID", newOrderID);
                    url = VN_PAY;
                }
                else {
                    url = "404.jsp";
                }
            }
            
        } 
        catch (Exception e) {
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
