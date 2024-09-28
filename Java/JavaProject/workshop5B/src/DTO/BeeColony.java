/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author manhpthe172481
 */
public class BeeColony extends Colony implements Role {

    String type;

    public BeeColony() {
    }

    public BeeColony(int size, String place, String type) {
        super(size, place);
        this.type = type;
    }

    // getter setter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }
    // end  getter setter

    @Override
    public void createWorker() {
        System.out.println("Worker bees perform all the work of the bees");
    }

    @Override
    public String toString() {
        return "the colony's type is " + type + ", size is about "
                + size + ", and the place is " + place;
    }

}
