/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author manhpthe172481
 */
public class Menu {

    private int response;
    private final Scanner sc = new Scanner(System.in);

    //For the menu list
    public int int_getChoice(ArrayList<String> options) {
        for (String i : options) {
            System.out.println(i);
        }
        System.out.print("Please choose an option 1..11: ");
        response = sc.nextInt();
        return response;
    }

    //Print brandList and Get user choice as an integer
    public int int_getChoice(BrandList brand) {
        int n = brand.size();
        for (int i = 0; i < n; i++) {
            System.out.println("" + (i + 1) + ". " + brand.get(i));
        }
        System.out.print("Please choose an option 1..11: ");
        response = sc.nextInt();
        return response;
    }

    //Get user choice as an object in the list
    public Brand ref_getChoice(BrandList brandlist) {
        int N = brandlist.size();
        System.out.println("Brand ID List:");   
        do {
            response = int_getChoice(brandlist);
        } while ((response < 0) || (response > N));
        return brandlist.get(response - 1); // trả về 1 đối tượng thuộc lớp Brand 
    }
}
