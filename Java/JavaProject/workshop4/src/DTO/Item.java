/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Item {

    protected int value;
    protected String creator;

    public Item() {
    }

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    //getters and setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void output() {
        System.out.println("Value: " + value);
        System.out.println("Creator: " + creator);
    }

    public void input() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Value: ");
        value = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Creator: ");
        creator = sc.nextLine();
        if (value < 0 || creator.equals("")) {
            throw new Exception();
        }
    }
}
