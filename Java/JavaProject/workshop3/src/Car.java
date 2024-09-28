/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author manhpthe172481
 */
public class Car {

    String Colour;
    int EnginePower;
    boolean Convertible;
    boolean ParkingBrake;

    public Car() {
    }

    public Car(String Colour, int EnginePower, boolean Convertible, boolean ParkingBrake) {
        this.Colour = Colour;
        this.EnginePower = EnginePower;
        this.Convertible = Convertible;
        this.ParkingBrake = ParkingBrake;
    }

    // Getters
    public String getColour() {
        return Colour;
    }

    public int getEnginePower() {
        return EnginePower;
    }

    public boolean isConvertible() {
        return Convertible;
    }

    public boolean isParkingBrake() {
        return ParkingBrake;
    }

    // Setters
    public void setColour(String Colour) {
        this.Colour = Colour;
    }

    public void setEnginePower(int EnginePower) {
        this.EnginePower = EnginePower;
    }

    public void setConvertible(boolean Convertible) {
        this.Convertible = Convertible;
    }

    public void setParkingBrake(boolean ParkingBrake) {
        this.ParkingBrake = ParkingBrake;
    }

    // Logic methods
    public void pressStartButton() {
//        print out the message “You have pressed the start button”
        System.out.println("You have pressed the start button");
    }

    public void pressAcceleratorButton() {
//        print out the message “You have pressed the Accelerator button”
        System.out.println("You have pressed the Accelerator button");
    }

    public void output() {
//        The method output(): print out values of all fields
        System.out.println("Colour: " + getColour());
        System.out.println("EnginePower: " + getEnginePower());
        System.out.println("Convertible: " + isConvertible());
        System.out.println("ParkingBrake: " + isParkingBrake());
    }
}
