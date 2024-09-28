package business;

import entity.Candidate;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import java.util.ArrayList;
import java.util.Calendar;
import utils.Validator;

public class ManagerCandidate {

    // create Candidate
    public static void createCandidate(ArrayList<Candidate> candidates,
            int type) {
        //loop until user don't want to create new candidate
        while (true) {
            String id = Validator.getString("ID: ", "Invalid", "[A-Za-z0-9]+");
            String firstName = Validator.getString("First Name: ", "Invalid!", "[A-Za-z\\s]+");
            String lastName = Validator.getString("First Name: ", "Invalid!", "[A-Za-z\\s]+");
            int birthDate = Validator.getInt("Birth Date:", lastName, lastName,
                    1900, Calendar.getInstance().get(Calendar.YEAR));
            String address = Validator.getString("Address: ", "Invalid!", "[a-zA-z0-9\\s]+");
            System.out.print("Enter phone: ");
            String phone = Validator.getString("Phone: ", "Must >= 10 digit", "\\d{10}\\d*");
            System.out.print("Enter email: ");
            String email = Validator.getString("Email: ", "Example: annguyen@fpt.edu.vn", 
                    "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$");
            Candidate candidate = new Candidate(id, firstName, lastName,
                    birthDate, address, phone, email, type);
            //check id exist or not
            if (Validator.checkIdExist(candidates, id)) {
                switch (type) {
                    case 0:
//                        createExperience(candidates, candidate);
                        break;
                    case 1:
//                        createFresher(candidates, candidate);
                        break;
                    case 2:
//                        createInternship(candidates, candidate);
                        break;
                }
            } 
            String opinion = Vali
             
        }
    }
    // create Experience

    // create Fresher
    // create Intern
}
