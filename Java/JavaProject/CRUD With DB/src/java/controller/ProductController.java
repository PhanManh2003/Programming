package controller;

import dal.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ProductController extends HttpServlet {

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
            out.println("<title>Servlet ProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductController at " + request.getContextPath() + "</h1>");
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

        ProductDAO dao = new ProductDAO();
        HttpSession session = request.getSession();
        List<Product> listProduct = (List<Product>) session.getAttribute("listProduct");
        // kiem tra xem co list product o trong session khong

        // TH1: k co listProduct trong session
        if (listProduct == null) {
            // get toàn bộ dữ liệu từ sp với ProductDAO
            listProduct = dao.findAll();
        }

        // set dữ liệu và pass cho list.jsp
        session.setAttribute("listProduct", listProduct);
        request.getRequestDispatcher("list.jsp").forward(request, response);
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
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        List<Product> listProduct = null;
        switch (action) {
            case "search":
                listProduct = searchProduct(request, response);
                break;
            case "insert":
                listProduct = insert(request, response);
                break;
            case "update":
                listProduct = update(request, response);
                break;
            case "delete":
                listProduct = delete(request, response);
                break;
            default:
                throw new AssertionError();
        }
        // set sesssion Attribute
        request.getSession().setAttribute("listProduct", listProduct);
        response.sendRedirect("product"); // chuyển về do get
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

    private List<Product> searchProduct(HttpServletRequest request, HttpServletResponse response) {
        // get keyword
        String keyword = request.getParameter("keyword").trim() == null
                ? "" : request.getParameter("keyword").trim();

        // dựa vào keyword để tìm kiếm và trả về list product
        ProductDAO dao = new ProductDAO();
        List<Product> listProduct = dao.findByName(keyword);

        return listProduct;
    }

    private List<Product> insert(HttpServletRequest request, HttpServletResponse response) {
        ProductDAO dao = new ProductDAO();
        // get ve data
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        // tao doi tuong product
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);

        // insert vao trong DB
        dao.insert(product);
        // lay toan bo du lieu Product ve roi return
        return dao.findAll();
    }

    private List<Product> update(HttpServletRequest request, HttpServletResponse response) {
        // get ve data tu form update
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        // tao doi tuong Product
        Product product = new Product(id, name, quantity, price);
        // goi ProductDao va update
        ProductDAO dao = new ProductDAO();
        dao.update(product);
        // lay toan bo du lieu Product ve roi return 
        return dao.findAll();
    }

    private List<Product> delete(HttpServletRequest request, HttpServletResponse response) {
        // get data
        int id = Integer.parseInt(request.getParameter("id"));
        
        // Tạo đôi tượng product làm đối số hàm
        Product product = new Product();
        product.setId(id);
        // delete trong Db
        ProductDAO dao = new ProductDAO();
        dao.delete(product);
        // lay toan bo du lieu Product ve roi return 
        return dao.findAll();
    }

}
