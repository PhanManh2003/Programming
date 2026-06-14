package fa.training.entities;

import java.util.Scanner;

public abstract class Multimedia {

    private String name;
    private double duration;

    public Multimedia() {
    }

    public Multimedia(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    //getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    // concrete method
    public void createMultimedia() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter duration: ");
        this.duration = Double.parseDouble(scanner.nextLine());
    }

    @Override
    public abstract String toString();
}
