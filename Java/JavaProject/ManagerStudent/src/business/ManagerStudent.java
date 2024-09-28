package business;

import entity.Course;
import entity.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import utils.Validator;

public class ManagerStudent {

    private ArrayList<Student> list;
    private boolean generated;

    public ManagerStudent() {
        list = new ArrayList<>();
        generated = false;
    }

    public ArrayList<Student> getList() {
        return list;
    }

    public void setList(ArrayList<Student> list) {
        this.list = list;
    }

    public boolean isGenerated() {
        return generated;
    }

    public void setGenerated(boolean generated) {
        this.generated = generated;
    }

    public void generateStudent() throws Exception {
        this.add(new Student("s1", "Phan Manh", "Fall2023", Course.JAVA));
        this.add(new Student("s1", "Phan Manh", "Fall2024", Course.JAVA));
        this.add(new Student("s1", "Phan Manh", "Fall2023", Course.C_CPP));
        this.add(new Student("s1", "Phan Manh", "Fall2023", Course.DOTNET));
        this.add(new Student("s2", "Do Hung Dung", "Sum2024", Course.JAVA));
        this.add(new Student("s2", "Do Hung Dung", "Sum2024", Course.DOTNET));
        this.add(new Student("s3", "Dang Van Lam", "Sum2024", Course.JAVA));
        this.add(new Student("s3", "Dang Van Lam", "Sum2024", Course.DOTNET));
        this.add(new Student("s4", "Nguyen Tien Linh", "Spring2023", Course.JAVA));
        this.add(new Student("s4", "Nguyen Tien Linh", "Spring2023", Course.C_CPP));
    }

    // check duplicated record: phải hiểu student ở đây là record, 
    // có thể trùng id vẫn dc ( id giống nhau thì tên giống nhau)
    public boolean isExisted(Student student) {
        for (Student students : list) {
            if (students.getId().equals(student.getId())
                    && students.getSemester().equals(student.getSemester())
                    && students.getCourseName().equals(student.getCourseName())) {
                return true;
            }
        }
        return false;
    }

    //1. Add
    public boolean add(Student student) throws Exception {
        if (isExisted(student)) {
            throw new Exception("This record is existed!");
        }
        return list.add(student);
    }

    //2. Find and Sort
    public ArrayList<Student> getListStudentById(String id) {
        ArrayList<Student> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public ArrayList<Student> getListStudentByName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudentName().toLowerCase().contains(name.toLowerCase())) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public void sortStudentsByName() {
        Collections.sort(list);
    }

    @Override
    public String toString() {
        if (list.isEmpty()) {
            return null;
        }
        String str = String.format("|%5s|%15s|%10s|%15s|\n", "No.", "Student Name",
                "Semester", "Course Name");
        for (int i = 0; i < list.size(); i++) {
            str += String.format("|%5s|%15s|%10s|%15s|\n", i + 1,
                    list.get(i).getStudentName(),
                    list.get(i).getSemester(),
                    list.get(i).getCourseName().getLanguage());
        }
        return str;
    }

    // 3. update
    public int getIndexRecord(Student student) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(student)) {
                return i;
            }
        }
        return -1;
    }

    public void update(Student oldStudentRecord, Student newStudentRecord) throws Exception {
        if (list.isEmpty()) {
            throw new Exception("List is empty cannot update");
        }
        if (!isExisted(oldStudentRecord)) {
            throw new Exception("This record not found!");
        } else {
            if (isExisted(newStudentRecord)) {
                throw new Exception("New record is duplicate!");
            }
            list.set(getIndexRecord(oldStudentRecord), newStudentRecord);
        }
    }

    // 4. delete
    public boolean delete(Student student) throws Exception {
        if (list.isEmpty()) {
            throw new Exception("List is empty, can not delete");
        }
        if (!isExisted(student)) {
            throw new Exception("This record can not found!");
        }
        return list.remove(student);
    }

    //5. report
    public HashMap<String, Integer> generateReport() {
        HashMap<String, Integer> reports = new HashMap<>();
        for (Student student : list) {
            String key = student.getId() + "#" + student.getStudentName()
                    + "#" + student.getCourseName().getLanguage();
            reports.put(key, reports.getOrDefault(key, 0) + 1);
        }
        return reports;
    }

    public String report() {
        if (list.isEmpty()) {
            return null;
        }
        HashMap<String, Integer> reports = generateReport();
        String str = String.format("|%5s|%15s|%10s|%15s|\n", "No.",
                "Student Name", "Course", "Total of Course");
        int count = 1;
        for (String key : reports.keySet()) {
            String[] parts = key.split("#");
            String studentName = parts[1];
            String courseName = parts[2];
            int totalOfCourse = reports.get(key);
            str += String.format("|%5s|%15s|%10s|%15s|\n", count++,
                    studentName, courseName, totalOfCourse);
        }
        return str;
    }
}
