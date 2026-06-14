package fa.training.entities;

// ExperienceCandidate has more attributes: years’ experience, professional skill
import java.util.Date;

public class ExperienceCandidate extends Candidate {

    private static final long serialVersionUID = 1L;

    private int yearsExperience;
    private String professionalSkill;

//    constructors 
    public ExperienceCandidate() {
        super();
    }

    public ExperienceCandidate(String firstName, String lastName, Date birthDate,
            String address, String phone, String email,
            int yearsExperience, String professionalSkill) {
        super(firstName, lastName, birthDate, address, phone, email);
        this.yearsExperience = yearsExperience;
        this.professionalSkill = professionalSkill;
    }
//getter setter

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public String getProfessionalSkill() {
        return professionalSkill;
    }

    public void setProfessionalSkill(String professionalSkill) {
        this.professionalSkill = professionalSkill;
    }

    @Override
    public String toString() {
        return "ExperienceCandidate{" + super.toString()
                + "yearsExperience=" + yearsExperience + ", "
                + "professionalSkill=" + professionalSkill + '}';
    }

}
