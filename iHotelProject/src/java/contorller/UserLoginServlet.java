/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contorller;

import database.DBUserLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserLogin;

/**
 *
 * @author hani
 */
@WebServlet(name = "UserLoginServlet", urlPatterns = {"/UserLoginServlet"})
public class UserLoginServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserLoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            
            //define var 
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
  
            // validate if it is NULL
            if (email == ""  ||email.equals("") || pass == "" || pass.equals("")) {
                out.print("Please fill the text box");
                return;
            }

            // get order from session
            UserLogin userlogin = (UserLogin) request.getSession().getAttribute("userlogin");
            if (userlogin == null) { // if client does not exist in the session
                try {
                    userlogin = DBUserLogin.getClientByEmail(email);
                    if (userlogin != null) {
                        if (userlogin.getPassword().equals(pass)) {//pass match

                            // save selected client in the session (on the server) 
                            request.getSession().setAttribute("userlogin", userlogin); // put userlogin into the session

                        } else {//dont match
                            out.print("Password is not match.");
                            return;
                        }

                    } else {//dont match
                        out.print("Email doens not exist.");
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    out.print(e.getMessage());return;
                }

            }

            if(userlogin.getType().equals("admin")){
                request.getRequestDispatcher("AdminPageServlet").forward(request, response);
                return;
            } else {
                // forward user to the confirmform.jsp
                request.getRequestDispatcher("BookingServlet").forward(request, response);               
            }
            
            
            out.println("</body>");
            out.println("</html>");
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
