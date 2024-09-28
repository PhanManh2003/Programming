package view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import utils.Validator;

public class Main {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int age = Validator.getInt("Enter age: ", "Age must be from 18-50", 
//                "Please enter integer", 18, 50);
//        System.out.println("Age: " + age);
//        double salary = Validator.getDouble("Enter salary: ", "Please enter > 0",
//                "Please enter real number", Double.MIN_VALUE, Double.MAX_VALUE);
//        System.out.println("Salary: " + salary);
//
//        String code = Validator.getString("Enter code: ", 
//                "Please enter format SExxxxxx(x is digit)", "SE\\d{6}");
//        System.out.println("Code: " + code);
//        
        // Enter birthday dd/mm/yyyy
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, 01, 01);
        Date date = Validator.getDate("Enter birthday: ", 
                "Please enter Date not exceed current date",
                "Date format must be dd/MM/yyyy", "dd/MM/yyyy",
                calendar.getTime(), new Date());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(dateFormat.format(date)); // format để convert Date sang string
    }

}
