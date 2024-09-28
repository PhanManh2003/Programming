
package management;

import info.Student;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import validate.Validator;

public class StudentManager implements IStudent {

    private ArrayList<Student> listStudent = new ArrayList<>();

    @Override
    public void addStudent() {
        Student student = new Student();
        student.getInformation(listStudent);
        listStudent.add(student);
        System.out.println("Add student successfully!");
    }

    @Override
    public void removeStudent() {
        // check empty list
        if (listStudent.isEmpty()) {
            System.out.println("Student list is empty!");
            return;
        }
        String ID = Validator.getString("Enter ID to remove: ",
                "Please enter non-empty ID!", "^(?!\\s*$).+");
        // tìm ID và xóa
        boolean isExist = false;
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getID().equals(ID)) {
                isExist = true;
                listStudent.remove(i);
            }
        }
        if (isExist) {
            System.out.println("Remove succesfully !");
        } else {
            System.out.println("This ID not found! REMOVE FAIL !");
        }
    }

    @Override
    public void updateScore() {
        // check empty list
        if (listStudent.isEmpty()) {
            System.out.println("Student list is empty!");
            return;
        }
        String ID = Validator.getString("Enter ID to update score: ",
                "Please enter non-empty ID!", "^(?!\\s*$).+");
        // tìm ID và update
        boolean isExist = false;
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getID().equals(ID)) {
                isExist = true;
                System.out.println("Old score: " + listStudent.get(i).getScore());
                double newScore = Validator.getDouble("Enter score: ",
                        "Please enter score 0-10!",
                        "Enter a real number!", 0, 10);;
                listStudent.get(i).setScore(newScore);
            }
        }
        if (isExist) {
            System.out.println("Update succesfully !");
        } else {
            System.out.println("This ID not found! UPDATE FAIL !");
        }
    }

    @Override
    public void displayList() {
        if (listStudent.isEmpty()) {
            System.out.println("Student list is empty!");
            return;
        }

        System.out.println("|STT|   ID   |       NAME        | AGE | SCORE |");
        for (int i = 0; i < listStudent.size(); i++) {
            System.out.printf("|%3d|%8s|%19s|%5d|%7.1f|\n", (i + 1),
                    listStudent.get(i).getID(),
                    listStudent.get(i).getName(),
                    listStudent.get(i).getAge(),
                    listStudent.get(i).getScore());
        }
    }

    @Override
    public void searchStudentByName() {
        if (listStudent.isEmpty()) {
            System.out.println("Student list is empty!");
            return;
        }
        String name = Validator.getString("Enter name: ",
                "Name cannot be empty!", "^(?!\\s*$).+");

        boolean isExist = false;
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.printf("|%3d|%8s|%19s|%5d|%7.1f|\n", (i + 1),
                        listStudent.get(i).getID(),
                        listStudent.get(i).getName(),
                        listStudent.get(i).getAge(),
                        listStudent.get(i).getScore());
                isExist = true;
            }

        }

        if (!isExist) {
            System.out.println("This name not found!");
        }
    }

    @Override
    public void sortStudentByScore() {
        if (listStudent.isEmpty()) {
            System.out.println("Student list is empty!");
            return;
        }
        Collections.sort(listStudent);
        System.out.println("Sort successfully!");
    }

    @Override
    public void writeFile() {
        try {
            FileWriter writer = new FileWriter("student.txt");
            for (int i = 0; i < listStudent.size(); i++) {
                String content = String.format("|%3d|%8s|%19s|%5d|%7.1f|\n", (i + 1),
                        listStudent.get(i).getID(),
                        listStudent.get(i).getName(),
                        listStudent.get(i).getAge(),
                        listStudent.get(i).getScore());
                writer.write(content);

            }
            writer.close();
            System.out.println("Saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }

    }

    @Override
    public void readFile() {
        System.out.println("Loading from file student.txt.....");
        try {
            File file = new File("student.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arr = data.split("\\|");
                String ID = arr[2].trim();
                String name = arr[3].trim();
                int age = Integer.parseInt(arr[4].trim());
                double score = Double.parseDouble(arr[5].trim());
                Student student = new Student(ID,name,age,score);
                listStudent.add(student);

            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}
