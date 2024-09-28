package view;

import controller.Controller;
import entity.Task;
import utils.Validator;

public class Main {

    public static void main(String[] args) {
        Controller control = new Controller();
        do {
            System.out.println("======== Task Program ========");
            System.out.println("1.  Add Task\n"
                    + "2.  Delete Task\n"
                    + "3.  Display Task\n"
                    + "4.  Exit\n");
            int choice = Validator.getInt("Enter your choice: ",
                    "Please enter number 1 -> 4",
                    "Invalid!", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("------------Add Task--------------");
                    try {
                        int taskID = control.add();
                        System.out.println("Add successfully taskID " + taskID);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("--------Del Task--------");
                    try {
                        Task task = control.delete();
                        System.out.println("Delete successfully: ");
                        System.out.println(task);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;

                case 3:
                    try {
                        control.show();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;

            }
        } while (true);
    }

}
