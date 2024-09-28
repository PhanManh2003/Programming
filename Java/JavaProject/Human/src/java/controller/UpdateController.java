/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Human;
import model.HumanType;


/**
 *
 * @author manhpthe172481
 */
public class UpdateController extends HttpServlet {

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
            out.println("<title>Servlet UpdateController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateController at " + request.getContextPath() + "</h1>");
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
        DBContext db = new DBContext();
        ArrayList<Human> humans = db.getHumans();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Ensure format matches input
        // get data
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        Date dob = null;
        try {
            String dobStr = request.getParameter("dob");
            dob = dateFormat.parse(dobStr);
        } catch (ParseException ex) {
            Logger.getLogger(InsertController.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        int type = Integer.parseInt(request.getParameter("type"));
            // Create a new Human object and set its properties
        Human newHuman = new Human();
        newHuman.setID(id);
        newHuman.setName(name);
        newHuman.setDob(dob);
        newHuman.setGender(gender);

        HumanType humanType = new HumanType();
        humanType.setTypeiD(type);
        newHuman.setType(humanType);
          // Update the newHuman into the database
        db.updateHuman(newHuman);
        
        // Give the new human arraylist back
        ArrayList<Human> newHumans = db.getHumans();

        // Redirect to the list page
        request.setAttribute("humans", newHumans);
        request.getRequestDispatcher("list.jsp").forward(request, response);
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
