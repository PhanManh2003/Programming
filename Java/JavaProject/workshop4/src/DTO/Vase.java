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
public class Vase extends Item {

    private int height;
    private String material;

    public Vase() {
    }

    public Vase(int value, String creator, int height, String material) {
        super(value, creator);
        this.height = height;
        this.material = material;
    }

    // getters and setters
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    // output
    public void outputVase() {
        super.output();
        System.out.println("Height: " + height);
        System.out.println("Material: " + material);

    }

    // input 
    public void inputVase() {
        try {
            super.input();
            Scanner sc = new Scanner(System.in);
            System.out.print("Input height: ");
            height = sc.nextInt();
            sc.nextLine();
            System.out.print("Input material: ");
            material = sc.nextLine();

        } catch (Exception e) {
            System.out.println("Wrong input");
        }
    }
}
