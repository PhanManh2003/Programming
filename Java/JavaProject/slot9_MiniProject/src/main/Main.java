 package main;

import management.IStudent;
import management.StudentManager;
import validate.Validator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author manhpthe172481
 */
public class Main {

    public static void main(String[] args) {
        int choice;
        IStudent manager = new StudentManager();
        manager.readFile();
        do {
            System.out.println("-------APP MANAGER STUDENT-------");
            System.out.println("1.Add student\n"
                    + "2.Remove student\n"
                    + "3.Update score\n"
                    + "4.Display list\n"
                    + "5.Search for student\n"
                    + "6.Sort list\n"
                    + "7.Save to file\n"
                    + "8.EXIT\n"
            );
            choice = Validator.getInt("Enter your choice: ",
                    "Please enter number 1 to 8",
                    "Please enter integer number", 1, 8);

            switch (choice) {
                case 1:
                    manager.addStudent();
                    break;
                case 2:
                    manager.removeStudent();
                    break;
                case 3:
                    manager.updateScore();
                    break;
                case 4:
                    manager.displayList();
                    break;
                case 5:
                    manager.searchStudentByName();
                    break;
                case 6:
                    manager.sortStudentByScore();
                    break;
                case 7:
                    manager.writeFile();
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

            }
        } while (true);

    }
}
