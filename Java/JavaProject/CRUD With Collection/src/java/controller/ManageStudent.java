package controller;

import entity.Student;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManageStudent {

    private static List<Student> list = new ArrayList<>();

    public List<Student> getList() {
        return list;
    }

    public void add(Student student) {
        list.add(student);
    }

    public void update(Student student) {
        for (Student student1 : list) {
            if (student1.getId().equals(student.getId())) {
                student1.setName(student.getName());
                student1.setGender(student.isGender());
                student1.setAge(student.getAge());
                student1.setHobbies(student.getHobbies());
            }
        }
    }

    public void delete(String id) {
// Dùng iterator xóa để tránh ConcurrentModificationException
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId().equalsIgnoreCase(id)) {
                iterator.remove(); // An toàn xóa phần tử
            }
        }

    }

    List<Student> search(String keyword) {
        List<Student> listSearch = new ArrayList<>();
        //upper case
        keyword = keyword.toUpperCase();

        for (Student student : list) {
            if (student.getName().toUpperCase().contains(keyword)) {
                listSearch.add(student);
            }
        }
        return listSearch;
    }
}
