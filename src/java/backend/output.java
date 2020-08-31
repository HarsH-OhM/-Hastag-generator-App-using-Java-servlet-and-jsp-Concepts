/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Harsh
 */
@WebServlet(name = "output", urlPatterns = {"/output"})
public class output extends HttpServlet {

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
           
                   
            //out.println("Welcome to servlet Programming");
            
//write the code here to recieve the data..
    
        //working with Integers..
        
//        int age = Integer.parseInt(request.getParameter("agetxt"));
//        
        String username = request.getParameter("usertxt");
        String password = request.getParameter("passtxt");
        
        //Authentication
        
        if  ((username.equals("lpu") && password.equals("lpu123"))){
            out.println("<h2>Login Success!</h2>");
        }
        else{
               out.println("<h2>Login Failure! Please try again..</h2>");
           }
    
        //how to store the data using cookies...
        
            Cookie c1 = new Cookie("uname",username);
            Cookie c2 = new Cookie("pass",password);
            
            c1.setMaxAge(60*60);
            c2.setMaxAge(60*60); //60 sec * 60 minutes
            
            response.addCookie(c1);
            response.addCookie(c2);
           
            out.println("Your Details have been saved in Cookies");
            out.println("<br/>");
            out.println("<a href='getdetails'> Get My Details </a>");
             out.println("<br/>");
            out.println("<a href='Tag.html'> Want to Try #HashTag Generatior App...Click Here.</a>");
            

            
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
