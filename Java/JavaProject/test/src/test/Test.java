/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Admin
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Mọi chương trình Java đều phải có một phương thức main để bắt đầu thực thi.
        // TODO code application logic here
        for (char c = '0'; c <= '9'; c++) {
            System.out.print(c);
        }
        System.out.println();
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(c);
        }
        
        System.out.println(37 * 56);
        System.out.printf("%d\n", 3 + 9); // java kế thừa C 
        System.out.println("125 + 206 = " + (125 + 206));
        String name = "Mạnh";
        System.out.println("Hello " + name);

        // double
        double a = 10.5;
        int b = 7;
        System.out.println("a / b = " + (a / b));

        // char
        char d = 'a' + 3;
        System.out.println(d);

        // boolean 
        boolean x = true;
        System.out.println(x);

        /* Data type:
        byte	1byte	-127 to 127
        char	2bytes	0 to 65535
        short	2bytes	-32768 to 32767
        int	4bytes	-2147483648 to 2147483647
        long	8bytes	-(263) to (263) - 1
        float	4bytes	
        double	8bytes	
         */
        
    }

}
