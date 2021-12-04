/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.controller;

import com.bookshop.orders.Order;
import com.bookshop.orders.OrderDAO;
import com.bookshop.orders.OrderDetail;
import com.bookshop.orders.ShippingInfo;
import com.bookshop.books.BookDAO;
import com.bookshop.shopping.Cart;
import com.bookshop.shopping.CartProduct;
import com.bookshop.users.UserDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "VNPayCheckoutController", urlPatterns = {"/VNPayCheckoutController"})
public class VNPayCheckoutController extends HttpServlet {
    private static final String ERROR = "checkout.jsp";
    private static final String SUCCESS = "category.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();
            String order_time = dtf.format(now);
            String responseCode = request.getParameter("vnp_ResponseCode");
            
            HttpSession session = request.getSession();
            Cart cart = (Cart)session.getAttribute("CART");
            ShippingInfo shipInfo = (ShippingInfo)session.getAttribute("SHIPPING_INFO");
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
//            String loginCheck = (String)session.getAttribute("LOGIN_CHECK");
            
//            UserDAO userDAO = new UserDAO();
            
            if ("00".equals(responseCode)) {
                
                UUID uuid = UUID.randomUUID();
                String orderID = uuid.toString();                    
                String userID = loginUser.getUserID();
                double totalPrice = cart.getTotalMoney();
                String createDate = order_time; 

                Order order = new Order(orderID, userID, totalPrice, createDate);
                OrderDAO dao = new OrderDAO();
                BookDAO productDao = new BookDAO();
                boolean check = dao.insertOrder(order);

                if (check == true) {    
                    for (CartProduct product : cart.getCart().values()) {
                        productDao.minusProduct(product.getID(), product.getQuantity());

                        UUID detailUUID = UUID.randomUUID();
                        String detailID = detailUUID.toString();
                        dao.insertOrderDetail(new OrderDetail(detailID, orderID, product.getID(), product.getPrice(), product.getQuantity()));
                    }
//
//success.jsp
                    ShippingInfo ship = new ShippingInfo(shipInfo.getFullName(), shipInfo.getAddress(), shipInfo.getCity(), shipInfo.getState(), shipInfo.getPhone(), shipInfo.getNote(), orderID, shipInfo.getStatusID());
                    boolean checkInsertShip = dao.insertShippingInfo(ship);

                    if (checkInsertShip) {
//                        SendHTMLEmail send = new SendHTMLEmail();
//                        send.sendEmail(orderID, loginUser.getEmail());
                        session.removeAttribute("CART");
                        url = SUCCESS;
                    }
                }
            }
            session.removeAttribute("SHIPPING_INFO");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(VNPayCheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(VNPayCheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
