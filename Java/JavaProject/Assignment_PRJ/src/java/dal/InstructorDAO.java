package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Instructor;

/**
 *
 * @author manhpthe172481
 */
public class InstructorDAO extends DBContext {

    protected PreparedStatement statement;
    protected ResultSet rs;

    public List<Instructor> findAll() {
        List<Instructor> listInstructor = new ArrayList<>();

        try {
            //    connect with DB
            connection = new DBContext().connection;
            //    Chuẩn bị câu lệnh sql
            String sql = "SELECT * FROM dbo.Instructors";
            //    Tạo đối tượng preparedStatement
            statement = connection.prepareStatement(sql);
            //    setParameter (optional)
            // thuc thi cau lenh
            rs = statement.executeQuery();
            //    Trả về kết quả
            while (rs.next()) {
                // get Data from result
                String instructorID = rs.getString("InstructorID");
                String instructorName = rs.getString("InstructorName");
                Date birthDate = rs.getDate("BirthDate");
                boolean gender = rs.getBoolean("Gender");
                String subjectID = rs.getString("SubjectID");

                // create object
                Instructor instructor = new Instructor();
                instructor.setInstructorID(instructorID);
                instructor.setInstructorName(instructorName);
                instructor.setBirthDate(birthDate);
                instructor.setGender(gender);
                instructor.setSubjectID(subjectID);

                // add to list
                listInstructor.add(instructor);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listInstructor;
    }

    public List<Instructor> findBySubjectID(String subjectID) {
        List<Instructor> listInstructor = new ArrayList<>();
        try {
            //    connect with DB
            connection = new DBContext().connection;
            //    Chuẩn bị câu lệnh sql
            String sql = "SELECT * FROM dbo.Instructors WHERE SubjectID = ?";
            //    Tạo đối tượng preparedStatement
            statement = connection.prepareStatement(sql);
            //    setParameter (optional)
            statement.setObject(1, subjectID);
            // thuc thi cau lenh
            rs = statement.executeQuery();
            //    Trả về kết quả
            while (rs.next()) {
                // get Data from result
                String instructorID = rs.getString("InstructorID");
                String instructorName = rs.getString("InstructorName");
                Date birthDate = rs.getDate("BirthDate");
                boolean gender = rs.getBoolean("Gender");
                String subjectIDfromDB = rs.getString("SubjectID");

                // create object
                Instructor instructor = new Instructor();
                instructor.setInstructorID(instructorID);
                instructor.setInstructorName(instructorName);
                instructor.setBirthDate(birthDate);
                instructor.setGender(gender);
                instructor.setSubjectID(subjectIDfromDB);

                // add to list
                listInstructor.add(instructor);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listInstructor;
    }
}
