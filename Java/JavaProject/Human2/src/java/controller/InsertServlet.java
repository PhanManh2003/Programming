/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Human;
import model.HumanType;

/**
 *
 * @author PC
 */
@WebServlet(name="InsertServlet", urlPatterns={"/Insert"})
public class InsertServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("create.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            String dob = request.getParameter("dob");
            int typeid = Integer.parseInt(request.getParameter("typeid"));
            
            Human h = new Human();
            h.setID(id);
            h.setName(name);
            h.setGender(gender.equals("Male")?true:false);
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            h.setDob(formatter.parse(dob));
            
            HumanType ht = new HumanType();
            ht.setTypeID(typeid);
            h.setType(ht);
            
            DBContext db = new DBContext();
            int i = db.insertHuman(h);
            PrintWriter out = response.getWriter();
            if (i == 0){
                out.print("Them khong thanh cong!");
            }
            else{
                out.print("Them thanh cong");
            }
        } catch (ParseException ex) {
            Logger.getLogger(InsertServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
