/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import be.bt.model.Author;
import be.bt.model.Book;
import be.bt.model.Library;
import be.bt.model.dao.LibraryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rome10
 */
public class allBooksServ extends HttpServlet {

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
                    
            Library lib = new Library();
            List<Book> allBooks = lib.getAllBooks();
        
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet allBooksServ</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>All Books Bitch !</h1>");
            out.println("<form action=\"AddBookToCart\" method=\"POST\" />");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>Author</td>");
            out.println("<td>Title</td>");
            out.println("<td>ISBN</td>");
            out.println("<td>Price</td>");
            out.println("<td>Details</td>");
            out.println("</tr>");
            
            for (Book b : allBooks) {
                out.println("<tr>");
                out.println("<td>");
                Set<Author> auths = b.getAuthors();
                for (Author auth : auths) {
                    out.println(auth.getLastname()+", "+auth.getFirstname()+"; ");
                }
                out.println("</td>");
                out.println("<td>"+b.getTitle()+"</td>");
                out.println("<td>"+b.getIsbn()+"</td>");
                out.println("<td>"+b.getPrice()+"</td>");
                String isbn = b.getIsbn();
                out.println("<td><a href=\"viewAuthors?isbn="+isbn+"\">View Auth</a></td>");
                out.println("<td><input type=\"checkbox\" name=\"bookToAdd\" value=\""+isbn+"\" /></td>");
                out.println("</tr>");
            }
             out.println("</table>");
           out.println("<input type=\"submit\" value=\"Submit\"/>");
             out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
