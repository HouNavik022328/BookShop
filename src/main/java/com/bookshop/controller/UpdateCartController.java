/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookshop.controller;

import com.bookshop.books.BookDAO;
import com.bookshop.books.BookDTO;
import com.bookshop.shopping.Cart;
import com.bookshop.shopping.CartProduct;
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
@WebServlet(name = "UpdateCartController", urlPatterns = {"/UpdateCartController"})
public class UpdateCartController extends HttpServlet {
    private static final String ERROR = "cart.jsp";
    private static final String SUCCESS = "cart.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String ID = request.getParameter("ID");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            
            BookDAO dao = new BookDAO();
            BookDTO productDTO = dao.getProductForCart(ID);
            
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            CartProduct product = new CartProduct();
            
            for (CartProduct item : cart.getCart().values()) {
                if (item.getID().equals(ID)) {
                    String productName = item.getName();
                    String productImage = item.getImage();
                    int price = item.getPrice();
                    
                    if (quantity <= productDTO.getQuantity()) {
                        product = new CartProduct(ID, productName, price, productImage, quantity);
                    }
                    else {
                        product = new CartProduct(ID, productName, price, productImage, productDTO.getQuantity());
                        session.setAttribute("ERROR_CART", "Quantity of product " + product.getName()+ " is still : " + productDTO.getQuantity());
                    }
                    break;
                }
            }
            
            if (cart != null) {
                cart.updateCart(ID, product);
                session.setAttribute("CART", cart);
                url = SUCCESS;
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
