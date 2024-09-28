package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Student {

    private String studentID;
    private String studentName;
    private Date birthDate;
    private int age;
    private boolean gender;
    private String subjectID;

    public Student() {
    }

    public Student(String studentID, String studentName, Date birthDate,
            boolean gender, String subjectID) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.subjectID = subjectID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Date birthDate) {
        LocalDate today = LocalDate.now();
        LocalDate birth = birthDate.toInstant().atZone(
                ZoneId.systemDefault()).toLocalDate();
        this.age = Period.between(birth, today).getYears();
    }

    // no need for set Age because there is no age attribute
    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", studentName="
                + studentName + ", birthDate=" + birthDate + ", gender="
                + gender + ", subjectID=" + subjectID + '}';
    }
}
