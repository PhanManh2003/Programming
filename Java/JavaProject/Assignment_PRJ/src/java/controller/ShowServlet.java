package controller;

import dal.InstructorDAO;
import dal.SubjectDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.Instructor;
import model.Subject;

/**
 *
 * @author manhpthe172481
 */
public class ShowServlet extends HttpServlet {

    private SubjectDAO sbjDAO = new SubjectDAO();
    private InstructorDAO insDAO = new InstructorDAO();

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
            out.println("<title>Servlet ListServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListServlet at " + request.getContextPath() + "</h1>");
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
        //1. get ve tat ca subject
        List<Subject> listSubject = sbjDAO.findAll();
        // set Attribute
        request.getSession().setAttribute("listSubject", listSubject);

        //2. Đặt giá trị mặc định cho subjectIDChoosen nếu không có giá trị từ request
        String subjectIDChoosen = request.getParameter("subjectID");
        if (subjectIDChoosen == null) {
            // Giá trị mặc định cho "Connecting to CS"
            subjectIDChoosen = "0"; // Thay thế "defaultSubjectID" bằng ID thực của môn học "Connecting to CS"
        }
        request.setAttribute("subjectIDChoosen", subjectIDChoosen);

        //3. Lấy danh sách sinh viên theo subjectID đã chọn
        List<Instructor> listInstructor;
        if ("0".equals(subjectIDChoosen)) {
            listInstructor = insDAO.findAll();
        } else {
            listInstructor = insDAO.findBySubjectID(subjectIDChoosen);
        }
        request.setAttribute("listInstructor", listInstructor);

        //4. chuyen sang list.jsp
        request.getRequestDispatcher("instructor.jsp").forward(request, response);

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
        String action = request.getParameter("action") == null ? ""
                : request.getParameter("action");
        switch (action) {
            case "searchBySubject":
                // get ve subject id
                String subjectID = request.getParameter("subjectID");
                // Tim kieu instructor theo subject id roi tra ve 1 list
                List<Instructor> listInstructor;
                if ("0".equals(subjectID)) {
                    listInstructor = insDAO.findAll();
                } else {
                    listInstructor = insDAO.findBySubjectID(subjectID);
                }
                request.setAttribute("listInstructor", listInstructor);
                // forward to jsp
                request.setAttribute("subjectIDChoosen", subjectID);
                request.getRequestDispatcher("instructor.jsp").forward(
                        request, response);
                break;
            default:
                response.sendRedirect("show");
        }
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
