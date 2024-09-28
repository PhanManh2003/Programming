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
public class Statue extends Item {

    private int weight;
    private String colour;

    public Statue() {
    }

    public Statue(int value, String creator, int weight, String colour) {
        super(value, creator);
        this.weight = weight;
        this.colour = colour;
    }

    // getters and setters
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String getCreator() {
        return creator;
    }

    @Override
    public void setCreator(String creator) {
        this.creator = creator;
    }

    // output
    public void outputStatue() {
        super.output();
        System.out.println("Weight: " + weight);
        System.out.println("Colour: " + colour);
    }
    
    // input
    public void inputStatue() {
        try {
            super.input();
            Scanner sc = new Scanner(System.in);
            System.out.print("Input weight: ");
            weight = sc.nextInt();
            sc.nextLine();
            System.out.print("Input colour: ");
            colour = sc.nextLine();

        } catch (Exception e) {
            System.out.println("Wrong input");
        }
    }
}
