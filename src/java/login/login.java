package login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import beans.UserAuth;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet.Authenticator;

/**
 *
 * @author Rome10
 */
public class login extends HttpServlet {

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
        
        UserAuth ua = (UserAuth) request.getSession().getAttribute("UserAuth");
       
        if (null==ua || ua.getAuthStatus() !=  0) {
              new LoggerAction().exe
        }
        
        if (ua.getAuthStatus() ==  0 && ua.getLogCount() < 3) {           
            this.getServletContext().getRequestDispatcher("/iFaceAuthOk.jsp").forward(request, response);
        } else {
            String username = request.getParameter("user");
            String pass = request.getParameter("password");

                
            request.getSession().setAttribute("UserAuth", ua);
            
            ua.setUsername(username);
            ua.setAuthStatus(Authenticator.verifyCredentials(ua.getUsername(), pass));
            ua.setLogCount(ua.getLogCount()+1);
            
            if (ua.getAuthStatus() == 0) {
                this.getServletContext().getRequestDispatcher("/iFaceAuthOk.jsp").forward(request, response);
            } else {
                this.getServletContext().getRequestDispatcher("/formLogin.jsp").forward(request, response);
            }
        
        
        
            
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

   