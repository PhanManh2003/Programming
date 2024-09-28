package controller;

import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.catalina.Manager;

public class InsertServlet extends HttpServlet {

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
            out.println("<title>Servlet insertServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet insertServlet at " + request.getContextPath() + "</h1>");
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
        // get data from index.html form
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String provider = request.getParameter("provider");
        double price = Double.parseDouble(request.getParameter("price"));
        
        // add new product Object to list if id not exist
        Product product = new Product(id, name, provider, price);
        boolean isExist = false;
        for (Product x :  ManageProduct.getList()) {
            if(x.getId().equalsIgnoreCase(id)){
                isExist = true;
                break;
            } 
        }
        
        String error = null;
        if (!isExist) {
            ManageProduct.getList().add(product);
        } else {
            error = "Không thể thêm vì id đã tồn tại";
        }
        // forward the product List to list.jsp to show
        request.setAttribute("products", ManageProduct.getList());
        request.setAttribute("error", error);
        request.getRequestDispatcher("view/list.jsp").forward(request, response);

        // directory is "views/list.jsp" because it start from index
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
