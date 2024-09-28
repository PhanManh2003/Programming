package model;

import java.util.Date;

public class Instructor {

    private String instructorID;
    private String instructorName;
    private Date birthDate;
    private boolean gender;
    private String subjectID;

    public Instructor() {
    }

    public Instructor(String instructorID, String instructorName, Date birthDate, boolean gender, String subjectID) {
        this.instructorID = instructorID;
        this.instructorName = instructorName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.subjectID = subjectID;
    }

    public String getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(String instructorID) {
        this.instructorID = instructorID;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

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
    
}
