package controller;

import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentController extends HttpServlet {

    ManageStudent manage = new ManageStudent();

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
            out.println("<title>Servlet StudentController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentController at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");
        List<Student> list = null;
        switch (action) {
            case "insert":
                insert(request, response);
                list = manage.getList();
                break;
            case "update":
                update(request, response);
                list = manage.getList();
                break;
            case "delete":
                delete(request, response);
                list = manage.getList();
                break;
            case "search":
                list = search(request, response);
                break;
            default:
        }
        // Chuyển hướng lại về trang home Controller
        request.setAttribute("list", list);
        request.getRequestDispatcher("home").forward(request, response);

    }

    private void insert(HttpServletRequest request, HttpServletResponse response) {
        //get ra thong tin
        String id = request.getParameter("id").trim();
        String name = request.getParameter("name").trim();
        boolean gender = request.getParameter("gender").equalsIgnoreCase("male");
        int age = Integer.parseInt(request.getParameter("age").trim());
        String[] hobbies_raw = request.getParameterValues("hobbies");
        List<String> listHobbies = new ArrayList<>(Arrays.asList(hobbies_raw));

        //tao doi tuong Student
        Student student = new Student(id, name, age, gender, listHobbies);

        //them vao ben trong list 
        manage.add(student);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id").trim();
        String name = request.getParameter("name").trim();
        boolean gender = request.getParameter("gender").equalsIgnoreCase("male");
        int age = Integer.parseInt(request.getParameter("age").trim());
        String[] hobbies_raw = request.getParameterValues("hobbies");
        List<String> listHobbies = new ArrayList<>(Arrays.asList(hobbies_raw));

        //tao doi tuong Student
        Student student = new Student(id, name, age, gender, listHobbies);
        manage.update(student);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id").trim();
        //xoa
        manage.delete(id);
    }

    private List<Student> search(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("keyword").trim() == null
                ? "" : request.getParameter("keyword").trim();
        List<Student> list = manage.search(keyword);
        return list;
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
