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
public class Painting extends Item {

    private int height;
    private int width;
    private boolean isWatercolour;
    private boolean isFramed;

    public Painting() {
    }

    public Painting(int value, String creator, int height, int width, boolean isWatercolour, boolean isFramed) {
        super(value, creator);
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFramed = isFramed;
    }

    //setters and getters

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isIsWatercolour() {
        return isWatercolour;
    }

    public void setIsWatercolour(boolean isWatercolour) {
        this.isWatercolour = isWatercolour;
    }

    public boolean isIsFramed() {
        return isFramed;
    }

    public void setIsFramed(boolean isFramed) {
        this.isFramed = isFramed;
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
    public void outputPainting() {
        super.output();
        System.out.println("Height: " + height);
        System.out.println("Width: " + width);
        System.out.println("isWatercolour: " + isWatercolour);
        System.out.println("isFramed: " + isFramed);
    }

    // input
    public void inputPainting() {
        try {
            super.input();
            Scanner sc = new Scanner(System.in);
            System.out.print("Input height: ");
            height = sc.nextInt();
            System.out.print("Input width: ");
            width = sc.nextInt();
            System.out.print("Is water colour: ");
            isWatercolour = sc.nextBoolean();
            System.out.print("Is framed: ");
            isFramed = sc.nextBoolean();
        } catch (Exception e) {
            System.out.println("Wrong input");
        }
    }
}
