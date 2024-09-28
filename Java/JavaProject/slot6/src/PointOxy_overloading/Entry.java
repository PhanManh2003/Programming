/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PointOxy_overloading;

/**
 *
 * @author manhpthe172481
 */
public class Entry {

    public static void main(String[] args) {
        Point p1 = new Point(1.5, 6.7);
        Point p2 = new Point(2.8, 3.2);
        System.out.println(p1.distance(p2));
        System.out.println(p1.distance(2.34, 7.8));
    }
}
