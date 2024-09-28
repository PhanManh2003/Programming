package dal;

import java.util.ArrayList;
import java.util.List;
import model.Student;
import java.sql.*;
import java.util.Collections;
import java.util.Comparator;

public class StudentDAO extends DBContext {

    protected PreparedStatement statement;
    protected ResultSet rs;

    public List<Student> findAll() {
        List<Student> listStudent = new ArrayList<>();

        try {
            //    connect with DB
            connection = new DBContext().connection;
            //    Prepare SQL statement
            String sql = "SELECT * FROM dbo.Students";
            //    Create preparedStatement
            statement = connection.prepareStatement(sql);
            //    Execute query
            rs = statement.executeQuery();
            //    Process result set
            while (rs.next()) {
                // get Data from result
                String studentID = rs.getString("StudentID");
                String studentName = rs.getString("StudentName");
                Date birthDate = rs.getDate("BirthDate");
                boolean gender = rs.getBoolean("Gender");
                String subjectID = rs.getString("SubjectID");

                // create object
                Student student = new Student();
                student.setStudentID(studentID);
                student.setStudentName(studentName);
                student.setBirthDate(birthDate); // Convert to java.util.Date
                student.setAge(new java.util.Date(birthDate.getTime())); // Convert to java.util.Date
                student.setGender(gender);
                student.setSubjectID(subjectID);

                // add to list
                listStudent.add(student);
            }
            Collections.sort(listStudent, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getAge() - o2.getAge();
                }
            });
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listStudent;
    }

    public List<Student> findByGender(String genderSelected) {
        List<Student> listStudent = new ArrayList<>();
        try {
            // Connect with DB
            connection = new DBContext().connection;

            // Prepare SQL statement
            String sql = "SELECT * FROM dbo.Students WHERE Gender = ?";

            // Create preparedStatement
            statement = connection.prepareStatement(sql);

            // Set parameters
            boolean genderValue = "male".equalsIgnoreCase(genderSelected);
            statement.setObject(1, genderValue);

            // Execute query
            rs = statement.executeQuery();

            // Process result set
            while (rs.next()) {
                // get Data from result
                String studentID = rs.getString("StudentID");
                String studentName = rs.getString("StudentName");
                Date birthDate = rs.getDate("BirthDate");
                boolean gender = rs.getBoolean("Gender");
                String subjectID = rs.getString("SubjectID");

                // create object
                Student student = new Student();
                student.setStudentID(studentID);
                student.setStudentName(studentName);
                student.setBirthDate(birthDate); // Convert to java.util.Date
                student.setAge(new java.util.Date(birthDate.getTime())); // Convert to java.util.Date
                student.setGender(gender);
                student.setSubjectID(subjectID);

                // add to list
                listStudent.add(student);
            }
            Collections.sort(listStudent, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getAge() - o2.getAge();
                }
            });
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listStudent;
    }

    public List<Student> findBySubjectID(String subjectID) {
        List<Student> listStudent = new ArrayList<>();
        try {
            //    connect with DB
            connection = new DBContext().connection;
            //    Prepare SQL statement
            String sql = "SELECT * FROM dbo.Students WHERE SubjectID = ?";
            //    Create preparedStatement
            statement = connection.prepareStatement(sql);
            //    Set parameters
            statement.setObject(1, subjectID);
            //    Execute query
            rs = statement.executeQuery();
            //    Process result set
            while (rs.next()) {
                // get Data from result
                String studentID = rs.getString("StudentID");
                String studentName = rs.getString("StudentName");
                Date birthDate = rs.getDate("BirthDate"); // return a java.sql.Date
                boolean gender = rs.getBoolean("Gender");
                String subjectIDfromDB = rs.getString("SubjectID");

                // create object
                Student student = new Student();
                student.setStudentID(studentID);
                student.setStudentName(studentName);
                student.setBirthDate(birthDate); // Convert to java.util.Date
                student.setAge(new java.util.Date(birthDate.getTime())); // Convert to java.util.Date
                student.setGender(gender);
                student.setSubjectID(subjectIDfromDB);

                // add to list
                listStudent.add(student);
            }
            Collections.sort(listStudent, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getAge() - o2.getAge();
                }
            });
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return listStudent;
    }

    // insert
    public void insertStudent(Student student) {
        try {
            connection = new DBContext().connection;
            String sql = "INSERT INTO dbo.Students (StudentID, StudentName, "
                    + "BirthDate, Gender, SubjectID) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, student.getStudentID());
            statement.setObject(2, student.getStudentName());
            statement.setObject(3, new java.sql.Date(student.getBirthDate().getTime()));
            statement.setObject(4, student.isGender());
            statement.setObject(5, student.getSubjectID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    // update

    public void updateStudent(Student student) {
        try {
            connection = new DBContext().connection;
            String sql = "UPDATE dbo.Students SET StudentName = ?, BirthDate = ?, "
                    + "Gender = ?, SubjectID = ? WHERE StudentID = ?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, student.getStudentName());
            statement.setObject(2, new java.sql.Date(student.getBirthDate().getTime()));
            statement.setObject(3, student.isGender());
            statement.setObject(4, student.getSubjectID());
            statement.setObject(5, student.getStudentID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    // delete
    public void deleteStudent(String studentID) {
        try {
            connection = new DBContext().connection;
            String sql = "DELETE FROM dbo.Students WHERE StudentID = ?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, studentID);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
