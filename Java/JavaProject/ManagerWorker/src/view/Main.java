package view;

import controller.Controller;
import entity.SalaryHistory;
import entity.Worker;
import utils.Validator;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.readFile();
        do {
            System.out.println("======== Worker Management ========");
            System.out.println("1.    Add Worker\n"
                    + "2.    Up salary\n"
                    + "3.    Down salary\n"
                    + "4.    Display Information salary\n"
                    + "5.    Exit\n");
            int choice = Validator.getInt("Enter your choice: ",
                    "Please enter number 1 -> 5",
                    "Invalid!", 1, 5);
            switch (choice) {
                case 1:
                    try {
                        System.out.println("--------- "
                                + "Add Worker"
                                + "---------");
                        Worker worker = controller.addWorker();
                        System.out.println("Add successfully: \n"
                                + worker.toString());

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    controller.saveWorker();
                    break;
                case 2:
                    try {
                        System.out.println("------- "
                                + "Up Salary"
                                + " -------");
                        SalaryHistory history = controller.upSalary();
                        controller.showHistory();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    controller.saveSalaryHistory();
                    controller.saveWorker();
                    break;
                case 3:
                    try {
                        System.out.println("------- "
                                + "Down Salary"
                                + " -------");
                        SalaryHistory history = controller.downSalary();
                        controller.showHistory();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    controller.saveSalaryHistory();
                    controller.saveWorker();
                    break;
                case 4:
                    try {                 
                        controller.showHistory();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
