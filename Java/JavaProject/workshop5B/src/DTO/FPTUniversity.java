/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author manhpthe172481
 */
public class FPTUniversity extends University implements Role {

    String address;

    @Override
    public void createWorker() {
        System.out.println("providing human resources");
    }

    public FPTUniversity() {
    }

    public FPTUniversity(int size, String name, String address) {
        super(size, name);
        this.address = address;
    }
    //getter setter

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    // end getter setter

    @Override
    public String toString() {
        return "FPTU has four campuses Hanoi, HCM, DaNang, CanTho, QuyNhon";
    }

}
