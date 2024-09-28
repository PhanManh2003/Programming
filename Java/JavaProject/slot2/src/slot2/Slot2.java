/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slot2;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Slot2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        //  Scanner là 1 lớp để nhập dữ liệu    
        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter a: ");
//        int a = sc.nextInt();
//        System.out.print("Value of a: ");
//        System.out.println(a); // println = print + \n
//
//        // nhập chuỗi
//        sc.nextLine(); // ignore kí tự \n
//        System.out.print("Enter name: ");
//        String name = sc.nextLine(); // nhập chuỗi có dấu cách, next() thì không
//        System.out.println("Name: " + name);
//
//        // nhập double
//        System.out.print("Enter b: ");
//        double b = sc.nextDouble();
//        System.out.printf("Value of b: %.2f", b);

        // try  catch (giống try except trong python)
//        int a = 0;
//        while (true) {
//            System.out.print("Enter age: ");
//            try {
//                a = Integer.parseInt(sc.nextLine());
//                if (a < 0 || a > 100) {
//                    System.out.println("Tuoi phai tu 0 - 100");
//                } else {
//                    break;
//                }
//            } catch (Exception e) {
//                System.out.println("Nhap sai kieu du lieu");
//                // sc.next(); // xóa kí tự enter trong bộ đệm
//            }
//        }
//        System.out.println("Value of age: " + a);
//
//        //　Nhập kí tự từ bàn phím
//        char x = sc.next().charAt(0); // .charAt(0) extracts the first character of that token.
//        System.out.println((char) (x + 1));
//       
//        // So sánh 2 chuỗi
//        String a = sc.next();
//        String b = sc.next();
////        if (a.equals(b)) {
////            System.out.println("two people have the same name");
////        } else {
////            System.out.println("two people don't have the same name");
////        }
//
//        if (a.compareTo(b)==0) {
//            System.out.println("two people have the same name");
//        } else {
//            System.out.println("two people don't have the same name");
//        }
//        
//        String s = sc.next();
//        for (char c = '0'; c <= '9'; c++) {
//            s = s.replace(c + "", ""); // c + "" để chuyển biến c từ kiểu char sang kiểu string 
//        }
//        System.out.println(s);
//--------------------------------Bai tap------------------------------
//      Bt1: Nhập số tự nhiên n > 0 rồi in ra n số fibonaci
//        int n = 0;
//        while (true) {
//            System.out.print("Enter n > 0: ");
//            try {
//                n = Integer.parseInt(sc.nextLine());
//                if (n <= 0) {
//                    System.out.println("please enter n > 0");
//                } else {
//                    break;
//                }
//            } catch (Exception e) {
//                System.out.println("Nhap sai kieu du lieu");
//            }
//        }
//
//        int prev = 1;
//        int next = 1;
//        int sum = 0;
//        if (n == 1) {
//            System.out.print("1");
//        } else if (n == 2) {
//            System.out.print("1 1");
//        } else {
//            System.out.print("1 1 ");
//            int count = 0;
//            while (true) {
//                sum = prev + next;
//                System.out.print(sum + " ");
//                prev = next;
//                next = sum;
//                count++;
//                if (count == n - 2) {
//                    break;
//                }
//            }
//
//        }
//        BT2: Nhập 1 số rồi kiểm tra số đó có phải số Amstrong hay không?
        int n = 0;
        while (true) {
            System.out.print("Enter n > 0: ");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n <= 0) {
                    System.out.println("please enter n > 0");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Nhap sai kieu du lieu");
            }
        }
        double sum = 0 ;
        int prev_n = n;
        while(n !=0 ){
            sum += Math.pow((double)(n%10),3);
            n /= 10;
        }
        if ((int)sum == prev_n) {
            System.out.println("Amstrong");
        } else {
            System.out.println("Not Amstrong");
        }
        
        

    }
}
