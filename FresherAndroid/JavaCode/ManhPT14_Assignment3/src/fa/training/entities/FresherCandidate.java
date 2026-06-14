package fa.training.entities;
//  FresherCandidate has more attributes: graduation date, graduation rank, education

import java.util.Date;

public class FresherCandidate extends Candidate {

    private static final long serialVersionUID = 1L;
    private Date graduationDate;
    private String graduationRank;
    private String education;

    // constructor
    public FresherCandidate() {
        super();
    }

    public FresherCandidate(String firstName, String lastName,
            Date birthDate, String address, String phone, String email,
            Date graduationDate, String graduationRank, String education) {
        super(firstName, lastName, birthDate, address, phone, email);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }
    //getter setter

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "FresherCandidate{" + "graduationDate=" +
                graduationDate + ", graduationRank=" + 
                graduationRank + ", education=" + education + '}';
    }

}
