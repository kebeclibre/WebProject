/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import be.bt.model.Book;
import be.bt.model.dao.LibraryDAO;
import beans.BookBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import login.ShopCart;

/**
 *
 * @author rome10
 */
public class AddBookToCart extends HttpServlet {

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
        
        ShopCart sc = (ShopCart) request.getSession().getAttribute("ShopCart");
        
        if (null == sc) {
            sc = new ShopCart();
            request.getSession().setAttribute("ShopCart", sc);
        }
        
        
        String[] recup = request.getParameterValues("bookToAdd");
        
        if (null != recup) {
            for (String isbn : recup) {
                Book b =  LibraryDAO.getInstance().getBookByIsbn(isbn);
                BookBean bb = new BookBean();
                bb.setIsbn(isbn);
                bb.setTitle(b.getTitle());
                bb.setPrice(b.getPrice());
                sc.addBook(bb);
            }     
        }
        
        request.getRequestDispatcher("DisplayCart.jsp").forward(request, response);
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
