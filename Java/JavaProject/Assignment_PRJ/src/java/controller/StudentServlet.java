package controller;

import dal.StudentDAO;
import dal.SubjectDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import model.Student;
import model.Subject;

/**
 *
 * @author manhpthe172481
 */
public class StudentServlet extends HttpServlet {

    private SubjectDAO sbjDAO = new SubjectDAO();
    private StudentDAO stuDAO = new StudentDAO();

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
        //*** Bỏ cái session attribute message khi CRUD ở dưới sau khi load lại
        
        // Move the message from session to request attribute
        HttpSession session = request.getSession();
        String message = (String) session.getAttribute("message");
        if (message != null) {
            request.setAttribute("message", message);
            session.removeAttribute("message");
        }
        
        //1. get về tất cả subject
        List<Subject> listSubject = sbjDAO.findAll();
        session.setAttribute("listSubject", listSubject);

        //2. Đặt giá trị MẶC ĐỊNH cho genderSelected nếu không có giá trị từ request
        String genderSelected = request.getParameter("genderFilter");
        if (genderSelected == null) {
            // Giá trị mặc định cho form select gender
            genderSelected = "both"; 
        }
        request.setAttribute("genderSelected", genderSelected);

        //3. Lấy danh sách sinh viên theo subjectID đã chọn
        List<Student> listStudent;
        if ("both".equals(genderSelected)) {
            listStudent = stuDAO.findAll();
        } else {
            listStudent = stuDAO.findBySubjectID(genderSelected);
        }
        request.setAttribute("listStudent", listStudent);

        //4. chuyển sang student.jsp
        request.getRequestDispatcher("student.jsp").forward(request, response);

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
            case "filterByGender":
                filterByGender(request, response);
                break;
            case "insert":
                insert(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            default:
                response.sendRedirect("students");
        }
    }
// ------------------------------ HÀM NGHIỆP VỤ -------------------------------

    private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        //1. get về data từ form
        String studentID = request.getParameter("code");
        String studentName = request.getParameter("name");
        String birthDateStr = request.getParameter("birthDate");
        boolean gender = "male".equals(request.getParameter("gender"));
        String subjectID = request.getParameter("subjectID");

        // 2. Validation, nếu lỗi thì comeback to jsp và thông báo  
        String validationError = validateStudent(studentID, birthDateStr);
        if (validationError != null) {
            session.setAttribute("message",
                    validationError);
            response.sendRedirect("students");
            return;
        }

        // 3. Chuyển đổi birthDateStr thành kiểu Date
        Date birthDate;
        try {
            birthDate = new SimpleDateFormat(
                    "yyyy-MM-dd").parse(birthDateStr);
        } catch (ParseException e) {
            validationError = "Invalid birth date format. Please use yyyy-MM-dd.";
            session.setAttribute("message",
                    validationError);
            response.sendRedirect("students");
            return;
        }

        // 4. Tạo đối tượng Student và thêm vào cơ sở dữ liệu
        Student newStudent = new Student();
        newStudent.setStudentID(studentID);
        newStudent.setStudentName(studentName);
        newStudent.setBirthDate(birthDate);
        newStudent.setGender(gender);
        newStudent.setSubjectID(subjectID);

        stuDAO.insertStudent(newStudent);

        // 5. Redirect về trang danh sách sinh viên
        session.setAttribute("message",
                "Insert student successfully!");
        response.sendRedirect("students");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        // 1. Get data from the request
        String studentID = request.getParameter("code");
        String studentName = request.getParameter("name");
        String birthDateStr = request.getParameter("birthDate");
        boolean gender = "male".equals(request.getParameter("gender"));
        String subjectID = request.getParameter("subjectID");

        // 2. Validate data, if there's an error, set message and redirect to students page
        String validationError = validateStudent(studentID, birthDateStr);
        if (validationError != null) {
            session.setAttribute("message", validationError);
            response.sendRedirect("students");
            return;
        }

        // 3. Convert birthDateStr to Date
        Date birthDate;
        try {
            birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDateStr);
        } catch (ParseException e) {
            validationError = "Invalid birth date format. Please use yyyy-MM-dd.";
            session.setAttribute("message", validationError);
            response.sendRedirect("students");
            return;
        }

        // 4. Create Student object and update the database
        Student updatedStudent = new Student();
        updatedStudent.setStudentID(studentID);
        updatedStudent.setStudentName(studentName);
        updatedStudent.setBirthDate(birthDate);
        updatedStudent.setGender(gender);
        updatedStudent.setSubjectID(subjectID);

        stuDAO.updateStudent(updatedStudent);

        // 5. Set success message and redirect to students page
        session.setAttribute("message", "Update student successfully!");
        response.sendRedirect("students");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession();
        // 1. get về studentID
        String studentID = request.getParameter("code");
        // 2. Xóa trong DB
        stuDAO.deleteStudent(studentID);
        // 3. Set success message and redirect to students page
        session.setAttribute("message", "Delete student successfully!");
        response.sendRedirect("students");
    }

    private void filterByGender(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. get gender data từ form dropdown
        String genderSelected = request.getParameter("genderFilter");
        
        // 2. Tìm students theo gender rồi trả về 1 list
        List<Student> listStudent;
        if ("both".equals(genderSelected)) {
            listStudent = stuDAO.findAll();
        } else {
            listStudent = stuDAO.findByGender(genderSelected);
        }
        request.setAttribute("listStudent", listStudent);
        
        // 3. request.setAttribute (genderSelected và List) rồi forward sang jsp
        request.setAttribute("genderSelected", genderSelected);
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }

// ----------------------------- HÀM VALIDATE --------------------------------
    private String validateStudent(String studentID, String birthDateStr) {
        StringBuilder errorMessage = new StringBuilder();

        // Validate student ID
        if (!studentIDValidation(studentID)) {
            errorMessage.append("Student ID must be 7 characters long.\n");
        }

        // Validate birth date
        if (!birthDateValidation(birthDateStr)) {
            errorMessage.append("Invalid birth date format. Please use yyyy-MM-dd.\n");
        } else {
            // Validate age
            if (!ageValidation(birthDateStr)) {
                errorMessage.append("Student must be at least 18 years old.\n");
            }
        }

        // Return error message if there are validation errors, otherwise return null
        return errorMessage.length() > 0 ? errorMessage.toString() : null;
    }

    private boolean studentIDValidation(String studentID) {
        return studentID.length() == 7;
    }

    private boolean birthDateValidation(String birthDateStr) {
        // Định dạng ngày sinh theo chuẩn YYYY-MM-dd
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); // Không cho phép chấp nhận ngày tháng không hợp lệ

        try {
            dateFormat.parse(birthDateStr); // Cố gắng parse chuỗi ngày tháng
            return true; // Nếu thành công thì đúng định dạng
        } catch (ParseException e) {
            return false; // Nếu có lỗi parse thì không đúng định dạng
        }
    }

    private boolean ageValidation(String birthDateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); // Không cho phép chấp nhận ngày tháng không hợp lệ
        try {
            Date birthDate = dateFormat.parse(birthDateStr);
            LocalDate today = LocalDate.now();
            LocalDate birth = birthDate.toInstant().atZone(
                    ZoneId.systemDefault()).toLocalDate();
            int age = Period.between(birth, today).getYears();
            return age > 18;
        } catch (ParseException e) {
            return false; // Nếu có lỗi parse thì không đúng định dạng
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
