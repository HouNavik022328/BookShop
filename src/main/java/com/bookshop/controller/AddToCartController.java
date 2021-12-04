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
@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCartController"})
public class AddToCartController extends HttpServlet {
    private static final String ERROR = "category.jsp";
    private static final String SUCCESS = "category.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        
        try {
            String ID = request.getParameter("ID");
            int quantity = 1;
            
            BookDAO dao = new BookDAO();
            BookDTO book = dao.getProductForCart(ID);
            
            String name = book.getName();
            int price = book.getPrice();
            String image = book.getImage();
            
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            
            if (cart == null) {
                cart = new Cart();
            }
            
            if (cart.getCart() != null) {
                    CartProduct item = null;
                    for (CartProduct checkItem : cart.getCart().values()) {
                        if (checkItem.getID().equals(ID)) {
                            item = checkItem;
                        }
                    }
                
                    if (item != null) {
                        if ((quantity + item.getQuantity()) <= book.getQuantity()) {
                            item.setQuantity(quantity + item.getQuantity());
                        }
                        else {
                            item.setQuantity(book.getQuantity());
                        }
                    }
                    else {
                        if (quantity <= book.getQuantity()) {
                            CartProduct cartProduct = new CartProduct(ID, name, price, image, quantity);
                            cart.addToCart(cartProduct);
                            session.setAttribute("CART", cart);
                            url = SUCCESS;
                        }
                }
                if (cart.getCart().size() == 0) {
                    if (quantity <= book.getQuantity()) {
                        CartProduct cartProduct = new CartProduct(ID, name, price, image, quantity);
                        cart.addToCart(cartProduct);
                        session.setAttribute("CART", cart);
                        url = SUCCESS;
                    }
                }
            }
            else {
                if (quantity <= book.getQuantity()) {
                    CartProduct cartProduct = new CartProduct(ID, name, price, image, quantity);
                    cart.addToCart(cartProduct);
                    session.setAttribute("CART", cart);
                    url = SUCCESS;
                }
                else {
                    request.setAttribute("ERROR_CART", "Quantity of product "+ book.getName()+ " available " + book.getQuantity());
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
