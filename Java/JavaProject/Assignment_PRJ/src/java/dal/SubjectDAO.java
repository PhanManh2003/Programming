package dal;

import java.util.List;
import model.Subject;
import java.sql.*;
import java.util.ArrayList;

public class SubjectDAO extends DBContext {

    protected PreparedStatement statement;
    protected ResultSet rs;

    public List<Subject> findAll() {
        List<Subject> listSubject = new ArrayList<>();

        try {
            //    connect with DB
            connection = new DBContext().connection;
            //    Chuẩn bị câu lệnh sql
            String sql = "SELECT * FROM dbo.Subjects";
            //    Tạo đối tượng preparedStatement
            statement = connection.prepareStatement(sql);
            //    setParameter (optional)
            //    executeQuery
            rs = statement.executeQuery();
            //    Trả về kết quả
            while (rs.next()) {
                String subjectID = rs.getString("SubjectID");
                String subjectName = rs.getString("SubjectName");

                Subject subject = new Subject();
                subject.setSubjectID(subjectID);
                subject.setSubjectName(subjectName);
                listSubject.add(subject);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listSubject;
    }
    
    
}
