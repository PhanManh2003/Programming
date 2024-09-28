package business;

import entity.Task;
import static jdk.nashorn.internal.parser.TokenType.REGEX;
import utils.Validator;

public class TaskInputter {

    private Task task;

    public TaskInputter() {
        task = new Task();
    }

    public Task input() {
        task.setRequirementName(Validator.getString("Requirement Name: ",
                "Invalid", "[A-Za-z0-9\\s]+"));
        task.setTaskTypeID(Validator.getInt("Task Type: ",
                "Only 1 -> 4", "Invalid", 1, 4));
        task.setDate(Validator.getDate("Date: ", "Invalid!"
                + " Please enter format: dd-MM-yyyy", "dd-MM-yyyy"));
        while (true) {
            task.setPlanFrom(Validator.getDouble("From: ", "Just 8 -> 17",
                    "Invalid", 8, 17));
            String from = task.getPlanFrom() + "";
            if (from.split("\\.")[1].equals("0") || from.split("\\.")[1].equals("5")) {
                break;
            } else {
                System.out.println("From must be h.0 or h.5");
            }
        }
        while (true) {
            task.setPlanTo(Validator.getDouble("To: ", "Just" + (task.getPlanTo() + 0.5)
                    + " -> 17.5", "Invalid", (task.getPlanTo() + 0.5), 17.5));
            String to = task.getPlanTo() + "";
            if (to.split("\\.")[1].equals("0") || to.split("\\.")[1].equals("5")) {
                break;
            } else {
                System.out.println("To must be h.0 or h.5");
            }
        }
        task.setAssignee(Validator.getString("Assignee: ", "Invalid", 
                "[A-Za-z0-9\\s]+"));
        task.setReviewer(Validator.getString("Reviewer: ","Invalid", 
                "[A-Za-z0-9\\s]+"));
        return task;

    }

}
