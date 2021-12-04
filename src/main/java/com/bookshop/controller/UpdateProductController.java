
package com.bookshop.controller;

import com.bookshop.books.BookDAO;
import com.bookshop.books.BookDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "UpdateProductController", urlPatterns = {"/UpdateProductController"})
public class UpdateProductController extends HttpServlet {
    private static final String ERROR = "admin-product.jsp";
    private static final String SUCCESS = "admin-product.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        
        try {
            String ID = request.getParameter("ID");
            String name = request.getParameter("name");
            String image = request.getParameter("image");
            String description = request.getParameter("description");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int price = Integer.parseInt(request.getParameter("price"));
            int categoryID = Integer.parseInt(request.getParameter("categoryID"));
            int typeID = Integer.parseInt(request.getParameter("typeID"));
            String createDate = request.getParameter("createDate");
            String author = request.getParameter("author");

            BookDTO product = new BookDTO(ID, name, description, author, price, createDate, image, categoryID, typeID, quantity);
            BookDAO dao = new BookDAO();
            boolean check = dao.updateProduct(product);
            
            if (check) {
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
